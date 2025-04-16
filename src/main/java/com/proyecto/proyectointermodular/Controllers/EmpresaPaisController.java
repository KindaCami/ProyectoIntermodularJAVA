package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.EmpresaDAO;
import com.proyecto.proyectointermodular.BBDD.DAO.EmpresaPaisDAO;
import com.proyecto.proyectointermodular.BBDD.DAO.PaisDAO;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.models.Pais;
import com.proyecto.proyectointermodular.viewmodels.EmpresaPaisViewModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpresaPaisController", urlPatterns = {"/empresaPais"})
public class EmpresaPaisController extends HttpServlet {

    private EmpresaPaisDAO empresaPaisDAO;
    private EmpresaDAO empresaDAO;
    private PaisDAO paisDAO;

    @Override
    public void init() {
        empresaPaisDAO = new EmpresaPaisDAO();
        empresaDAO = new EmpresaDAO();
        paisDAO = new PaisDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "delete":
                    eliminarRelacion(request, response);
                    break;
                default:
                    listarRelaciones(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listarRelaciones(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        List<Empresa> empresas = empresaDAO.listarEmpresas();
        List<EmpresaPaisViewModel> relacionesVM = new ArrayList<>();

        for (Empresa empresa : empresas) {
            List<String> paisesId = empresaPaisDAO.listarPaisesPorEmpresa(empresa.getId());
            for (String paisId : paisesId) {
                Pais pais = paisDAO.getPaisById(paisId);
                if (pais != null) {
                    relacionesVM.add(new EmpresaPaisViewModel(
                            empresa.getId(),
                            empresa.getNombre(),
                            pais.getId(),
                            pais.getNombre()
                    ));
                }
            }
        }

        request.setAttribute("relaciones", relacionesVM);
        request.getRequestDispatcher("empresaPais/listEmpresaPais.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        List<Empresa> empresas = empresaDAO.listarEmpresas();
        List<Pais> paises = paisDAO.getAllPaises();

        request.setAttribute("empresas", empresas);
        request.setAttribute("paises", paises);

        request.getRequestDispatcher("empresaPais/formEmpresaPais.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String empresaId = request.getParameter("empresaId");
        String paisId = request.getParameter("paisId");

        if (!empresaPaisDAO.existeRelacion(empresaId, paisId)) {
            empresaPaisDAO.insertarRelacion(empresaId, paisId);
        }

        response.sendRedirect("empresaPais");
    }

    private void eliminarRelacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String empresaId = request.getParameter("empresaId");
        String paisId = request.getParameter("paisId");

        empresaPaisDAO.eliminarRelacion(empresaId, paisId);
        response.sendRedirect("empresaPais");
    }
}


