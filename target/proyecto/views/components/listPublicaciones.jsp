<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
     <link rel="stylesheet" href="assets/pag2.css">
        <title>Lista de publicaciones</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta
        name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- sweetalert -->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <!-- Bootstrap CSS v5.0.2 -->
  
        <style>
 
        </style>
    </head>
    <body>
    <nav>
        <div class="logo">
          <img src="../../IMG/p.png" alt="">
      
        </div>
        <ul class="menu">
  
          <li><a href="index1.jsp">Inicio</a></li>
          <p></p>
          <a href="genero?accion=VolverP">Regresar</a>
        
         
        </ul>
      </nav>
        <div class="container">
            <h1 class="text-center">Reporte de publicaciones realizadas</h1>
            
            <table class="table table-light">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre Publicacion</th>
                        <th>Estado de la publicacion</th>
                        <th colspan="4">borrar publicacion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="genero" items="${generos}">
                        <tr>
                            <td scope="row">${genero.getIdGenero()}</td>
                            <td>${genero.getNombreGenero()}</td>
                            <td>${genero.getEstadoGenero()}</td>

                                <c:if test="${genero.getEstadoGenero() == 'Inactivo'}">
                                    <form action="genero" method="post" id="formularioActivar${genero.getIdGenero()}">
                                        <input type="hidden" name="idGenero" value="${genero.getIdGenero()}">
                                        <input type="hidden" name="accionForm" value="activar">
                                        <button type="button" class="btn btn-success" onclick="activar('${genero.getIdGenero()}')">Activar</button>
                                    </form>
                                </c:if>
                            </td>
                            <td>
                            <td>
                                <form action="genero" method="post" id="formularioEliminar${genero.getIdGenero()}">
                                    <input type="hidden" name="idGeneroEliminar" id="IdFormulario" value="${genero.getIdGenero()}">
                                    <input type="hidden" name="accionForm" value="eliminar">
                                    <i class="bi bi-trash-fill btnDelete" onclick="EnviarEliminacion('${genero.getIdGenero()}')"></i>
                                </form>
                            </td>
                        </tr>


                    </c:forEach>

                </tbody>
            </table>
        </div>
        <script>
            
            
            function EnviarEliminacion(id) {

                var formEliminado = document.getElementById('formularioEliminar' + id);

                Swal.fire({
                    title: "¿Esta seguro que desea borrar el registro de esta publicacion?",
                    text: "Si borra este registro se borrara de manera permanente y no podra recuperarlo.",
                    icon: "",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "Eliminar registro"
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Swal.fire("Eliminado!", "Registro Eliminado exitosamente.", "success");
                        // Swal.fire({
                        //     position: 'top',
                        //     icon: 'success',
                        //     title: 'Your work has been saved',
                        //     showConfirmButton: false,
                        //     timer: 1500
                        // });
                        formEliminado.submit();
                        // setTimeout(enviar,2000);
                        //     function enviar() {

                        //     }
                    }

                });

            }
        </script>
        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
