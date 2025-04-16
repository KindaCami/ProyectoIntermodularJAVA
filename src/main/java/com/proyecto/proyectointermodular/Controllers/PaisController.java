package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.PaisDAO;
import com.proyecto.proyectointermodular.models.Pais;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PaisController", urlPatterns = {"/pais"})
public class PaisController extends HttpServlet {

    private PaisDAO paisDAO;

    @Override
    public void init() throws ServletException {
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
                    deletePais(request, response);
                    break;
                default:
                    listPaises(request, response);
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
                insertPais(request, response);
            } else if ("update".equals(action)) {
                updatePais(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listPaises(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        ArrayList<Pais> lista = paisDAO.getAllPaises();
        request.setAttribute("listaPaises", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pais/listaPaises.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pais/formPais.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Pais pais = paisDAO.getPaisById(id);
        request.setAttribute("pais", pais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pais/formPais.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPais(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        BigDecimal presupuestoTotal = new BigDecimal(request.getParameter("presupuestoTotal"));
        BigDecimal presupuestoAsignado = new BigDecimal(request.getParameter("presupuestoAsignado"));

        Pais pais = new Pais(id, nombre, presupuestoTotal, presupuestoAsignado);
        paisDAO.addPais(pais);
        response.sendRedirect("pais");
    }

    private void updatePais(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        BigDecimal presupuestoTotal = new BigDecimal(request.getParameter("presupuestoTotal"));
        BigDecimal presupuestoAsignado = new BigDecimal(request.getParameter("presupuestoAsignado"));

        Pais pais = new Pais(id, nombre, presupuestoTotal, presupuestoAsignado);
        paisDAO.updatePais(pais);
        response.sendRedirect("pais");
    }

    private void deletePais(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        Pais pais = new Pais();
        pais.setId(id);
        paisDAO.deletePais(pais);
        response.sendRedirect("pais");
    }
}


