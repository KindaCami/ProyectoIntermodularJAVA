package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.models.Postulacion;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostulacionDAOTest {

    static PostulacionDAO postulacionDAO;
    static EmpresaDAO empresaDAO;
    static ContratoDAO contratoDAO;
    static String testEmpresaId = "Junit5";
    static int testContratoId = 20;

    @BeforeAll
    static void setup() {
        postulacionDAO = new PostulacionDAO();
        empresaDAO = new EmpresaDAO();
        contratoDAO = new ContratoDAO();

        empresaDAO.insertarEmpresa(new Empresa(testEmpresaId, "Empresa Test", "Tecnología", "GER"));
        contratoDAO.addContrato(new Contrato(testContratoId, "Contrato Test", "Descripción", "idi",
                new BigDecimal("10000"), "abierto", LocalDate.parse("2025-04-24"), LocalDate.parse("2025-05-24")));
    }

    @Test
    @Order(1)
    void testInsertarPostulacion() {
        Postulacion postulacion = new Postulacion(
                new Empresa(testEmpresaId, null, null, null),
                new Contrato(testContratoId, null, null, null, null, null, null, null),
                new BigDecimal("5000"),
                "pendiente"
        );
        assertTrue(postulacionDAO.insertarPostulacion(postulacion));
    }

    @Test
    @Order(2)
    void testExistePostulacion() {
        assertTrue(postulacionDAO.existePostulacion(testEmpresaId, testContratoId));
    }

    @Test
    @Order(3)
    void testGetPostulacion() {
        Postulacion p = postulacionDAO.getPostulacion("EMP_TEST", 16);
        assertNotNull(p);
        assertEquals("pendiente", p.getResultado());
    }

    @Test
    @Order(4)
    void testActualizarResultado() {
        assertTrue(postulacionDAO.actualizarResultado("EMP_TEST", 16, "ganada"));
        Postulacion p = postulacionDAO.getPostulacion("EMP_TEST", 16);
        assertEquals("ganada", p.getResultado());
    }

    @Test
    @Order(5)
    void testListarPostulaciones() {
        List<Postulacion> lista = postulacionDAO.listarPostulaciones();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
    }

    @Test
    @Order(6)
    void testEliminarPostulacion() {
        assertTrue(postulacionDAO.existePostulacion("Junit5", 20), "La postulación debería existir antes de eliminarla");
        assertTrue(postulacionDAO.eliminarPostulacion("Junit5", 20), "La eliminación debería ser exitosa");
        assertFalse(postulacionDAO.existePostulacion("Junit5", 20), "La postulación debería haber sido eliminada");
    }
}
