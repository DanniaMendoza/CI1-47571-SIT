<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Css/sweetalert.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <title>Vehiculos</title>

    </head>

    <body class="hold-transition skin-blue sidebar-mini">

        <div class="wrapper">
            <section class="content-header">
                <div class="box">    
                    <div class="box-header with-border">             
                        <h1 class="box-title"><b>Listado de Vehiculos</b></h1>
                    </div>

                    <section class="content-header">
                        <a href="SvTransporte?accion=mostrarFormVehiculo" class="btn btn-success">
                            <i class="fa fa-plus"></i> Agregar Vehiculo </a>
                    </section>
                    <ol class="breadcrumb">
                        <li><a href="SvUsuarios?accion=paginaInicio"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        
                    </ol>
                    <div class="box-body">
                        <div class="table-responsive">                                 
                            <table class="table table-bordered table-striped dataTable table-hover" id="tablaUsuarios" class="display">
                                <thead>
                                    <tr>
                                        <th>Id vehiculo</th>
                                        <th>Id conductor</th>
                                        <th>Nombre Conductor</th>
                                        <th>Marca</th>
                                        <th>Modelo</th>
                                        <th>Año</th>
                                        <th>Placa</th>
                                        <th>Estado vehiculo</th>
                                        <th>Estado</th>



                                    </tr>
                                </thead>
                                <c:forEach var="user" items="${listar}" varStatus="iteracion">                                                    
                                    <tr>
                                        <td>${iteracion.index + 1}</td>
                                        <td>${user.id_Conductor.id_usuario}</td>
                                        <td>${user.id_Conductor.nombreUsuario}</td>
                                        <td>${user.marca}</td>
                                        <td>${user.modelo}</td>
                                        <td>${user.anio}</td>
                                        <td>${user.numeroPlaca}</td>
                                        <td>${user.estadoMantenimiento}</td>

                                        <!-- ESTADO -->
                                        <c:if test="${user.estado == true}">
                                            <td><span class="badge bg-green active">Vehiculo Activo</span></td> 
                                        </c:if>
                                        <c:if test="${user.estado == false}">
                                            <td><span class="badge bg-red active">Vehiculo Inactivo</span></td> 
                                        </c:if>


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
            <!-- /.content -->
        </div>

        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>
        <script src="bower_components/datatables.net/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script src="js/sweetalert.js" type="text/javascript"></script>
        <script src="js/funcionesUsuario.js" type="text/javascript"></script>


        <script>
            $(document).ready(function () {
                $('#tablaUsuarios').DataTable();
            });
        </script>
    </body>
</html>
