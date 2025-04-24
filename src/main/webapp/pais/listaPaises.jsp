<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 14/04/2025
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Países Registrados</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Países Registrados</h2>

<a href="${pageContext.request.contextPath}/pais?action=new" class="btn btn-success mb-3">
    Añadir País
</a>

<table class="table table-bordered table-hover">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Presupuesto Total</th>
        <th>Presupuesto Asignado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pais" items="${listaPaises}">
        <tr>
            <td>${pais.id}</td>
            <td>${pais.nombre}</td>
            <td>${pais.presupuestoTotal} €</td>
            <td>${pais.presupuestoAsignado} €</td>
            <td>
                <a href="${pageContext.request.contextPath}/pais?action=edit&id=${pais.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="${pageContext.request.contextPath}/pais?action=delete&id=${pais.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Seguro que quieres eliminar este país?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>



