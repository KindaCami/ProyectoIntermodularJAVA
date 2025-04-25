<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 25/04/2025
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario Contrato - País</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">

<div class="container">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">
        ${empty relacion ? "Añadir relación Contrato - País" : "Editar relación existente"}
      </h4>
    </div>
    <div class="card-body">
      <form action="${pageContext.request.contextPath}/contratoPais" method="post">

        <!-- Contrato -->
        <div class="mb-3">
          <label for="contratoId" class="form-label">Contrato</label>
          <select id="contratoId" name="contratoId" class="form-select" ${relacion != null ? "readonly disabled" : ""} required>
            <c:forEach var="contrato" items="${contratos}">
              <option value="${contrato.id}"
                      <c:if test="${relacion != null && contrato.id == relacion.contrato.id}">selected</c:if>>
                  ${contrato.titulo}
              </option>
            </c:forEach>
          </select>
        </div>

        <!-- País -->
        <div class="mb-3">
          <label for="paisId" class="form-label">País</label>
          <select id="paisId" name="paisId" class="form-select" ${relacion != null ? "readonly disabled" : ""} required>
            <c:forEach var="pais" items="${paises}">
              <option value="${pais.id}"
                      <c:if test="${relacion != null && pais.id == relacion.pais.id}">selected</c:if>>
                  ${pais.nombre}
              </option>
            </c:forEach>
          </select>
        </div>

        <!-- Aporte -->
        <div class="mb-3">
          <label for="aporte" class="form-label">Aporte (€)</label>
          <input type="number" step="0.01" id="aporte" name="aporte" class="form-control"
                 value="${relacion.aporte}" required>
        </div>

        <!-- Acción -->
        <input type="hidden" name="action" value="${empty relacion ? 'insert' : 'update'}" />
        <c:if test="${relacion != null}">
          <input type="hidden" name="contratoId" value="${relacion.contrato.id}" />
          <input type="hidden" name="paisId" value="${relacion.pais.id}" />
        </c:if>

        <!-- Botones -->
        <div class="d-flex justify-content-between">
          <button type="submit" class="btn btn-success">Guardar</button>
          <a href="${pageContext.request.contextPath}/contratoPais" class="btn btn-secondary">Cancelar</a>
          <a href="${pageContext.request.contextPath}/contratoPais" class="btn btn-secondary">Volver al listado</a>
        </div>

      </form>
    </div>
  </div>
</div>

</body>
</html>


