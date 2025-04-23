<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nuevo Contrato</title>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #0a0f33, #1f1a5c);
            background-size: cover;
            color: #ffffff;
        }

        .form-container {
            background: rgba(0, 0, 50, 0.8);
            padding: 30px;
            max-width: 500px;
            margin: 60px auto;
            border-radius: 12px;
            box-shadow: 0 0 20px #ffffff66;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #00ffff;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: none;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            background-color: #00aaff;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
            font-weight: bold;
            font-size: 16px;
        }

        button:hover {
            background-color: #008ecc;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>🚀 Nuevo Contrato</h2>

    <form action="${pageContext.request.contextPath}/contrato" method="post">
        <input type="hidden" name="action" value="${contrato != null ? 'update' : 'insert'}" />

        <c:if test="${contrato != null}">
            <input type="hidden" name="idContrato" value="${contrato.id}" />
        </c:if>

        <label for="titulo">Título</label>
        <input type="text" id="titulo" name="titulo" value="${contrato.titulo}" required />

        <label for="descripcion">Descripción</label>
        <textarea id="descripcion" name="descripcion">${contrato.descripcion}</textarea>

        <label for="ambito">Ámbito</label>
        <select id="ambito" name="ambito">
            <option value="espacial" ${contrato.ambito == 'espacial' ? 'selected' : ''}>Espacial</option>
            <option value="defensa" ${contrato.ambito == 'defensa' ? 'selected' : ''}>Defensa</option>
            <option value="idi" ${contrato.ambito == 'idi' ? 'selected' : ''}>I+D+i</option>
            <option value="transporte" ${contrato.ambito == 'transporte' ? 'selected' : ''}>Transporte</option>
        </select>

        <label for="importe">Importe (€)</label>
        <input type="number" id="importe" name="importe" value="${contrato.importe}" required step="0.01" />

        <label for="estado">Estado</label>
        <select id="estado" name="estado">
            <option value="abierto" ${contrato.estado == 'abierto' ? 'selected' : ''}>Abierto</option>
            <option value="en negociacion" ${contrato.estado == 'en negociacion' ? 'selected' : ''}>En negociación</option>
            <option value="adjudicado" ${contrato.estado == 'adjudicado' ? 'selected' : ''}>Adjudicado</option>
            <option value="cerrado" ${contrato.estado == 'cerrado' ? 'selected' : ''}>Cerrado</option>
        </select>

        <label for="fechaInicio">Fecha de Inicio</label>
        <input type="date" id="fechaInicio" name="fechaInicio" value="${contrato.fechaInicio}" required />

        <label for="fechaFin">Fecha de Fin</label>
        <input type="date" id="fechaFin" name="fechaFin" value="${contrato.fechaFin}" required />

        <button type="submit">💾 Guardar Contrato</button>
    </form>
</div>
</body>
</html>

