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
        <title>Agregar Ruta</title>
    </head>

    <body class="">

        <!-- Contenido FORMULARIO -->
        <div class="wrapper">
            <section class="content">
                <div class="box">
                    <div class="box-header with-border">
                        <i class="fa fa-edit"></i> <h3 class="box-title">Registrar Ruta</h3>  
                    </div>

                    <!-- --------FORMULARIO----------- -->
                    <form class="form-horizontal" action="SvRol?accion=registrarRol" method="POST">
                        <div class="box-body">

                            <!-- NOMBRE ROL -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Nombre de Rol</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input id="nombreRol" type="text" class="form-control" placeholder="Ejm: Supervisor" name="txtNombreRol" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- ESTADO DE USUARIO -->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="chkEstadoRol" checked=""> Activo
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
