<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 14/04/2025
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>${empresa != null ? 'Editar Empresa' : 'Nueva Empresa'}</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    .container {
      width: 60%;
      margin: 50px auto;
      background-color: #ffffff;
      padding: 30px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
      color: #2c3e50;
      margin-bottom: 20px;
    }
    label {
      display: block;
      margin-top: 15px;
      color: #34495e;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: 1px solid #bdc3c7;
      border-radius: 4px;
    }
    .buttons {
      margin-top: 20px;
    }
    .buttons button {
      padding: 10px 20px;
      margin-right: 10px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    .buttons .save {
      background-color: #2980b9;
      color: #ffffff;
    }
    .buttons .cancel {
      background-color: #95a5a6;
      color: #ffffff;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>${empresa != null ? '✏️ Editar Empresa' : '➕ Nueva Empresa'}</h2>
  <form action="${pageContext.request.contextPath}/empresa" method="post">
    <input type="hidden" name="action" value="${empresa != null ? 'update' : 'insert'}" />

    <label for="id">ID:</label>
    <input type="text" id="id" name="id" value="${empresa != null ? empresa.id : ''}" ${empresa != null ? 'readonly' : ''} required />

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" value="${empresa != null ? empresa.nombre : ''}" required />

    <label for="sector">Sector:</label>
    <input type="text" id="sector" name="sector" value="${empresa != null ? empresa.sector : ''}" required />

    <label for="paisOrigenId">País de Origen (ID):</label>
    <input type="text" id="paisOrigenId" name="paisOrigenId" value="${empresa != null ? empresa.paisOrigenId : ''}" required />

    <div class="buttons">
      <button type="submit" class="save">💾 Guardar</button>
      <a href="${pageContext.request.contextPath}/empresa"><button type="button" class="cancel">🔙 Volver</button></a>
    </div>
  </form>
</div>
</body>
</html>
