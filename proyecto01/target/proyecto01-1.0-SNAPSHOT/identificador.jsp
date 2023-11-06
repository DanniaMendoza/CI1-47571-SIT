<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sistema | Iniciar Session</title>
    </head>
    <body>
        <div>
            <div>
                <h1><b>Sistema SIT </b></h1>
            </div>
            <form action="usuarioControlador?accion=verificar" method="POST">
                <div class="form-group has-feedback">
                    <input type="text" name="txtUsu" id="txtUsu" value="" class="form-control"  placeholder="Usuario">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" name="txtPass" id="txtPass" value="" class="form-control" placeholder="******">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                
                <div class="row">
     
                    <div class="col-xs-4">
                        <input type="submit" name="verificar" value="Verificar" class="btn btn-primary btn-block"/>
                    </div>
          
                </div>
            </form>

        </div>

    </div>

</body>
</html>
