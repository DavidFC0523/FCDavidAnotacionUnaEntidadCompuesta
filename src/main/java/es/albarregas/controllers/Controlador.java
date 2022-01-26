package es.albarregas.controllers;


import es.albarregas.beans.Codigo;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.beans.Profesor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IProfesorDAO pdao = daof.getProfesorDAO();

        Profesor profesor = new Profesor();
        Codigo codigo = new Codigo();
        String url = null;
        switch (request.getParameter("op")) {
            case "add":

                try {
                    //Llenamos codigo                     
                    BeanUtils.populate(codigo, request.getParameterMap());
                    //añadimos codigo a profesor
                    BeanUtils.copyProperty(profesor, "codigo", codigo);
                    //Añadimos profesor
                    BeanUtils.populate(profesor, request.getParameterMap());
                  
                    
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                //Llamamos al metodo dao para insertar profesor 
                pdao.add(profesor);
                url = "index.jsp";
                break;
            case "delete":
                
                String Cod = request.getParameter("registro");
                String[] parts = Cod.split(",");
                codigo.setId(Integer.parseInt(parts[0]));
                codigo.setTipo(parts[1]);
                //enviamos codigo para borrar profesor
                profesor = pdao.getOne(codigo);
                
                pdao.delete(profesor);
                url = "index.jsp";
                break;
            case "update":
                //Hacemos splir para saber los codigos que necesitamos y cargamos codigos
                 Cod = request.getParameter("registro");
                 parts = Cod.split(",");
                codigo.setId(Integer.parseInt(parts[0]));
                codigo.setTipo(parts[1]);
              //obtenemos el profesor ha actualizar y lo mandamos a la pagina como atributo de peticion
                profesor = pdao.getOne(codigo);
                System.out.println(profesor);
                request.setAttribute("profesor", profesor);
                url = "JSP/formularioActualizar.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
