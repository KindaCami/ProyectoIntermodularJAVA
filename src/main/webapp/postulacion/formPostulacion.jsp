<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Nueva Postulación</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #0a0f33, #1f1a5c);
      background-size: cover;
      color: #ffffff;
    }

    .form-container {
      background: rgba(0, 0, 50, 0.8);
      padding: 30px;
      max-width: 500px;
      margin: 60px auto;
      border-radius: 12px;
      box-shadow: 0 0 20px #ffffff66;
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: white;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    input, select {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: none;
      border-radius: 6px;
      box-sizing: border-box;
    }

    button {
      background-color: #00aaff;
      color: white;
      border: none;
      padding: 12px 20px;
      border-radius: 6px;
      cursor: pointer;
      margin-top: 20px;
      width: 100%;
      font-weight: bold;
      font-size: 16px;
    }

    button:hover {
      background-color: #008ecc;
    }
  </style>
</head>
<body>
<div class="form-container">
  <h2>Nueva Postulación</h2>

  <form action="${pageContext.request.contextPath}/postulacion" method="post">
    <input type="hidden" name="action" value="${postulacion != null ? 'update' : 'insert'}" />

    <label for="empresaId">ID Empresa</label>
    <input type="text" id="empresaId" name="empresaId" value="${postulacion.empresa.id}" required />

    <label for="contratoId">ID Contrato</label>
    <input type="number" id="contratoId" name="contratoId" value="${postulacion.contrato.id}" required />

    <label for="propuestaImporte">Propuesta Económica (€)</label>
    <input type="number" id="propuestaImporte" name="propuestaImporte" step="0.01" value="${postulacion.propuestaImporte}" required />

    <label for="resultado">Resultado</label>
    <select id="resultado" name="resultado">
      <option value="pendiente" ${postulacion.resultado == 'pendiente' ? 'selected' : ''}>Pendiente</option>
      <option value="aceptada" ${postulacion.resultado == 'aceptada' ? 'selected' : ''}>Aceptada</option>
      <option value="rechazada" ${postulacion.resultado == 'rechazada' ? 'selected' : ''}>Rechazada</option>
    </select>

    <button type="submit"> Guardar Postulación</button>
  </form>
</div>
</body>
</html>