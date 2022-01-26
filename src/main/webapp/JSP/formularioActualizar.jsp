<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <h2>Actualizaci&oacute;n de datos</h2>
        <br>
        <div class="row justify-content-center" >

            <form method="post" action="conclusion">
                <input type="hidden" name="op" value="update">
                <table  class="table table-striped" style="width: 500px">
                    <tr>
                        <td>Código:</td>
                        <td><input type="text" name="id1" value="${profesor.codigo.id}" disabled="disabled"/></td>
                    <input type="hidden" name="id" value="${profesor.codigo.id}">
                    </tr>
                    <tr>
                        <td>Tipo</td>
                        <td><input type="text" name="tipo1" value="${profesor.codigo.tipo}" disabled="disabled"/></td>
                    <input type="hidden" name="tipo" value="${profesor.codigo.tipo}">
                    </tr>

                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" value="${profesor.nombre}" required/></td>
                    </tr>
                    <tr>
                        <td>Apellido 1</td>
                        <td><input type="text" name="ape1" value="${profesor.ape1}" required/></td>
                    </tr>
                    <tr>
                        <td>Apellido 2</td>
                        <td><input type="text" name="ape2" value="${profesor.ape2}" /></td>
                    </tr>

                    <tr>
                        <td>Selected</td>
                        <td>   
                            <select name="escala">
                                <option value="s" selected>s</option>                                    
                                <option value="t" selected >t</option>
                            </select>
                        </td>
                    </tr>
                    <td>
                        Fecha
                    </td>
                    <td>
                        <input type="datetime-local" name="fecha" required>
                    </td>
                    <tr>

                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="btn-primary" /></td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>