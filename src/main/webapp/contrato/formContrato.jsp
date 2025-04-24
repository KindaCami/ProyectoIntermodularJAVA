<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Contrato</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light py-5">

<div class="container">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">${contrato != null ? "Editar contrato existente" : "Añadir nuevo contrato"}</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/contrato" method="post">
                <input type="hidden" name="action" value="${contrato != null ? 'update' : 'insert'}" />

                <c:if test="${contrato != null}">
                    <input type="hidden" name="idContrato" value="${contrato.id}" />
                </c:if>

                <div class="mb-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input type="text" id="titulo" name="titulo" class="form-control" value="${contrato.titulo}" required>
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea id="descripcion" name="descripcion" class="form-control" rows="3">${contrato.descripcion}</textarea>
                </div>

                <div class="mb-3">
                    <label for="ambito" class="form-label">Ámbito</label>
                    <select id="ambito" name="ambito" class="form-select" required>
                        <option value="espacial" ${contrato.ambito == 'espacial' ? 'selected' : ''}>Espacial</option>
                        <option value="defensa" ${contrato.ambito == 'defensa' ? 'selected' : ''}>Defensa</option>
                        <option value="idi" ${contrato.ambito == 'idi' ? 'selected' : ''}>I+D+i</option>
                        <option value="transporte" ${contrato.ambito == 'transporte' ? 'selected' : ''}>Transporte</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="importe" class="form-label">Importe (€)</label>
                    <input type="number" step="0.01" id="importe" name="importe" class="form-control" value="${contrato.importe}" required>
                </div>

                <div class="mb-3">
                    <label for="estado" class="form-label">Estado</label>
                    <select id="estado" name="estado" class="form-select" required>
                        <option value="abierto" ${contrato.estado == 'abierto' ? 'selected' : ''}>Abierto</option>
                        <option value="en negociacion" ${contrato.estado == 'en negociacion' ? 'selected' : ''}>En negociación</option>
                        <option value="adjudicado" ${contrato.estado == 'adjudicado' ? 'selected' : ''}>Adjudicado</option>
                        <option value="cerrado" ${contrato.estado == 'cerrado' ? 'selected' : ''}>Cerrado</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="fechaInicio" class="form-label">Fecha de Inicio</label>
                    <input type="date" id="fechaInicio" name="fechaInicio" class="form-control" value="${contrato.fechaInicio}" required>
                </div>

                <div class="mb-3">
                    <label for="fechaFin" class="form-label">Fecha de Fin</label>
                    <input type="date" id="fechaFin" name="fechaFin" class="form-control" value="${contrato.fechaFin}" required>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="${pageContext.request.contextPath}/contrato" class="btn btn-secondary">Cancelar</a>
                    <a href="${pageContext.request.contextPath}/contrato" class="btn btn-secondary">Volver al listado</a>
                </div>

            </form>
        </div>
    </div>
</div>

</body>
</html>





