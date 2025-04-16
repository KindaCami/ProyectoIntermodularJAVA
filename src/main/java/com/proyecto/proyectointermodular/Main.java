package com.proyecto.proyectointermodular;

import com.proyecto.proyectointermodular.BBDD.DAO.PostulacionDAO;
import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.models.Postulacion;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostulacionDAO dao = new PostulacionDAO();

        // Crear una postulación
        Empresa empresa = new Empresa();
        empresa.setId("GMV001");

        Contrato contrato = new Contrato();
        contrato.setId(1);

        Postulacion postulacion = new Postulacion(empresa, contrato, new BigDecimal("1200000.00"), "pendiente");

        if (!dao.existePostulacion("GMV001", 1)) {
            boolean insertado = dao.insertarPostulacion(postulacion);
            if (insertado) {
                System.out.println(" Postulación insertada correctamente.");
            } else {
                System.out.println(" Error al insertar postulación.");
            }
        } else {
            System.out.println(" La postulación ya existe.");
        }

        // Listar postulaciones
        List<Postulacion> postulaciones = dao.listarPostulaciones();
        System.out.println("\n POSTULACIONES REGISTRADAS:");
        for (Postulacion p : postulaciones) {
            System.out.println(p);
        }
    }
}



