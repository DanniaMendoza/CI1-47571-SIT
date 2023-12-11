<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% if (session.getAttribute("usuario") != null) {%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>SIT-usuario</title>

        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
        <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet"
              type="text/css" />
        <link href="Css/sweetalert.css" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>


    <body>
        <!--
          <nav class="navbar bg-primary  navbar-expand-lg bg-body-tertiary"  data-bs-theme="dark">
          <div class="container-fluid">
              <a class="navbar-brand" href="#">SIT</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                  <ul class="navbar-nav">
                      <li class="nav-item">
                          <a class="nav-link active" aria-current="page" href="#">Home</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="#">Quienes Somos</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="#">Mision</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="#">Vision</a>
                      </li>
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              Gestion de Datos
                          </a>
                          <ul class="dropdown-menu">
                              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/SvUsuarios?accion=listarUsuarios">Administrar Usuarios</a></li>
                              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/SvRol?accion=listarRoles"">Administrar Roles</a></li>
                              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/SvUsuarios?accion=listarRoles"">Administrar Transportista</a></li>
                              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/SvTransporte?accion=listarVehiculos"">Administrar Vehiculo</a></li>
                              <li><a class="dropdown-item" href="ListaProRutas.jsp">Administrar Programación de Rutas</a></li>
                          </ul>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="SvUsuarios?accion=cerrar">Cerrar Sesion</a>
                      </li>
                  </ul>
              </div>
          </div>
      </nav>
  
        -->


        <aside class="main-sidebar pl-3">
            <section class="sidebar ">
                <div class="user-panel">
                    <div class="pull-left image ">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                        <h4 class="text-primary">Bienvenida ${usuario.nombreUsuario}</h4>
                    </div>
                </div>
                <!-- 
                <form action="#" method="get" class="sidebar-form">
                  <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                      <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                      </button>
                    </span>
                  </div>
                </form>
                -->
                <ul class="sidebar-menu" data-widget="tree">
                    <li class="header">INICIO</li>
                    <!-- Optionally, you can add icons to the links -->
                    <li class="active "><a href="#"> <span>Panel Administrativo</span></a></li>
                    <li class="">
                        <a href="${pageContext.request.contextPath}/SvUsuarios?accion=listarUsuarios"><i
                                class="glyphicon glyphicon-th-large"></i> <span>Administrar Usuarios</span></a>
                    </li>
                    <li class="">
                        <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Transportistas</span></a>
                    </li>
                    <li class="">
                        <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Vehiculo</span></a>
                    <li class="treeview">
                        <a href="${pageContext.request.contextPath}/SvRol?accion=listarRoles"><i
                                class="glyphicon glyphicon-th-large"></i> <span>Administrar Roles</span></a>
                    </li>
                    <li class="">
                        <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Rutas</span></a>
                    </li>
                    <li class="">
                        <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Reportes</span> </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="SvUsuarios?accion=cerrar">Cerrar Sesion</a>
                    </li>
                </ul>
            </section>
        </aside>

        <div class="content-wrapper">

            <section class="content-header ">
                <div class="box pl-4">
                    <div class="box-header with-border">
                        <h1 class="box-title" style="text-align: center; width:100%" ><b>BIEVENIDO AL SISTEMA DE TRANSPORTES INTEGRAL AREQUIPA</b></h1>
                    </div>
                    <img class="" style="width: 1100px; padding-left: 50px" src="https://arequipamistipress.com/wp-content/uploads/2023/08/SIT-AREQUIPA.jpg" alt="Sistema integrado de transporte">
                </div>
            </section>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="dist/js/adminlte.min.js"></script>
    </body>

</html>
<% } else {
        response.sendRedirect("index.jsp");
    }%>