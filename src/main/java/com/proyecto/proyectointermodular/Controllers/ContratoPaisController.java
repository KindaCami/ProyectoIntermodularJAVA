package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.ContratoDAO;
import com.proyecto.proyectointermodular.BBDD.DAO.ContratoPaisDAO;
import com.proyecto.proyectointermodular.BBDD.DAO.PaisDAO;
import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.ContratoPais;
import com.proyecto.proyectointermodular.models.Pais;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContratoPaisController", urlPatterns = {"/contratoPais"})
public class ContratoPaisController extends HttpServlet {

    private ContratoPaisDAO contratoPaisDAO;
    private ContratoDAO contratoDAO;
    private PaisDAO paisDAO;

    @Override
    public void init() throws ServletException {
        contratoPaisDAO = new ContratoPaisDAO();
        contratoDAO = new ContratoDAO();
        paisDAO = new PaisDAO();
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
                    deleteRelacion(request, response);
                    break;
                default:
                    listRelaciones(request, response);
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
                insertRelacion(request, response);
            } else if ("update".equals(action)) {
                updateRelacion(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listRelaciones(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<ContratoPais> relaciones = contratoPaisDAO.listarRelaciones();
        request.setAttribute("relaciones", relaciones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contratoPais/listContratoPais.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Contrato> contratos = contratoDAO.listarContratos();
        List<Pais> paises = paisDAO.getAllPaises();
        request.setAttribute("contratos", contratos);
        request.setAttribute("paises", paises);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contratoPais/formContratoPais.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        String paisId = request.getParameter("paisId");

        boolean relacion = contratoPaisDAO.existeRelacion(contratoId, paisId);
        request.setAttribute("relacion", relacion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contratoPais/formContratoPais.jsp");
        dispatcher.forward(request, response);
    }

    private void insertRelacion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        String paisId = request.getParameter("paisId");
        BigDecimal aporte = new BigDecimal(request.getParameter("aporte"));

        Contrato contrato = contratoDAO.getContratoById(contratoId);
        Pais pais = paisDAO.getPaisById(paisId);
        ContratoPais relacion = new ContratoPais(contrato, pais, aporte);

        if (!contratoPaisDAO.existeRelacion(contratoId, paisId)) {
            contratoPaisDAO.insertarRelacion(relacion);
        } else {
            System.out.println(" Ya existe esta relación contrato-país. No se inserta.");
        }

        response.sendRedirect("contratoPais?action=list");
    }


    private void updateRelacion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        String paisId = request.getParameter("paisId");
        BigDecimal nuevoAporte = new BigDecimal(request.getParameter("aporte"));

        contratoPaisDAO.actualizarAporte(contratoId, paisId, nuevoAporte);
        response.sendRedirect("contratoPais?action=list");
    }

    private void deleteRelacion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        String paisId = request.getParameter("paisId");

        contratoPaisDAO.eliminarRelacion(contratoId, paisId);
        response.sendRedirect("contratoPais?action=list");
    }
}
