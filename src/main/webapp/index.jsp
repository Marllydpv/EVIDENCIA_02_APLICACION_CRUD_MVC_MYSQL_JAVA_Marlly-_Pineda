<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

          <!DOCTYPE html>
<html lang="es">
<head>
 <link rel="stylesheet" href="assets/pag2.css">
    <title>Título de la página</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
     <nav>
        <div class="logo">
          <img src="IMG/p.png" alt="">
      
        </div>
        <ul class="menu">
  
          <li><a href="index1.jsp">Inicio</a></li>
        
         
        </ul>
      </nav>
    <style>
        /* Estilos personalizados */
        .container-elements {
            margin-top: 20px;
        }

        .element-p {
            padding: 10px;
        }

        .text-center {
            text-align: center;
        }

        .hipervinculos {
            margin-top: 20px;
        }

        .hipervinculos a {
            display: block;
            margin-bottom: 10px;
            padding: 10px 20px;
            border-radius: 5px;
            color: #fff;
            background-color: #003855;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .hipervinculos a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container container-elements">
        <div class="row">
            <div class="col-xx-auto element-p">
                <h1 class="text-center">PUBLICACIONES</h1>
                <div class="hipervinculos text-center">
                    <div class="hiper-form">
                        <a href="genero?accion=formulario">
                            Registrar nueva publicación
                        </a>
                    </div>
                    <div class="hiper-eye">
                        <a href="genero?accion=listarPublicaciones">
                            Ver registro de publicaciones
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container container-elements">
        <div class="row">
            <div class="col-xx-auto element-p">
                <h1 class="text-center">USUARIOS</h1>
                <div class="hipervinculos text-center">
                    <div class="hiper-form">
                        <a href="usuarios?accion=listarUsuarios">
                            Consultar Usuarios Registrados
                        </a>
                    </div>
                    <div class="hiper-eye">
                        <a href="usuarios?accion=formulario">
                            Registrar un Nuevo Usuario
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
  <footer>
    
    <p> Marlly Pineda </p>
  </footer>

    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>

