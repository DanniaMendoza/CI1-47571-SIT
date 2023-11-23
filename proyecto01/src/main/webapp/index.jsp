<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Login SIT</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>


    <body class="bg-info d-flex justify-content-center align-items-center vh-100">
        <div class="bg-white p-5 rounded-5 text-secondary shadow" style="width: 25rem">
            <div class="d-flex justify-content-center">
                <img src="assets/img/login-icon.svg" alt="login-icon" style="height: 7rem" />
            </div>
            <div class="text-center fs-1 fw-bold">Login</div>
            
            <form action="SvUsuarios?accion=verificar" method="POST">
                <div class="input-group mt-4">
                    <div class="input-group-text bg-info">
                        <img src="assets/img/username-icon.svg" alt="username-icon" style="height: 1rem" />
                    </div>
                    <input class="form-control bg-light"  name="txtUsuario" type="text" placeholder="Dni" />
                </div>
                
                <div class="input-group mt-1">
                    <div class="input-group-text bg-info">
                        <img src="assets/img/password-icon.svg" alt="password-icon" style="height: 1rem" />
                    </div>
                    <input class="form-control bg-light" name="txtClave" type="password" placeholder="Password" />
                </div>

                <div class="d-flex justify-content-around mt-1">
                    <div class="d-flex align-items-center gap-1">
                        <input class="form-check-input" type="checkbox" />
                        <div class="pt-1" style="font-size: 0.9rem">Recordar contraseña</div>
                    </div>

                </div>
                <input type="submit" class="btn btn-info text-white w-100 mt-4 fw-semibold shadow-sm" name="verificar" value="Ingresar"" >


            </form>
            <div class="d-flex gap-1 justify-content-center mt-1">
                <div>¿No tienes una cuenta?</div>
                <a href="registroPasajero.jsp" class="text-decoration-none text-info fw-semibold">Registrate</a>
            </div>
            <div class="p-3">
                <div class="border-bottom text-center" style="height: 0.9rem">

                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
        </script>
    </body>
</html>

