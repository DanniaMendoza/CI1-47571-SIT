<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (session.getAttribute("usuario") != null)
    {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <title>SIT-usuario</title>
        <style>
            .dataTables_paginate a, .dataTables_paginate span {
                margin: 0 5px; /* Ajusta la cantidad de espacio entre los elementos */
            }
        </style>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
        crossorigin="anonymous"></script>
    </head>
    <style>
        .dataTables_paginate a, .dataTables_paginate span {
            margin: 0 5px; /* Ajusta la cantidad de espacio entre los elementos */
        }
    </style>
    <title>Pasajero</title>
    <body>
        <nav class="navbar bg-primary  navbar-expand-lg bg-body-tertiary"  data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">SIT</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Menu
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="CompraTarjeta.jsp">Administrar Usuarios</a></li>
                                <li><a class="dropdown-item" href="Cobro.jsp">Pagar pasaje</a></li>
                                <li><a class="dropdown-item" href="Carga.jsp"">Cargar Tarjeta</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="SvUsuarios?accion=cerrar">Cerrar Sesion</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1>Rol ${usuario.rol.nombreRol}</h1>
        <h2>Bienvenida ${usuario.nombreUsuario}</h2>
    </body>
</html>
<%
    } else
    {
        response.sendRedirect("index.jsp");
    }
%>