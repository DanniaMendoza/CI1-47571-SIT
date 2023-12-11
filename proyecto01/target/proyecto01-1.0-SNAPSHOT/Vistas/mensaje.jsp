<%-- 
    Document   : mensaje
    Created on : 4 nov. 2023, 15:48:30
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
                   <div class="${config}" role="alert">
                ${mensaje}!
            </div>
            <div>
                <a href="SvTarjeta?accion=principal">Volver</a>
            </div>
        </div>  
    </body>
</html>
