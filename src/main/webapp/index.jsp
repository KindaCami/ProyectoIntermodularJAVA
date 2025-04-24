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

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&family=Special+Gothic+Expanded+One&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: "Segoe UI", Tahoma, sans-serif;
            background-color: #f5f7fa;
            background-image: url("img/space.jpg");
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
            position: sticky;
            top: 0;
            z-index: 1000;
            background-color: rgba(10, 61, 98, 0.95);
            font-family: "Special Gothic Expanded One", Arial, sans-serif;
            font-weight: 400;
            font-style: normal;
            color: white;
            padding: 20px 0;
            text-align: center;
            backdrop-filter: blur(4px);
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.3);
            transition: background-color 0.3s ease;
        }


        .intro {
            background-color: rgba(10, 61, 98, 0.95);
            padding: 30px;
            margin: 40px auto 20px auto;
            max-width: 900px;
            border-radius: 10px;
            text-align: center;
            color: #ffffff;
            box-shadow: none;
            transition: box-shadow 0.4s ease, background-color 0.4s ease;
        }

        .intro h2 {
            font-size: 26px;
            margin-bottom: 10px;
            color: #ffffff;
        }

        .intro p {
            font-size: 15px;
            line-height: 1.6;
            color: #d0d0d0;
        }

        .intro:hover {
            background-color: rgba(19, 45, 70, 0.85);
            box-shadow: 0 0 30px #01c38e88;
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
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
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

    </style>
</head>
<body>

<header>
    <h1>ESPACE</h1>
    <p>European Space Project Advancement and Collaboration Ecosystem</p>
</header>

<div class="intro">
    <div class="intro-content">
        <h2>Bienvenido al panel de gestión</h2>
        <p>
            Explora contratos internacionales, países financiadores, empresas participantes y sus postulaciones en un solo lugar.
        </p>
    </div>
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
        <p>País de operaciones de las empresas</p>
        <a href="${pageContext.request.contextPath}/empresaPais">Ver empresas</a>
    </div>
</div>

<footer>
    ESPACE™ Proyecto desarrollado en Java con JDBC, Servlets y JSP • 2025
</footer>

</body>
</html>



