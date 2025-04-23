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
    <title>📄 Lista de Contratos</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

    <style>
        body { font-family: Arial; background: #f8f9fa; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #007bff; color: white; }
        a.btn {
            padding: 6px 12px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a.btn-red {
            background-color: #dc3545;
        }
    </style>
</head>
<body>

<h2>📄 Contratos registrados</h2>

<a href="${pageContext.request.contextPath}/contrato?action=new" class="btn">➕ Nuevo Contrato</a>
<br><br>

<table>
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
                <a href="${pageContext.request.contextPath}/contrato?action=edit&idContrato=${contrato.id}" class="btn">✏️ Editar</a>
                <a href="${pageContext.request.contextPath}/contrato?action=delete&idContrato=${contrato.id}" class="btn btn-red" onclick="return confirm('¿Estás seguro de eliminar este contrato?');">🗑️ Eliminar</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html

