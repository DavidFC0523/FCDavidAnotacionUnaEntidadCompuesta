<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <h2>Actualizaci&oacute;n de datos</h2>
        <div class="row justify-content-center" >

            <form method="post" action="control">
                <input type="hidden" name="op" value="add">
                <table class="table table-striped" style="width: 500px">

                    <tr>
                        <td>Identificador</td>
                        <td><input type="text" name="id" required/></td>
                    </tr>
                    <tr>
                        <td>Tipo</td>
                        <td><input type="text" name="tipo" required/></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" required/></td>
                    </tr>
                    <tr>
                        <td>Apellido 1</td>
                        <td><input type="text" name="ape1"  required/></td>
                    </tr>
                    <tr>
                        <td>Apellido 2</td>
                        <td><input type="text" name="ape2" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="btn-primary" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>