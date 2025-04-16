
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Empresas Registradas</title>
    <style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef1f5;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 1000px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.08);
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 25px;
            border-bottom: 2px solid #2980b9;
            padding-bottom: 8px;
        }

        .add-button {
            display: inline-block;
            margin-bottom: 20px;
            background-color: #2980b9;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }

        .add-button:hover {
            background-color: #2471a3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fafafa;
        }

        th, td {
            padding: 14px 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #2980b9;
            color: #ffffff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .actions a {
            margin-right: 10px;
            color: #2980b9;
            text-decoration: none;
            font-weight: bold;
        }

        .actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>🏢 Empresas Registradas</h2>

    <a href="${pageContext.request.contextPath}/empresa?action=new" class="add-button">➕ Añadir Empresa</a>

    <table>
        <thead>
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
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/empresa?action=edit&id=${empresa.id}">✏️ Editar</a>
                    <a href="${pageContext.request.contextPath}/empresa?action=delete&id=${empresa.id}" onclick="return confirm('¿Seguro que quieres eliminar esta empresa?');">🗑️ Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
