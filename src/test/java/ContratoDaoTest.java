package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.models.Contrato;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ContratoDaoTest {
    private static ContratoDAO contratoDAO;

    @BeforeAll
    static void setup() {
        contratoDAO = new ContratoDAO();
    }

    @Test
    void testInsertarYObtenerContrato() {
        Contrato contrato = new Contrato(0, "Test JUnit", "Contrato de prueba", "idi",
                new BigDecimal("1000000"), "abierto", LocalDate.now(), LocalDate.now().plusMonths(6));

        contratoDAO.addContrato(contrato);

        List<Contrato> contratos = contratoDAO.listarContratos();
        boolean encontrado = contratos.stream().anyMatch(c -> "Test JUnit".equals(c.getTitulo()));

        assertTrue(encontrado, "El contrato de prueba no fue encontrado en la lista.");
    }
}

