<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 14/04/2025
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>✍️ Formulario de País</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary">${empty pais.id ? "➕ Añadir País" : "✏️ Editar País"}</h2>

<form action="${pageContext.request.contextPath}/pais" method="post" class="mt-4">

  <!-- ID solo editable en nuevo país -->
  <div class="mb-3">
    <label for="id" class="form-label">ID del País (ej. ESP)</label>
    <input type="text" id="id" name="id" class="form-control" value="${pais.id}" ${!empty pais.id ? "readonly" : ""} required>
  </div>

  <div class="mb-3">
    <label for="nombre" class="form-label">Nombre</label>
    <input type="text" id="nombre" name="nombre" class="form-control" value="${pais.nombre}" required>
  </div>

  <div class="mb-3">
    <label for="presupuestoTotal" class="form-label">Presupuesto Total (€)</label>
    <input type="number" step="0.01" id="presupuestoTotal" name="presupuestoTotal" class="form-control" value="${pais.presupuestoTotal}" required>
  </div>

  <div class="mb-3">
    <label for="presupuestoAsignado" class="form-label">Presupuesto Asignado (€)</label>
    <input type="number" step="0.01" id="presupuestoAsignado" name="presupuestoAsignado" class="form-control" value="${pais.presupuestoAsignado}" required>
  </div>

  <input type="hidden" name="action" value="${empty pais.id ? "insert" : "update"}">

  <button type="submit" class="btn btn-success">💾 Guardar</button>
  <a href="${pageContext.request.contextPath}/pais" class="btn btn-secondary">🔙 Cancelar</a>

</form>

</body>
</html>

