<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
            <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
            <!-- Font Awesome -->
            <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
            <!-- Ionicons -->
            <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
            <!-- Theme style -->
            <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

            <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet"
                type="text/css" />
            <link href="css/sweetalert.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">


            <link rel="stylesheet"
                href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

            <title>Usuarios | Inicio</title>

        </head>

        <body class="hold-transition skin-blue sidebar-mini">
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
                            <a href="${pageContext.request.contextPath}/SvUsuarios?accion=listarUsuarios"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar
                                    Usuarios</span></a>
                        </li>
                       <li class="">
                             <a href="${pageContext.request.contextPath}/SvTransportista?accion=listarUsuarios"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Transportistas</span></a>
                        </li>
                        <li class="">
                            <a href="${pageContext.request.contextPath}/SvTransporte?accion=listarVehiculos"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar
                                    Vehiculo</span></a></li>
                        <li class="">
                            <a href="${pageContext.request.contextPath}/SvRol?accion=listarRoles"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Roles</span></a>
                        </li>
                        <li class="">
                             <a href="${pageContext.request.contextPath}/SvRuta?accion=listarRutas"><i class="glyphicon glyphicon-th-large"></i> <span>Administrar Rutas</span></a>
                        </li>
                        <li class="">
                            <a href="Vistas/buscarServiciosFechas.jsp"><i class="glyphicon glyphicon-th-large"></i> <span>Reportes</span> </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="SvUsuarios?accion=cerrar">Cerrar Sesion</a>
                        </li>
                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">
                    <section class="content-header">
                        <div class="box">
                            <div class="box-header with-border">
                                <h1 class="box-title"><b>DIRECTORIO DE USUARIOS</b></h1>
                            </div>

                            <section class="content-header">
                                <a href="SvUsuarios?accion=mostrarFormulario" class="btn btn-success">
                                    <i class="fa fa-plus"></i> Nuevo Usuario </a>
                            </section>
                            <ol class="breadcrumb">
                                <li><a href="SvUsuarios?accion=paginaInicio"><i class="fa fa-dashboard"></i> Inicio</a>
                                </li>

                            </ol>

                            <div class="box-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped dataTable table-hover"
                                        id="tablaUsuarios" class="display">
                                        <thead>
                                            <tr>
                                                <th>Codigo</th>
                                                <th>Nombre</th>
                                                <th>Apellido Paterno</th>
                                                <th>Apellido Materno</th>
                                                <th>Dni</th>
                                                <th>Correo</th>
                                                <th>Telefono</th>
                                                <th>Rol</th>
                                                <th>Clave</th>
                                                <th>Estado</th>
                                                <th>Acciones</th>
                                                <th>Activar</th>
                                            </tr>
                                        </thead>
                                        <!--  iterar sobre una colección de datos que normalmente se han recuperado previamente de la base de datos.
                                etiqueta de JSTL que itera sobre una colección, en este caso, la lista de usuarios ${listarUsuarios}-->
                                        <c:forEach var="user" items="${listarUsuarios}" varStatus="iteracion">
                                            <tr>
                                                <td>${iteracion.index + 1}</td>
                                                <td>${user.nombreUsuario}</td>
                                                <td>${user.apellidoPaterno}</td>
                                                <td>${user.apellidoMaterno}</td>
                                                <td>${user.dni}</td>
                                                <td>${user.correo}</td>
                                                <td>${user.telefono}</td>
                                                <td>${user.rol.nombreRol}</td>
                                                <td>${user.clave}</td>

                                                <!-- ESTADO -->
                                                <c:if test="${user.estado == true}">
                                                    <td><span class="badge bg-green active">Usuario ${user.estado}</span></td>
                                                </c:if>
                                                <c:if test="${user.estado == false}">
                                                    <td><span class="badge bg-red active">Usuario Inactivo</span></td>
                                                </c:if>

                                                <!-- ACCIONES -->

                                                <td>
                                                    <a href="<c:url value=" SvUsuarios">
                                                        <c:param name="accion" value="leerUsuario" />
                                                        <c:param name="cod" value="${user.id_usuario}" />
                                                        </c:url>">
                                                        <button type="button" class="btn btn-warning"
                                                            data-toggle="tooltip" title="Editar"
                                                            data-original-title="Editar">
                                                            <i class="fa fa-pencil"> </i></button>
                                                    </a>

                                                    <!-- ELIMINAR USUARIOS -->
                                                    <input type="hidden" id="codigo" value="${user.id_usuario}">
                                                    <a id="deleteUser" href="<c:url value=" SvUsuarios">
                                                        <c:param name="accion" value="eliminarUsuario" />
                                                        <c:param name="cod" value="${user.id_usuario}" />
                                                        </c:url>"><button type="button" class="btn btn-danger"
                                                            data-toggle="tooltip" title="Eliminar"
                                                            data-original-title="Eliminar">
                                                            <i class="fa fa-trash"> </i></button>
                                                    </a>

                                                </td>
                                                <td>activar</td>
                                            </tr>
                                        </c:forEach>

                                    </table>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <!--Pie de página-->
                            </div>
                            <!-- /.box-footer-->
                        </div>
                    </section>
                
            </div>

            <script src="bower_components/jquery/dist/jquery.min.js"></script>
            <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
            <script src="dist/js/adminlte.min.js"></script>
            <script src="bower_components/datatables.net/js/jquery.dataTables.min.js" type="text/javascript"></script>
            <script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"
                type="text/javascript"></script>

            <script src="css/sweetalert.js" type="text/javascript"></script>
            <script src="js/funcionesUsuario.js" type="text/javascript"></script>


            <script>
                $(document).ready(function () {
                    $('#tablaUsuarios').DataTable();
                });
            </script>
        </body>

        </html>