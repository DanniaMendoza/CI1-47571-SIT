<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
     rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
     crossorigin="anonymous">
     <link rel="stylesheet" href="styles.css">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    crossorigin="anonymous"></script>
</head>
<body>

    <div class="fondo_All">
            <div style="display: flex;height: 100vh;;justify-content: center;">

               <div style="display: flex;align-items: center">
                <div class="card" style="width: 18rem;">
                    <form action="UsuarioServlet">
                    <div class="card-body">
                      <h5 class="card-title text-center"> Iniciar Sesión</h5>
                    
                      <div class="row">
                        <div class=" ">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="username" id="floatingInput" placeholder="Usuario">
                                <label for="floatingInput">Usuario</label>
                            </div>
                        </div>
                    </div>
                    <divc class="row">
                        <div class="">
                            <div class="form-floating">
                                <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
                                <label for="floatingPassword">Password</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class=" mt-2" s>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                                <label class="form-check-label" for="invalidCheck">
                                    Recordar Contraseña
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-center" >
                            <input type="submit" class="btn btn-outline-primary mt-3 mb-3" value="Login" name="accion"  />
                        </div>
                    </div>
                </form>
                    </div>
               </div>
                
               
            </div>
        </div>
    </div>
    
</body>
</html>
