package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import com.proyecto.proyectointermodular.models.Contrato;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.models.Postulacion;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostulacionDAO {

    //  INSERT
    public boolean insertarPostulacion(Postulacion postulacion) {
        String sql = "INSERT INTO postulacion (empresa_id, contrato_id, propuesta_importe, resultado) VALUES (?, ?, ?, ?)";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, postulacion.getEmpresa().getId());
            ps.setInt(2, postulacion.getContrato().getId());
            ps.setBigDecimal(3, postulacion.getPropuestaImporte());
            ps.setString(4, postulacion.getResultado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(" Error al insertar postulación: " + e.getMessage());
            return false;
        }
    }
    //  SELECT con JOIN
    public List<Postulacion> listarPostulaciones() {
        List<Postulacion> postulaciones = new ArrayList<>();
        String sql = "SELECT p.empresa_id, e.nombre AS empresa_nombre, p.contrato_id, c.titulo AS contrato_titulo, " +
                "p.propuesta_importe, p.resultado " +
                "FROM postulacion p " +
                "JOIN empresa e ON p.empresa_id = e.idEmpresa " +
                "JOIN contrato c ON p.contrato_id = c.idContrato";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getString("empresa_id"));
                empresa.setNombre(rs.getString("empresa_nombre"));

                Contrato contrato = new Contrato();
                contrato.setId(rs.getInt("contrato_id"));
                contrato.setTitulo(rs.getString("contrato_titulo"));

                BigDecimal propuesta = rs.getBigDecimal("propuesta_importe");
                if (propuesta == null) propuesta = BigDecimal.ZERO;
                String resultado = rs.getString("resultado");

                postulaciones.add(new Postulacion(empresa, contrato, propuesta, resultado));
            }

        } catch (SQLException e) {
            System.out.println(" Error al listar postulaciones: " + e.getMessage());
        }
        return postulaciones;
    }

    // UPDATE
    public boolean actualizarResultado(String empresaId, int contratoId, String nuevoResultado) {
        String sql = "UPDATE postulacion SET resultado = ? WHERE empresa_id = ? AND contrato_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoResultado);
            ps.setString(2, empresaId);
            ps.setInt(3, contratoId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(" Error al actualizar resultado de la postulación: " + e.getMessage());
            return false;
        }
    }


    //  DELETE
    public boolean eliminarPostulacion(String empresaId, int contratoId) {
        String sql = "DELETE FROM postulacion WHERE empresa_id = ? AND contrato_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setInt(2, contratoId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(" Error al eliminar postulación: " + e.getMessage());
            return false;
        }
    }

    //  GET por clave compuesta
    public Postulacion getPostulacion(String empresaId, int contratoId) {
        String sql = "SELECT * FROM postulacion WHERE empresa_id = ? AND contrato_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setInt(2, contratoId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(empresaId);

                Contrato contrato = new Contrato();
                contrato.setId(contratoId);

                BigDecimal propuesta = rs.getBigDecimal("propuesta_importe");
                if (propuesta == null) propuesta = BigDecimal.ZERO;
                String resultado = rs.getString("resultado");

                return new Postulacion(empresa, contrato, propuesta, resultado);
            }

        } catch (SQLException e) {
            System.out.println(" Error al obtener postulación: " + e.getMessage());
        }
        return null;
    }
    // Verificar si ya existe una postulación para esa empresa y contrato
    public boolean existePostulacion(String empresaId, int contratoId) {
        String sql = "SELECT COUNT(*) FROM postulacion WHERE empresa_id = ? AND contrato_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setInt(2, contratoId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println(" Error al verificar existencia de postulación: " + e.getMessage());
        }
        return false;
    }

}
