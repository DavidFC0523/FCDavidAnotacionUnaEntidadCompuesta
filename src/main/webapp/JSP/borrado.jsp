<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrado</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>


        <h2>Elige uno para eliminar</h2>


        <div class="row justify-content-center" >


            <form method="post" action="control">
                <input type="hidden" name="op" value="delete">
                <table class="table table-striped" style="width: 500px">
                    <c:forEach var="item" items="${listado}">
                        <tr>
                            <!--En el value meto el id y el tipo separados por una coma para hacer split en el controladoer-->
                            <td><input type="radio" name="registro" value="${item.codigo.id},${item.codigo.tipo}" /></td>
                            <td>${item.nombre} ${item.ape1} ${item.ape2}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="2"><input type="submit" value="Eliminar" class="btn-primary" /></td>
                    </tr>
                </table>
            </form>
        </div>



    </body>
</html>