<%-- 
    Document   : PagoContado
    Created on : 9 nov. 2023, 08:51:43
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
                    <a class="nav-link active" aria-current="page" href="index.html">Home</a>
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
                      <li><a class="dropdown-item" href="CompraTarjeta.jsp">Compra de Tarjeta</a></li>
                      <li><a class="dropdown-item" href="TarjetaAgregarServlet?accion=listar">Cargar tarjeta</a></li>
                      <li><a class="dropdown-item" href="TarjetaAgregarServlet?accion=cobro">Cobro de tarjeta</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </div >

                
                
       
     <div class="bloque">

         
                 
        <section class="aviso">
            <img class="aviso__imagen1" src="imagenes2/PagoContado.jpg" alt="" height="400">
        </section>
         
        <section class="contenedorP">
            <div class="d-flex">
           <a class="btn btn-outline-primary" href="SvTarjeta?accion=principal">Tarjeta de Credito</a> 
           <a class="btn btn-outline-primary ml-2" href="SvTarjeta?accion=pYape">Pago Yape</a> 
           
        </div>
            <form action="SvTarjeta" method="POST" >
             
                <h2 class="contenedorP__h2">Pago al Contado</h2>

                <div class="contenedorP__inputbox">
                    <ion-icon name="qr-code-outline"></ion-icon>
                    <input type="text" name="cvv" required>
                    <label for="">Numero de DNI</label>
                </div>
              
                <div class="contenedorP__precio">
                    <img src="imagenes2/shopping-cart-flat-icon-on-1814668.jpg" alt="" width="50px">
                    <h3 class="costo">$/16.00</h3>
                </div>
                <button type="submit" name="accion" value="agregar" class="btn btn-primary btn-sm">Aceptar</button>
                <button name="cancelar">Cancelar</button>
            </form>
    

            

          
        </section>

        

    </div>
    <h2 class="cajita"></h2>
    <!--pie pagina (footer)-->


    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    
</body>
</html>

