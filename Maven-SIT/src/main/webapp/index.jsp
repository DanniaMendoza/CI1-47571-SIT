
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="utp.edu.integrador.SIT.Modelo.UsuarioDAO"%>
<%@page import="utp.edu.integrador.SIT.Entidades.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <section class="tabla" >
        <table border="1">
          <thead>
            <tr>
              <th>id</th>
              <th>nombre</th>
              <th>username</th>
              <th>password</th>
              <th>rol</th>
              <th>estado</th>
            </tr>
          </thead>

          <% 
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> lista = dao.listar();
            Iterator<Usuario> iter = lista.iterator();
            Usuario usu = null;
            while(iter.hasNext()){
                usu = iter.next();
          %>
          <tbody>
            <tr>
              <td><%= usu.getId()%></td>
              <td><%= usu.getNombre()%></td>
              <td><%= usu.getUsername()%></td>
              <td><%= usu.getPassword()%></td>
              <td><%= usu.getRol()%></td>
              <td><%= usu.getEstado()%></td>

              <td><a href="UsuarioServlet?accion=editar&id=<%= usu.getId()%>">Editar</a></td>
              <td><a href="UsuarioServlet?accion=eliminar&id=<%= usu.getId()%>">Eliminar</a></td>

            </tr>
            <%}%>
          </tbody>
        </table>    

      </section>
    </body>
</html>
