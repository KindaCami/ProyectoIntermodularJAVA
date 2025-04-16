package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import com.proyecto.proyectointermodular.models.Empresa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    // INSERT/ADD: agregar una empresa
    public boolean insertarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO Empresa (idEmpresa, nombre, sector, pais_origen_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empresa.getId());
            stmt.setString(2, empresa.getNombre());
            stmt.setString(3, empresa.getSector());
            stmt.setString(4, empresa.getPaisOrigenId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar empresa: " + e.getMessage());
            e.printStackTrace(); //  muestra el origen exacto del error
            return false;
        }
    }
// Verificar si empresa existe
    public boolean existeEmpresa(String idEmpresa) {
        String sql = "SELECT COUNT(*) FROM Empresa WHERE idEmpresa = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar: La empresa: " + idEmpresa + "ya existe. " + e.getMessage());
        }
        return false;
    }


    // SELECT: listar todas las empresas en un array
    public List<Empresa> listarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM Empresa";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getString("idEmpresa"),
                        rs.getString("nombre"),
                        rs.getString("sector"),
                        rs.getString("pais_origen_id")
                );
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar empresas: " + e.getMessage());
        }
        return empresas;
    }
    public Empresa getEmpresaById(String idEmpresa) {
        Empresa empresa = null;
        String sql = "SELECT * FROM empresa WHERE idEmpresa = ?";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idEmpresa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empresa = new Empresa(
                            rs.getString("idEmpresa"),
                            rs.getString("nombre"),
                            rs.getString("sector"),
                            rs.getString("pais_origen_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener empresa por ID: " + e.getMessage());
        }

        return empresa;
    }
// Actualizar
    public boolean updateEmpresa(Empresa empresa) {
        String sql = "UPDATE empresa SET nombre = ?, sector = ?, pais_origen_id = ? WHERE idEmpresa = ?";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empresa.getNombre());
            ps.setString(2, empresa.getSector());
            ps.setString(3, empresa.getPaisOrigenId());
            ps.setString(4, empresa.getId());

            int filasModificadas = ps.executeUpdate();
            if (filasModificadas > 0) {
                System.out.println(" Empresa actualizada correctamente.");
                return true;
            } else {
                System.out.println(" No se encontró ninguna empresa con ese ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(" Error al actualizar empresa: " + e.getMessage());
            return false;
        }
    }
// Borrar empresas
        public boolean deleteEmpresa(String idEmpresa) {
            String sql = "DELETE FROM empresa WHERE idEmpresa = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, idEmpresa);

                int filasEliminadas = ps.executeUpdate();
                if (filasEliminadas > 0) {
                    System.out.println(" Empresa eliminada correctamente.");
                    return true;
                } else {
                    System.out.println(" No se encontró empresa con ese ID.");
                    return false;
                }

            } catch (SQLException e) {
                System.out.println(" Error al eliminar empresa: " + e.getMessage());
                return false;
            }
        }

}
