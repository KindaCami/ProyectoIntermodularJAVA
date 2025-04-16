package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaPaisDAO {

    // INSERTAR relación
    public boolean insertarRelacion(String empresaId, String paisId) {
        String sql = "INSERT INTO empresa_pais (empresa_id, pais_id) VALUES (?, ?)";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setString(2, paisId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(" Error al insertar relación empresa-pais: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR relación
    public boolean eliminarRelacion(String empresaId, String paisId) {
        String sql = "DELETE FROM empresa_pais WHERE empresa_id = ? AND pais_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setString(2, paisId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(" Error al eliminar relación empresa-pais: " + e.getMessage());
            return false;
        }
    }

    // VERIFICAR si ya existe la relación
    public boolean existeRelacion(String empresaId, String paisId) {
        String sql = "SELECT COUNT(*) FROM empresa_pais WHERE empresa_id = ? AND pais_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ps.setString(2, paisId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            System.out.println(" Error al verificar relación: " + e.getMessage());
        }
        return false;
    }

    // LISTAR países en los que opera una empresa
    public List<String> listarPaisesPorEmpresa(String empresaId) {
        List<String> paises = new ArrayList<>();
        String sql = "SELECT pais_id FROM empresa_pais WHERE empresa_id = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                paises.add(rs.getString("pais_id"));
            }

        } catch (SQLException e) {
            System.out.println(" Error al listar países de la empresa: " + e.getMessage());
        }
        return paises;
    }
}
