<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <title>Agregar Vehiculo</title>
    </head>

    <body class="">

        <!-- Contenido FORMULARIO -->
        <div class="wrapper">
            <section class="content">
                <div class="box">
                    <div class="box-header with-border">
                        <i class="fa fa-edit"></i> <h3 class="box-title">Registrar Nuevo Usuario</h3>  
                    </div>

                    <!-- --------FORMULARIO----------- -->
                    <form class="form-horizontal" action="SvUsuarios?accion=registrarUsuario" method="POST">
                        <div class="box-body">

                            <!-- ASIGNAR CONDUCTOR -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Rol</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-tags"></i></span>

                                    <select class="form-control"  name="seleccionConductor" autofocus=""  required="">
                                        <option value="0">Seleccione el conductor</option>

                                        <c:forEach items="${conductores}" var="car">
                                            <option value="${car.id_usuario}"  
                                                    <c:if test="${car.id_usuario == 
                                                                  transporte.id_Conductor.id_usuario}">
                                                          selected
                                                    </c:if>
                                                    >${car.nombreUsuario}</option>
                                        </c:forEach>


                                    </select>
                                </div>                                  
                            </div>

                            <!-- NOMBRE MARCA -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Marca</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="nombre" type="text" class="form-control" placeholder="Marca Vehiculo" name="txtMarca" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- MODELO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Modelo</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="modelo" type="text" class="form-control" placeholder="Modelo Vehiculo" name="txtModelo" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- Año del vehiculo -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Año</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="anio" type="text" class="form-control" placeholder="Año vehiculo" name="txtAnio" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- Placa -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Número de Placa</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="placa" type="text" class="form-control" placeholder="Placa vehiculo" name="txtPlaca" maxlength="8"
                                           value="">
                                </div>
                            </div>

                            <!--Mantenimiento-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Estado de vehiculo</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="mantenimiento" type="text" class="form-control" placeholder="Estado Vehiculo" name="txtMantenimiento" maxlength="40"
                                           value="">
                                </div>
                            </div>

                            <!-- ESTADO DE USUARIO -->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="chkEstado" checked=""> Activo
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="reset" class="btn btn-danger"><i class="fa fa-close red"></i> Cancelar</button>
                            <button type="submit" id="" name="btnRegistrar" value="registrar" class="btn btn-success"><i class="fa fa-floppy-o"></i> Registrar</button>

                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>
            </section> 



        </div>

        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
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
