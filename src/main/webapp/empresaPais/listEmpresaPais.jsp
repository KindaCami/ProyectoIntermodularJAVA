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
  <meta charset="UTF-8">
  <title>Relaciones Empresa - País</title>
  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Ubicación de las Empresas</h2>

<a href="${pageContext.request.contextPath}/empresaPais?action=add" class="btn btn-success mb-3">
  Añadir Relación
</a>

<table class="table table-bordered table-hover">
  <thead class="table-dark">
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
      <td>
        <a href="${pageContext.request.contextPath}/empresaPais?action=delete&empresaId=${relacion.empresaId}&paisId=${relacion.paisId}" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de eliminar esta relación?');">
          Eliminar
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>
