<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="css/CompraTarjeta.css">
        <title>Document</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
        crossorigin="anonymous"></script>
    </head>

    <body>

        <div>
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
                                    Actividades
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/Vistas/CompraTarjeta.jsp">Compra de Tarjeta</a></li>
                                    <li><a class="dropdown-item" href="/Vistas/Carga.jsp">Cargar tarjeta</a></li>
                                    <li><a class="dropdown-item" href="/Vistas/Cobro.jsp">Cobro de tarjeta</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="SvUsuarios?accion=cerrar">Cerrar Sesion</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div >

        <div class="bloque">

            <section class="aviso">
                <img class="aviso__imagen1" src="imagenes2/pngtree-beautiful-payment-method-vector-glyph-icon-png-image_1870008.jpg" alt="" height="500">
            </section>

            <section class="contenedorN">
                <form>
                    <h1 class="titulo">Pago con tarjeta</h1>

                    <div class="titulo_opciones">
                        <div class="titulo_opciones_inputbox">
                            <label for="" class="letra">Codigo de tarjeta</label>
                            <input type="text" name="codigo" required>
                        </div>
                        <div class="titulo_opciones_inputbox">
                            <label for="" class="letra">Ruta destino </label>
                            <input type="text" name="codigo" required>
                        </div>
                        <div>
                            <label for="" class="letra">Monto</label>
                            <input type="text" name="monto" required>
                        </div>

                    </div>
                </form>
            </section>

            <form >


                <button name="registro">Aceptar</button>
                <button name="registro">Cancelar</button>
            </form>









        </div>
        <h2 class="cajita"></h2>
        <!--pie pagina (footer)-->


        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

