<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 14/04/2025
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inicio - Proyecto Intermodular</title>
    <style>
        body {
            font-family: "Segoe UI", Tahoma, sans-serif;
            background-color: #f5f7fa;
            background-image: url("img/space.jpg.jpg");
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            color: #fff;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;

        }

        header {
            background-color: #0a3d62;
            color: white;
            padding: 20px 0;
            text-align: center;
        }

        .intro {
            max-width: 900px;
            margin: 40px auto;
            padding: 20px;
            text-align: center;
        }

        .intro h2 {
            color: #2c3e50;
        }

        .intro p {
            font-size: 16px;
            color: #555;
        }

        .cards {
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
            margin: 30px auto;
            max-width: 1000px;
        }

        .card {
            background-color: white;
            width: 250px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            padding: 20px;
            text-align: center;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: scale(1.03);
        }

        .card h3 {
            color: #0a3d62;
            margin-bottom: 10px;
        }

        .card a {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 16px;
            background-color: #0a3d62;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }

        footer {
            background-color: #dfe6e9;
            text-align: center;
            padding: 15px;
            font-size: 14px;
            color: #666;
            margin-top: auto;


        }
    </style>
</head>
<body>

<header>
    <h1>ESPACE</h1>
    <p>European Space Project Advancement and Collaboration Ecosystem</p>
</header>

<div class="intro">
    <h2>Bienvenido a tu panel de gestión</h2>
    <p>Desde aquí puedes administrar todas las entidades relacionadas con los proyectos internacionales de financiación: contratos activos, países participantes y empresas interesadas.</p>
</div>

<div class="cards">
    <div class="card">
        <h3>Países</h3>
        <p>Consulta y gestiona los países que financian contratos.</p>
        <a href="${pageContext.request.contextPath}/pais">Ver países</a>
    </div>
    <div class="card">
        <h3>Empresas</h3>
        <p>Gestiona las empresas que pueden postularse a contratos.</p>
        <a href="${pageContext.request.contextPath}/empresa">Ver empresas</a>
    </div>
    <div class="card">
        <h3>Contratos</h3>
        <p>Visualiza y administra los contratos disponibles.</p>
        <a href="${pageContext.request.contextPath}/contrato">Ver contratos</a>
    </div>
    <div class="card">
        <h3>Postulaciones</h3>
        <p>Gestiona las postulaciones a contratos</p>
        <a href="${pageContext.request.contextPath}/postulacion">Ver postulaciones</a>
    </div>
    <div class="card">
        <h3>Empresas Multinacionales</h3>
        <p>Pais de operaciones de las empresas</p>
        <a href="${pageContext.request.contextPath}/empresaPais">Ver empresas</a>
    </div>
</div>

<footer>
    ESPACE™ Proyecto desarrollado en Java con JDBC, Servlets y JSP • 2025
</footer>

</body>
</html>


