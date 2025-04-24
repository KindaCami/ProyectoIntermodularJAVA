<%--
  Created by IntelliJ IDEA.
  User: CAMIL
  Date: 15/04/2025
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Formulario de Postulación</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">

<div class="container">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">${empty postulacion ? "Añadir nueva postulación" : "Editar postulación"}</h4>
    </div>
    <div class="card-body">
      <form action="${pageContext.request.contextPath}/postulacion" method="post">
        <input type="hidden" name="action" value="${empty postulacion ? 'insert' : 'update'}" />

        <!-- Empresa -->
        <div class="mb-3">
          <label for="empresaId" class="form-label">Empresa</label>
          <select name="empresaId" id="empresaId" class="form-select" ${!empty postulacion ? 'disabled' : ''} required>
            <c:forEach var="empresa" items="${empresas}">
              <option value="${empresa.id}"
                      <c:if test="${postulacion.empresa.id == empresa.id}">selected</c:if>>
                  ${empresa.nombre}
              </option>
            </c:forEach>
          </select>
          <c:if test="${!empty postulacion}">
            <input type="hidden" name="empresaId" value="${postulacion.empresa.id}" />
          </c:if>
        </div>

        <!-- Contrato -->
        <div class="mb-3">
          <label for="contratoId" class="form-label">Contrato</label>
          <select name="contratoId" id="contratoId" class="form-select" ${!empty postulacion ? 'disabled' : ''} required>
            <c:forEach var="contrato" items="${contratos}">
              <option value="${contrato.id}"
                      <c:if test="${postulacion.contrato.id == contrato.id}">selected</c:if>>
                  ${contrato.titulo}
              </option>
            </c:forEach>
          </select>
          <c:if test="${!empty postulacion}">
            <input type="hidden" name="contratoId" value="${postulacion.contrato.id}" />
          </c:if>
        </div>

        <!-- Propuesta Importe -->
        <div class="mb-3">
          <label for="propuestaImporte" class="form-label">Importe de la propuesta (€)</label>
          <input type="number" step="0.01" id="propuestaImporte" name="propuestaImporte" class="form-control"
                 value="${postulacion.propuestaImporte}" required>
        </div>

        <!-- Resultado -->
        <div class="mb-3">
          <label for="resultado" class="form-label">Resultado</label>
          <select name="resultado" id="resultado" class="form-select" required>
            <option value="pendiente" ${postulacion.resultado == 'pendiente' ? 'selected' : ''}>Pendiente</option>
            <option value="ganada" ${postulacion.resultado == 'ganada' ? 'selected' : ''}>Ganada</option>
            <option value="rechazada" ${postulacion.resultado == 'rechazada' ? 'selected' : ''}>Rechazada</option>
          </select>
        </div>

        <!-- Botones -->
        <div class="d-flex justify-content-between">
          <button type="submit" class="btn btn-success">Guardar</button>
          <a href="${pageContext.request.contextPath}/postulacion" class="btn btn-secondary">Cancelar</a>
          <a href="${pageContext.request.contextPath}/postulacion" class="btn btn-secondary">Volver al listado</a>
        </div>

      </form>
    </div>
  </div>
</div>

</body>
</html>

