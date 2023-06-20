<link href="../assets/pag.css" rel="stylesheet">
  
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<nav>
    <div class="logo">
      <img src="resources/img/logo.png" alt="">
    </div>
    <ul class="menu">
  
      <li><a href="../index1.jsp">Inicio</a></li>
      <li><a href="../index1.jsp">Cerrar Sesion</a></li>
    </ul>
  </nav>
  <form action="../index.jsp" method="POST"> 
    <link rel="stylesheet" href="menu.jsp">
    <h2>Iniciar sesión a Instagram</h2>
  
    <div class="input-group">
      <label for="username">Usuario</label>
      <input type="text" id="username" name="username" required>
    </div>
  
    <div class="input-group">
      <label for="password">Contraseña</label>
      <input type="password" id="password" name="password" required>
    </div>
  
    <button type="submit">Iniciar sesión </button>
  
  
    
     
    
  </form>
  <footer>
    <p>Ingresa tu usuario y contrseña, para conocer más...</p>
    <p> Marlly Pineda </p>
  </footer>