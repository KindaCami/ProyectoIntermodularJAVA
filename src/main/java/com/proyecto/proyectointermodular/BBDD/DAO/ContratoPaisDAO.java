package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.ContratoPais;
import com.proyecto.proyectointermodular.models.Pais;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoPaisDAO {

    // INSERT
    public boolean insertarRelacion(ContratoPais relacion) {
        String sql = "INSERT INTO contrato_pais (contrato_id, pais_id, aporte) VALUES (?, ?, ?)";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, relacion.getContrato().getId());
            ps.setString(2, relacion.getPais().getId());
            ps.setBigDecimal(3, relacion.getAporte());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(" Error al insertar relación contrato-pais: " + e.getMessage());
            return false;
        }
    }

    // SELECT:
    public List<ContratoPais> listarRelaciones() {
        List<ContratoPais> relaciones = new ArrayList<>();
        String sql =
                "SELECT cp.aporte, " +
                        "c.idContrato AS contrato_id, c.titulo AS contrato_titulo, " +
                        "p.idPais AS pais_id, p.nombre AS pais_nombre " +
                        "FROM contrato_pais cp " +
                        "JOIN contrato c ON cp.contrato_id = c.idContrato " +
                        "JOIN pais p ON cp.pais_id = p.idPais";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setId(rs.getInt("contrato_id"));
                contrato.setTitulo(rs.getString("contrato_titulo"));

                Pais pais = new Pais();
                pais.setId(rs.getString("pais_id"));
                pais.setNombre(rs.getString("pais_nombre"));

                BigDecimal aporte = rs.getBigDecimal("aporte");
                if (aporte == null) aporte = BigDecimal.ZERO;

                relaciones.add(new ContratoPais(contrato, pais, aporte));
            }

        } catch (SQLException e) {
            System.out.println(" Error al listar relaciones: " + e.getMessage());
        }

        return relaciones;
    }

    // DELETE
    public boolean eliminarRelacion(int contratoId, String paisId) {
        String sql = "DELETE FROM contrato_pais WHERE contrato_id = ? AND pais_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, contratoId);
            ps.setString(2, paisId);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(" Error al eliminar relación: " + e.getMessage());
            return false;
        }
    }

    // UPDATE
    public boolean actualizarAporte(int contratoId, String paisId, BigDecimal nuevoAporte) {
        String sql = "UPDATE contrato_pais SET aporte = ? WHERE contrato_id = ? AND pais_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBigDecimal(1, nuevoAporte);
            ps.setInt(2, contratoId);
            ps.setString(3, paisId);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(" Error al actualizar aporte: " + e.getMessage());
            return false;
        }
    }

    // Metodo para calcular el total que un pais aporta
    public BigDecimal calcularImporteContrato(int contratoId) {
        String sql = "SELECT SUM(aporte) AS total FROM contrato_pais WHERE contrato_id = ?";
        BigDecimal total = BigDecimal.ZERO;

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, contratoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getBigDecimal("total");
                if (total == null) total = BigDecimal.ZERO;
            }
        } catch (SQLException e) {
            System.out.println(" Error al calcular importe del contrato: " + e.getMessage());
        }

        return total;
    }

    // Obtener relación específica (para editar)
    public ContratoPais getRelacion(int contratoId, String paisId) {
        String sql = "SELECT * FROM contrato_pais WHERE contrato_id = ? AND pais_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, contratoId);
            ps.setString(2, paisId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setId(contratoId);
                Pais pais = new Pais();
                pais.setId(paisId);
                BigDecimal aporte = rs.getBigDecimal("aporte");
                if (aporte == null) aporte = BigDecimal.ZERO;
                return new ContratoPais(contrato, pais, aporte);
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener relación contrato-pais: " + e.getMessage());
        }
        return null;
    }

    // Metodo para no insertar duplicados
    public boolean existeRelacion(int contratoId, String paisId) {
        String sql = "SELECT COUNT(*) AS total FROM contrato_pais WHERE contrato_id = ? AND pais_id = ?";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, contratoId);
            ps.setString(2, paisId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int total = rs.getInt("total");
                    return total > 0;  // Si hay al menos 1 registro, existe
                }
            }

        } catch (SQLException e) {
            System.out.println(" Error al comprobar existencia de relación contrato-pais: " + e.getMessage());
        }
        return false;
    }

}


