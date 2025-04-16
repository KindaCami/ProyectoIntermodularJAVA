package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.ContratoDAO;
import com.proyecto.proyectointermodular.models.Contrato;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ContratoController", urlPatterns = {"/contrato"})
public class ContratoController extends HttpServlet {

    private ContratoDAO contratoDAO;

    @Override
    public void init() throws ServletException {
        contratoDAO = new ContratoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteContrato(request, response);
                    break;
                default:
                    listContratos(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("insert".equals(action)) {
                insertContrato(request, response);
            } else if ("update".equals(action)) {
                updateContrato(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listContratos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Contrato> contratos = contratoDAO.listarContratos();
        request.setAttribute("contratos", contratos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contrato/listContratos.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contrato/formContrato.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idContrato = Integer.parseInt(request.getParameter("idContrato"));

            Contrato contrato = contratoDAO.getContratoById(idContrato);

            if (contrato == null) {
                response.sendRedirect("contrato"); // Por si no existe, lo redirige
                return;
            }

            request.setAttribute("contrato", contrato);
            RequestDispatcher dispatcher = request.getRequestDispatcher("contrato/formContrato.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("⚠️ Error al cargar el formulario de edición de contrato", e);
        }
    }


    private void insertContrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String ambito = request.getParameter("ambito");
        BigDecimal importe = new BigDecimal(request.getParameter("importe"));
        String estado = request.getParameter("estado");
        LocalDate fechaInicio = LocalDate.parse(request.getParameter("fechaInicio"));
        LocalDate fechaFin = LocalDate.parse(request.getParameter("fechaFin"));

        Contrato contrato = new Contrato(0, titulo, descripcion, ambito, importe, estado, fechaInicio, fechaFin);
        contratoDAO.addContrato(contrato);
        response.sendRedirect("contrato");
    }

    private void updateContrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {
            int idContrato = Integer.parseInt(request.getParameter("idContrato")); // Si falla, cae al catch

            Contrato contrato = new Contrato(
                    idContrato,
                    request.getParameter("titulo"),
                    request.getParameter("descripcion"),
                    request.getParameter("ambito"),
                    new BigDecimal(request.getParameter("importe")),
                    request.getParameter("estado"),
                    LocalDate.parse(request.getParameter("fechaInicio")),
                    LocalDate.parse(request.getParameter("fechaFin"))
            );

            contratoDAO.updateContrato(contrato);
            response.sendRedirect("contrato");

        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(" Error: datos incompletos o mal formateados al actualizar contrato.");
            response.sendRedirect("contrato");
        }
    }


    private void deleteContrato(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int contratoId = Integer.parseInt(request.getParameter("idContrato"));
        contratoDAO.deleteContrato(contratoId);
        response.sendRedirect("contrato");
    }
}

