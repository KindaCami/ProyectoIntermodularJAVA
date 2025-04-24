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
  <meta charset="UTF-8">
  <title>Postulaciones</title>
  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Postulaciones Registradas</h2>

<a href="${pageContext.request.contextPath}/postulacion?action=new" class="btn btn-success mb-3">
  Añadir Postulación
</a>

<table class="table table-bordered table-hover">
  <thead class="table-dark">
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
      <td>
        <a href="${pageContext.request.contextPath}/postulacion?action=edit&empresaId=${postulacion.empresa.id}&contratoId=${postulacion.contrato.id}" class="btn btn-sm btn-primary">Editar</a>
        <a href="${pageContext.request.contextPath}/postulacion?action=delete&empresaId=${postulacion.empresa.id}&contratoId=${postulacion.contrato.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Seguro que quieres eliminar esta postulación?');">Eliminar</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>
