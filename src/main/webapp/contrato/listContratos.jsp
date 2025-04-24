<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contratos Registrados</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h2 class="text-primary mb-4">Contratos Registrados</h2>

<a href="${pageContext.request.contextPath}/contrato?action=new" class="btn btn-success mb-3">
    Añadir Contrato
</a>

<table class="table table-bordered table-hover">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Ámbito</th>
        <th>Importe (€)</th>
        <th>Estado</th>
        <th>Inicio</th>
        <th>Fin</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contrato" items="${contratos}">
        <tr>
            <td>${contrato.id}</td>
            <td>${contrato.titulo}</td>
            <td>${contrato.ambito}</td>
            <td>${contrato.importe}</td>
            <td>${contrato.estado}</td>
            <td>${contrato.fechaInicio}</td>
            <td>${contrato.fechaFin}</td>
            <td>
                <a href="${pageContext.request.contextPath}/contrato?action=edit&idContrato=${contrato.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="${pageContext.request.contextPath}/contrato?action=delete&idContrato=${contrato.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Estás seguro de eliminar este contrato?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>

</body>
</html>


