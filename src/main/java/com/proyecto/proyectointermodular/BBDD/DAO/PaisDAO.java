package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import com.proyecto.proyectointermodular.models.Empresa;
import com.proyecto.proyectointermodular.models.Pais;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {


    // SELECT: hacer un array con los paises existentes

    public ArrayList<Pais> getAllPaises() throws SQLException {
        ArrayList<Pais> paises = new ArrayList<>();

        String query = "SELECT * FROM pais";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setId(rs.getString("idPais"));
                pais.setNombre(rs.getString("nombre"));
                pais.setPresupuestoTotal(rs.getBigDecimal("presupuesto_total"));
                pais.setPresupuestoAsignado(rs.getBigDecimal("presupuesto_asignado"));

                paises.add(pais);
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener paises: " + e.getMessage());
        }
        return paises;

    }

    // GET: Buscar un pais existente

    public Pais getPaisById(String idPais) throws SQLException {
        Pais pais = null;
        String query = "SELECT * FROM pais WHERE idPais = ?";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, idPais);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pais = new Pais();
                    pais.setId(rs.getString("idPais"));
                    pais.setNombre(rs.getString("nombre"));
                    pais.setPresupuestoTotal(rs.getBigDecimal("presupuesto_total"));
                    pais.setPresupuestoAsignado(rs.getBigDecimal("presupuesto_asignado"));
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error al buscar pais: " + e.getMessage());
        }
        return pais;
    }

    // ADD/INSERT: agregar un pais

    public boolean addPais(Pais pais) throws SQLException {
        String query = "INSERT INTO pais (idPais, nombre, presupuesto_total, presupuesto_asignado) VALUES (?, ?, ?, ?)";

        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pais.getId());
            ps.setString(2, pais.getNombre());
            ps.setBigDecimal(3, pais.getPresupuestoTotal());
            ps.setBigDecimal(4, pais.getPresupuestoAsignado());

            int filaInsertada = ps.executeUpdate();
            return filaInsertada > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar país: " + e.getMessage());
            return false;
        }
    }
// UPDATE: actualizar un pais

    public boolean updatePais(Pais pais) throws SQLException {
        String query = "UPDATE pais SET nombre = ?, presupuesto_asignado = ?, presupuesto_total = ? WHERE idPais = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pais.getNombre());
            ps.setBigDecimal(2, pais.getPresupuestoAsignado());
            ps.setBigDecimal(3, pais.getPresupuestoTotal());
            ps.setString(4, pais.getId());

            int filaActualizada = ps.executeUpdate();
            if (filaActualizada > 0) {
                System.out.println("Se actualizó correctamente el país. Filas modificadas: " + filaActualizada);
                return true;
            } else {
                System.out.println("No se encontró ningún país con ese ID. No se modificó ninguna fila.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("  Error al actualizar país: " + e.getMessage());
            return false;
        }
    }
    // DELETE: Eliminar un pais

    public boolean deletePais(Pais pais) throws SQLException {
        String query = "DELETE FROM pais WHERE idPais = ?";
        try (Connection conn = BBDDConnector.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pais.getId());

            int filaEliminada = ps.executeUpdate();
            if (filaEliminada > 0) {
                System.out.println("Pais eliminado correctamente. Filas afectadas: " + filaEliminada);
                return true;

            } else {
                System.out.println("No se encontró pais con el ID pais: " + pais.getId());
                return false;
            }
        } catch (SQLException e) {
            System.out.println("  Error al eliminar pais: " + e.getMessage());
            return false;
        }
    }

        // Verificar si un pais existe

        public boolean existePais(String idPais) {
            String sql = "SELECT COUNT(*) FROM pais WHERE idPais = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, idPais);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }

            } catch (SQLException e) {
                System.out.println(" Error al verificar existencia del país: " + e.getMessage());
            }

            return false;
        }

    }




