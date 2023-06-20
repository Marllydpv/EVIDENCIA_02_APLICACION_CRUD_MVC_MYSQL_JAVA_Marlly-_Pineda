<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="es">
  <head>
    <title>Registrar usuarios</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.0.2 -->

    <style>
 
    </style>
  </head>
  <body>
      <div class="container">
          <h1 class="title">Registrar un nuevo usuario</h1>
          <form action="Usuarios" method="post">
              <label for="nameRol">Nombre del usuario</label>
              <br>
              <br>
              <input type="text" class="nameRol" id="nameRol" name="nombreGenero" required><br>
              <br>
              <label for="estRol">Este ususrio es activo o inactivo  </label><br>
              <div class="form-check">
                  <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="estadoGenero" value="Activo" id=""  checked>
                  Activo
                </label>
              </div>
              <div class="form-check">
                <label class="form-check-label">
                <input type="radio" class="form-check-input" name="estadoGenero" value="Inactivo" id="">
                inactivop
              </label>
            </div>
            <button type="submit" class="btn btn-outline-info" name="accionForm" value="agregar">Registrar Usuario</button>
          </form>
          <a href="usuarios?accion=VolverP">Regresar</a>
      </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>