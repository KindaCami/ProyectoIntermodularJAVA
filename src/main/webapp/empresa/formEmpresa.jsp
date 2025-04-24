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
  <meta charset="UTF-8">
  <title>Formulario de Empresa</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">

<div class="container">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">${empty empresa.id ? " Añadir nueva empresa" : "️ Editar empresa existente"}</h4>
    </div>
    <div class="card-body">
      <form action="${pageContext.request.contextPath}/empresa" method="post">

        <!-- ID de la empresa -->
        <div class="mb-3">
          <label for="id" class="form-label">ID de la Empresa</label>
          <input type="text" id="id" name="id" class="form-control" value="${empresa.id}" ${!empty empresa.id ? "readonly" : ""} required>
        </div>

        <!-- Nombre -->
        <div class="mb-3">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" id="nombre" name="nombre" class="form-control" value="${empresa.nombre}" required>
        </div>

        <!-- Sector -->
        <div class="mb-3">
          <label for="sector" class="form-label">Sector</label>
          <input type="text" id="sector" name="sector" class="form-control" value="${empresa.sector}" required>
        </div>

        <!-- País de origen -->
        <div class="mb-3">
          <label for="paisOrigenId" class="form-label">País de Origen (ID)</label>
          <input type="text" id="paisOrigenId" name="paisOrigenId" class="form-control" value="${empresa.paisOrigenId}" required>
        </div>

        <!-- Acción -->
        <input type="hidden" name="action" value="${empty empresa.id ? 'insert' : 'update'}" />

        <!-- Botones -->
        <div class="d-flex justify-content-between">
          <button type="submit" class="btn btn-success">Guardar</button>
          <a href="${pageContext.request.contextPath}/empresa" class="btn btn-secondary">Cancelar</a>
          <a href="${pageContext.request.contextPath}/empresa" class="btn btn-secondary">Volver al listado</a>
        </div>

      </form>
    </div>
  </div>
</div>

</body>
</html>

