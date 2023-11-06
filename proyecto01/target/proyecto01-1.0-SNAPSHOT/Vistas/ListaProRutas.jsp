<%@page import="java.util.Iterator"%>
<%@page import="SIT.Entidades.Ruta"%>
<%@page import="java.util.List"%>
<%@page import="SIT.Modelo.RutaDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <title>Rutas-SIT</title>
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
                                    Gestion de Datos
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="ListaUsuario.jsp">Administrar Usuarios</a></li>
                                    <li><a class="dropdown-item" href="ListaProRutas.jsp">Administrar Programacion de Rutas</a></li>
                                    <li><a class="dropdown-item" href="ListaTransportista.jsp">Administrar Transportista</a></li>
                                    <li><a class="dropdown-item" href="ListaVehiculo.jsp">Administrar Transporte</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

        <div class="container">
            <div class=" mt-5">
                <h2 class="text-center">Lista de Programacion de Rutas</h2>
                <div class="text-end">
                    <button class="btn btn-primary " onclick="window.location.href = 'registrarRuta.jsp'">Registrar Ruta</button>
                </div>
                <div class ="col-md-4">
                    <form class="d-flex" role="search">
                        <input class="form-control" type="search" name="txtBuscar" placeholder="Buscar">
                        <input class="btn btn-primary" type="submit" name="accion" value="Buscar">
                    </form>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">IdRuta</th>
                            <th scope="col">Origen</th>
                            <th scope="col">Destino</th>
                            <th scope="col">Zona</th>
                            <th scope="col">Horario</th>
                            <th scope="col">Tarifa</th>

                        </tr>
                    </thead>
                    <%
                        RutaDAO dao = new RutaDAO();
                        List<Ruta> lista = dao.listarRuta();
                        Iterator<Ruta> iter = lista.iterator();
                        Ruta ru = null;
                        while (iter.hasNext())
                        {
                            ru = iter.next();
                    %>
                    <tbody>
                        <tr>
                            <th scope="row"><%= ru.getIdRuta()%></th>
                            <td><%= ru.getOrigen()%></td>
                            <td><%= ru.getDestino()%></td>
                            <td><%= ru.getZona()%></td>
                            <td><%= ru.getHorario()%></td>
                            <td><%= ru.getTarifa()%></td>

                            <td>
                                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                    <button  type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Borrar</button>
                                    <button type="button" class="btn btn-warning" onclick="window.location.href = 'editarRuta.jsp';">Editar</button>

                                </div>
                            </td>
                        </tr>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirmacion</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Estas seguro que quieres borrar el registro
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-success">Borrar</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>