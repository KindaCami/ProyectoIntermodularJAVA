
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Empresas Registradas</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Empresas registradas</h2>

<a href="${pageContext.request.contextPath}/empresa?action=new" class="btn btn-success mb-3">
    Añadir Empresa
</a>

<table class="table table-bordered table-hover">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Sector</th>
        <th>País de Origen</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="empresa" items="${empresas}">
        <tr>
            <td>${empresa.id}</td>
            <td>${empresa.nombre}</td>
            <td>${empresa.sector}</td>
            <td>${empresa.paisOrigenId}</td>
            <td>
                <a href="${pageContext.request.contextPath}/empresa?action=edit&id=${empresa.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="${pageContext.request.contextPath}/empresa?action=delete&id=${empresa.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Seguro que quieres eliminar esta empresa?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>

