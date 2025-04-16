<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Relaciones Empresa - País</title>
  <style>
    body {
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f6f9;
      margin: 0;
      padding: 20px;
    }

    .container {
      max-width: 900px;
      margin: 0 auto;
      background-color: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #2c3e50;
      margin-bottom: 25px;
    }

    .add-button {
      display: inline-block;
      margin-bottom: 20px;
      background-color: #28a745;
      color: white;
      padding: 10px 16px;
      border: none;
      border-radius: 5px;
      text-decoration: none;
      font-size: 14px;
    }

    .add-button:hover {
      background-color: #218838;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #2980b9;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    .acciones a {
      text-decoration: none;
      margin-right: 10px;
      color: #3498db;
      font-weight: bold;
    }

    .acciones a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Ubicacion de las Empresas</h2>

  <a href="${pageContext.request.contextPath}/empresaPais?action=add" class="add-button">Añadir Relación</a>

  <table>
    <thead>
    <tr>
      <th>Empresa</th>
      <th>ID Empresa</th>
      <th>País</th>
      <th>ID País</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="relacion" items="${relaciones}">
      <tr>
        <td>${relacion.empresaNombre}</td>
        <td>${relacion.empresaId}</td>
        <td>${relacion.paisNombre}</td>
        <td>${relacion.paisId}</td>
        <td class="acciones">
          <a href="${pageContext.request.contextPath}/empresaPais?action=delete&empresaId=${relacion.empresaId}&paisId=${relacion.paisId}"
             onclick="return confirm('¿Estás seguro de eliminar esta relación?');"> Eliminar</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
