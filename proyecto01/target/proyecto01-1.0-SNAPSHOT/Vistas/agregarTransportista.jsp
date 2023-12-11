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
        <title>Agregar Usuario</title>
    </head>

    <body class="">

        <!-- Contenido FORMULARIO -->
        <div class="wrapper">
            <section class="content">
                <div class="box">
                    <div class="box-header with-border">
                        <i class="fa fa-edit"></i> <h3 class="box-title">Registrar Nuevo Transportista</h3>  
                    </div>

                    <!-- --------FORMULARIO----------- -->
                    <form class="form-horizontal" action="SvTransportista?accion=registrarUsuario" method="POST">
                        <div class="box-body">

                            <!-- NOMBRE USUARIO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="nombre" type="text" class="form-control" placeholder="Ejm: Jakheline" name="txtNombre" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- APELLIDO PATERNO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Primer apellido</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="apellidoPaterno" type="text" class="form-control" placeholder="Primer apellido" name="txtApePa" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- APELLIDO PATERNO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Segundo Apellido</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="apellidoMaterno" type="text" class="form-control" placeholder="Segundo Apellido" name="txtApeMa" maxlength="20"
                                           value="">
                                </div>
                            </div>

                            <!-- Dni -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Documento de Identidad</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="dni" type="text" class="form-control" placeholder="Documento de Identidad" name="txtDni" maxlength="8"
                                           value="">
                                </div>
                            </div>

                            <!--CORREO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Correo electronico</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="Correo" type="text" class="form-control" placeholder="Correo electronico" name="txtCorreo" maxlength="40"
                                           value="">
                                </div>
                            </div>

                            <!-- TELEFONO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Número Celular</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input required id="Telefono" type="tel"  class="form-control" placeholder="Ejem: 123456789" name="txtTelefono" maxlength="10"
                                           value="">
                                </div>
                            </div>

                            <!-- CONTRASEÑA -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Contraseña</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input id="nombre" type="password" class="form-control" placeholder="Ejem: ******" name="txtClave" >
                                </div>
                            </div>

                            <!-- ROL DE USUARIO -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Rol</label>
                                <div class="col-sm-4 input-group">
                                    <span class="input-group-addon"><i class="fa fa-tags"></i></span>

                                    <select class="form-control"  name="seleccionRol" autofocus=""  required="">
                                        <option value="0">Seleccione un rol</option>

                                        <c:forEach items="${roles}" var="car">
                                            <option value="${car.idRol}"  
                                                    <c:if test="${car.idRol == 
                                                                  usuarios.rol.idRol}">
                                                          selected
                                                    </c:if>
                                                    >${car.nombreRol}</option>
                                        </c:forEach>


                                    </select>
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
                            <button type="reset" class="btn btn-danger">

                                <a href="${pageContext.request.contextPath}/SvTransportista?accion=listarUsuarios"> 
                                    <i class="fa fa-close red"></i> Cancelar</button>
                                    
                                    
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
