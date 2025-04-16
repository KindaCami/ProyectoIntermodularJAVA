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
  <title>Postulaciones</title>
  <style>
    body {
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f7f9;
      margin: 0;
      padding: 0;
    }

    .container {
      width: 90%;
      margin: 40px auto;
      background-color: #ffffff;
      padding: 25px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 10px;
    }

    h2 {
      color: #2c3e50;
      text-align: center;
      margin-bottom: 30px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      padding: 12px;
      border-bottom: 1px solid #ddd;
      text-align: left;
    }

    th {
      background-color: #2980b9;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    .actions a {
      margin-right: 10px;
      text-decoration: none;
      color: #3498db;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>📋 Lista de Postulaciones</h2>

  <table>
    <thead>
    <tr>
      <th>Empresa</th>
      <th>Contrato</th>
      <th>Propuesta (€)</th>
      <th>Resultado</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="postulacion" items="${postulaciones}">
      <tr>
        <td>${postulacion.empresa.nombre}</td>
        <td>${postulacion.contrato.titulo}</td>
        <td>${postulacion.propuestaImporte}</td>
        <td>${postulacion.resultado}</td>
        <td class="actions">
          <a href="${pageContext.request.contextPath}/postulacion?action=edit&empresaId=${postulacion.empresa.id}&contratoId=${postulacion.contrato.id}">✏️ Editar</a>
          <a href="${pageContext.request.contextPath}/postulacion?action=delete&empresaId=${postulacion.empresa.id}&contratoId=${postulacion.contrato.id}" onclick="return confirm('¿Seguro que quieres eliminar esta postulación?');">🗑️ Eliminar</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
