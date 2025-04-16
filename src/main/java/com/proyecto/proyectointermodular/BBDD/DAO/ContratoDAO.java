package com.proyecto.proyectointermodular.BBDD.DAO;

import com.proyecto.proyectointermodular.BBDD.BBDDConnector;
import com.proyecto.proyectointermodular.models.Contrato;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


    public class ContratoDAO {

        // INSERT
        public boolean addContrato(Contrato contrato) {
            String sql = "INSERT INTO contrato (titulo, descripcion, ambito, importe, estado, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                BigDecimal importe = contrato.getImporte() != null ? contrato.getImporte() : BigDecimal.ZERO;

                ps.setString(1, contrato.getTitulo());
                ps.setString(2, contrato.getDescripcion());
                ps.setString(3, contrato.getAmbito());
                ps.setBigDecimal(4, contrato.getImporte());
                ps.setString(5, contrato.getEstado());
                ps.setDate(6, Date.valueOf(contrato.getFechaInicio()));
                ps.setDate(7, Date.valueOf(contrato.getFechaFin()));

                int inserted = ps.executeUpdate();
                return inserted > 0;

            } catch (SQLException e) {
                System.out.println(" Error al insertar contrato: " + e.getMessage());
                return false;
            }
        }

        // GET BY ID
        public Contrato getContratoById(int idContrato) {
            Contrato contrato = null;
            String sql = "SELECT * FROM contrato WHERE idContrato = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, idContrato);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    contrato = new Contrato(
                            rs.getInt("idContrato"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getString("ambito"),
                            rs.getBigDecimal("importe"),
                            rs.getString("estado"),
                            rs.getDate("fecha_inicio").toLocalDate(),
                            rs.getDate("fecha_fin").toLocalDate());
                }

            } catch (SQLException e) {
                System.out.println(" Error al buscar contrato: " + e.getMessage());
            }

            return contrato;
        }

        // SELECT/ LISTAR
        public List<Contrato> listarContratos() {
            List<Contrato> contratos = new ArrayList<>();
            String sql = "SELECT * FROM contrato";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Contrato contrato = new Contrato(
                            rs.getInt("idContrato"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getString("ambito"),
                            rs.getBigDecimal("importe"),
                            rs.getString("estado"),
                            rs.getDate("fecha_inicio").toLocalDate(),
                            rs.getDate("fecha_fin").toLocalDate()
                    );
                    contratos.add(contrato);
                }

            } catch (SQLException e) {
                System.out.println(" Error al listar contratos: " + e.getMessage());
            }

            return contratos;
        }

        // UPDATE
        public boolean updateContrato(Contrato contrato) {
            String sql = "UPDATE contrato SET titulo = ?, descripcion = ?, ambito = ?, importe = ?, estado = ?, fecha_inicio = ?, fecha_fin = ? WHERE idContrato = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                BigDecimal importe = contrato.getImporte() != null ? contrato.getImporte() : BigDecimal.ZERO;

                ps.setString(1, contrato.getTitulo());
                ps.setString(2, contrato.getDescripcion());
                ps.setString(3, contrato.getAmbito());
                ps.setBigDecimal(4, contrato.getImporte());
                ps.setString(5, contrato.getEstado());
                ps.setDate(6, Date.valueOf(contrato.getFechaInicio()));
                ps.setDate(7, Date.valueOf(contrato.getFechaFin()));
                ps.setInt(8, contrato.getId());

                int actualizados = ps.executeUpdate();
                return actualizados > 0;

            } catch (SQLException e) {
                System.out.println(" Error al actualizar contrato: " + e.getMessage());
                return false;
            }
        }

        // DELETE
        public boolean deleteContrato(int idContrato) {
            String sql = "DELETE FROM contrato WHERE idContrato = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, idContrato);
                int eliminados = ps.executeUpdate();
                return eliminados > 0;

            } catch (SQLException e) {
                System.out.println(" Error al eliminar contrato: " + e.getMessage());
                return false;
            }
        }

        // Metodo para saber si existe un contrato
        public boolean existeContrato(int idContrato) {
            String sql = "SELECT COUNT(*) FROM contrato WHERE idContrato = ?";

            try (Connection conn = BBDDConnector.getInstance().getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, idContrato);
                ResultSet rs = ps.executeQuery();

                return rs.next() && rs.getInt(1) > 0;

            } catch (SQLException e) {
                System.out.println(" Error al verificar contrato: " + e.getMessage());
                return false;
            }
        }
    }

