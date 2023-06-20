<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="es">
  <head>
  <link rel="stylesheet" href="../../assets/pag2.css">
    <title>Registrar Roles</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->
 
    
    <style>
 nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
   background-color:#003855;

    color: #fff;
  }
  
  .logo img {
    height: 80px;
  }
    </style>
  </head>
  <body>
   <nav>
        <div class="logo">
          <img src="p.png" alt="">
      
        </div>
        <ul class="menu">
  
          <li><a href="index1.jsp">Inicio</a></li>
        
         
        </ul>
      </nav>
      <div class="container">
          <h1 class="title">Registrar publicacion</h1>
          <form action="genero" method="post">
              <label for="nameRol">Publica tus momentos...</label>
              <br>
              <br>
              <input type="text" class="nameRol" id="nameRol" name="nombreGenero" required><br>
              <br>
              <label for="estRol">¿Quiere que su publicacion sea publica o privada? </label><br>
              <div class="form-check">
                  <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="estadoGenero" value="Activo" id=""  checked>
                  Publica
                </label>
              </div>
              <div class="form-check">
                <label class="form-check-label">
                <input type="radio" class="form-check-input" name="estadoGenero" value="Inactivo" id=""  >
                Privada
              </label>
            </div>
            <button type="submit" class="btn btn-outline-info" name="accionForm" value="agregar" >Registrar Publicacion</button>
          </form>
          <a href="genero?accion=VolverP">Regresar</a>
      </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>