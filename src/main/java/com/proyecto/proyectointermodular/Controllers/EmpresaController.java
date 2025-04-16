package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.EmpresaDAO;
import com.proyecto.proyectointermodular.models.Empresa;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresaController", urlPatterns = {"/empresa"})
public class EmpresaController extends HttpServlet {

    private EmpresaDAO empresaDAO;

    @Override
    public void init() throws ServletException {
        empresaDAO = new EmpresaDAO();
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
                    deleteEmpresa(request, response);
                    break;
                default:
                    listEmpresas(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("insert".equals(action)) {
                insertEmpresa(request, response);
            } else if ("update".equals(action)) {
                updateEmpresa(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listEmpresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empresa> empresas = empresaDAO.listarEmpresas();
        request.setAttribute("empresas", empresas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("empresa/listaEmpresas.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("empresa/formEmpresa.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Empresa empresa = empresaDAO.getEmpresaById(id);

        if (empresa == null) {
            response.sendRedirect("empresa");
            return;
        }
        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("empresa/formEmpresa.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String sector = request.getParameter("sector");
        String paisOrigenId = request.getParameter("paisOrigenId");

        Empresa empresa = new Empresa(id, nombre, sector, paisOrigenId);
        empresaDAO.insertarEmpresa(empresa);
        response.sendRedirect("empresa");
    }

    private void updateEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String sector = request.getParameter("sector");
        String paisOrigenId = request.getParameter("paisOrigenId");

        Empresa empresa = new Empresa(id, nombre, sector, paisOrigenId);
        empresaDAO.updateEmpresa(empresa);
        response.sendRedirect("empresa");
    }

    private void deleteEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        empresaDAO.deleteEmpresa(id);
        response.sendRedirect("empresa");
    }
}
