package com.proyecto.proyectointermodular.controller;

import com.proyecto.proyectointermodular.BBDD.DAO.PostulacionDAO;
import com.proyecto.proyectointermodular.models.Postulacion;
import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.BBDD.DAO.EmpresaDAO;
import com.proyecto.proyectointermodular.BBDD.DAO.ContratoDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@WebServlet(name = "PostulacionController", urlPatterns = {"/postulacion"})
public class PostulacionController extends HttpServlet {

    private PostulacionDAO postulacionDAO;
    private EmpresaDAO empresaDAO;
    private ContratoDAO contratoDAO;

    @Override
    public void init() throws ServletException {
        postulacionDAO = new PostulacionDAO();
        empresaDAO = new EmpresaDAO();
        contratoDAO = new ContratoDAO();
        postulacionDAO = new PostulacionDAO();
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
                    deletePostulacion(request, response);
                    break;
                default:
                    listPostulaciones(request, response);
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
                insertPostulacion(request, response);
            } else if ("update".equals(action)) {
                updatePostulacion(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listPostulaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Postulacion> postulaciones = postulacionDAO.listarPostulaciones();
        request.setAttribute("postulaciones", postulaciones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("postulacion/listPostulacion.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empresa> empresas = empresaDAO.listarEmpresas();
        List<Contrato> contratos = contratoDAO.listarContratos();

        request.setAttribute("empresas", empresas);
        request.setAttribute("contratos", contratos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("postulacion/formPostulacion.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empresaId = request.getParameter("empresaId");
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));

        Postulacion postulacion = postulacionDAO.getPostulacion(empresaId, contratoId);
        List<Empresa> empresas = empresaDAO.listarEmpresas();
        List<Contrato> contratos = contratoDAO.listarContratos();

        request.setAttribute("postulacion", postulacion);
        request.setAttribute("empresas", empresas);
        request.setAttribute("contratos", contratos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("postulacion/formPostulacion.jsp");
        dispatcher.forward(request, response);
    }


    private void insertPostulacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String empresaId = request.getParameter("empresaId");
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        BigDecimal propuestaImporte = new BigDecimal(request.getParameter("propuestaImporte"));
        String resultado = request.getParameter("resultado");

        Empresa empresa = new Empresa();
        empresa.setId(empresaId);
        Contrato contrato = new Contrato();
        contrato.setId(contratoId);

        Postulacion postulacion = new Postulacion(empresa, contrato, propuestaImporte, resultado);
        postulacionDAO.insertarPostulacion(postulacion);
        response.sendRedirect("postulacion");
    }
      //  Lógica pendiente para determinar automáticamente el resultado de la postulación
      // Ejemplo: Si propuesta <= presupuesto disponible del contrato => resultado = "ganada", sino "rechazada
      // Por ahora debe guardarse como "pendiente"


    private void updatePostulacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String empresaId = request.getParameter("empresaId");
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));
        BigDecimal propuesta = new BigDecimal(request.getParameter("propuestaImporte"));
        String resultado = request.getParameter("resultado");

        Postulacion postulacion = new Postulacion();
        postulacion.setEmpresa(new Empresa(empresaId, "", "", ""));
        postulacion.setContrato(new Contrato());
        postulacion.getContrato().setId(contratoId);
        postulacion.setPropuestaImporte(propuesta);
        postulacion.setResultado(resultado);

        postulacionDAO.actualizarResultado(postulacion);
        response.sendRedirect("postulacion");
    }


    private void deletePostulacion(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String empresaId = request.getParameter("empresaId");
        int contratoId = Integer.parseInt(request.getParameter("contratoId"));

        postulacionDAO.eliminarPostulacion(empresaId, contratoId);
        response.sendRedirect("postulacion");
    }
}
