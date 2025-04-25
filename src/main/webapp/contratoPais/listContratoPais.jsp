<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 25/04/2025
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Relaciones Contrato - País</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Relaciones Contrato - País</h2>

<a href="${pageContext.request.contextPath}/contratoPais?action=new" class="btn btn-success mb-3">
  Añadir Relación
</a>

<table class="table table-bordered table-hover">
  <thead class="table-dark">
  <tr>
    <th>Contrato</th>
    <th>País</th>
    <th>Aporte (€)</th>
    <th>Acciones</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="relacion" items="${relaciones}">
    <tr>
      <td>${relacion.contrato.titulo}</td>
      <td>${relacion.pais.nombre}</td>
      <td>${relacion.aporte}</td>
      <td>
        <a href="${pageContext.request.contextPath}/contratoPais?action=edit&contratoId=${relacion.contrato.id}&paisId=${relacion.pais.id}"
           class="btn btn-sm btn-primary">Editar</a>
        <a href="${pageContext.request.contextPath}/contratoPais?action=delete&contratoId=${relacion.contrato.id}&paisId=${relacion.pais.id}"
           class="btn btn-sm btn-danger"
           onclick="return confirm('¿Seguro que deseas eliminar esta relación?');">Eliminar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>


