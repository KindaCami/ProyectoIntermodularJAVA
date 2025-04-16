<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Asociar Empresa y País</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background: linear-gradient(135deg, #0a0f33, #1f1a5c);
      color: #ffffff;
    }

    .form-container {
      background: rgba(0, 0, 50, 0.85);
      padding: 30px;
      max-width: 500px;
      margin: 60px auto;
      border-radius: 12px;
      box-shadow: 0 0 20px #ffffff66;
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #00ffff;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    select {
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
  <h2> Asociar Empresa y País</h2>

  <form action="${pageContext.request.contextPath}/empresaPais" method="post">
    <input type="hidden" name="action" value="insert" />

    <label for="empresaId">Empresa</label>
    <select id="empresaId" name="empresaId" required>
      <c:forEach var="empresa" items="${empresas}">
        <option value="${empresa.id}">${empresa.nombre}</option>
      </c:forEach>
    </select>

    <label for="paisId">País</label>
    <select id="paisId" name="paisId" required>
      <c:forEach var="pais" items="${paises}">
        <option value="${pais.id}">${pais.nombre}</option>
      </c:forEach>
    </select>

    <button type="submit">Guardar Relación</button>
  </form>
</div>
</body>
</html>


