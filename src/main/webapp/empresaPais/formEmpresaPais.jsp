<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario de Asociación Empresa - País</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">

<div class="container">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">Asociar Empresa y País</h4>
    </div>
    <div class="card-body">
      <form action="${pageContext.request.contextPath}/empresaPais" method="post">
        <input type="hidden" name="action" value="insert" />

        <!-- Empresa -->
        <div class="mb-3">
          <label for="empresaId" class="form-label">Empresa</label>
          <select name="empresaId" id="empresaId" class="form-select" required>
            <c:forEach var="empresa" items="${empresas}">
              <option value="${empresa.id}">${empresa.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <!-- País -->
        <div class="mb-3">
          <label for="paisId" class="form-label">País</label>
          <select name="paisId" id="paisId" class="form-select" required>
            <c:forEach var="pais" items="${paises}">
              <option value="${pais.id}">${pais.nombre}</option>
            </c:forEach>
          </select>
        </div>

        <!-- Botones -->
        <div class="d-flex justify-content-between">
          <button type="submit" class="btn btn-success">Guardar</button>
          <a href="${pageContext.request.contextPath}/empresaPais" class="btn btn-secondary">Cancelar</a>
          <a href="${pageContext.request.contextPath}/empresaPais" class="btn btn-secondary">Volver al listado</a>
        </div>

      </form>
    </div>
  </div>
</div>

</body>
</html>



