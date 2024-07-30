package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MembresiaData {

    private Connection con = null;

    public MembresiaData() {
        con = Conexion.getConexion();
    }

    public boolean socioExists(int socioId) {
        String sql = "SELECT 1 FROM socios WHERE ID_Socio = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, socioId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void registrarMembresia(Membresia membresia) {
         // Verificar si el socio ya tiene una membresía activa
    if (tieneMembresiaActiva(membresia.getSocio().getId_Socio())) {
        JOptionPane.showMessageDialog(null, "El socio ya tiene una membresía activa.");
        return;
    }
        // Verificar que la fecha de fin no sea anterior a la fecha de inicio
        if (membresia.getFechaFin().before(membresia.getFechaInicio())) {
            JOptionPane.showMessageDialog(null, "La fecha de finalización no puede ser anterior a la fecha de inicio.");
            return;
        }
        String sql = "INSERT INTO membresias (Id_Socio, CantidadPases, Fecha_inicio, Fecha_fin, Costo, Estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, membresia.getSocio().getId_Socio());
            ps.setInt(2, membresia.getCantidadPases());
            ps.setDate(3, new java.sql.Date(membresia.getFechaInicio().getTime()));
            ps.setDate(4, new java.sql.Date(membresia.getFechaFin().getTime()));
            ps.setBigDecimal(5, membresia.getCosto());
            ps.setBoolean(6, membresia.isEstado());
            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idMembresia = rs.getInt(1);
                    System.out.println("Membresía registrada con ID: " + idMembresia);
                }
            } else {
                System.out.println("No se pudo registrar la membresía.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresias: " + e.getMessage());
        }
    }

    private BigDecimal calcularCosto(int cantidadPases, int duracionMeses) {
        BigDecimal costoPorPase = new BigDecimal("10.0"); // Ejemplo: $10 por pase
        BigDecimal costo = costoPorPase.multiply(new BigDecimal(cantidadPases));
        return costo;
    }

    public void renovarMembresia(Membresia membresia, int duracionMeses) {
        String sql = "UPDATE membresias SET Fecha_fin = DATE_ADD(Fecha_fin, INTERVAL ? MONTH), Costo = Costo + ? WHERE Id_Membresia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, duracionMeses);
            BigDecimal costoRenovacion = calcularCosto(membresia.getCantidadPases(), duracionMeses);
            ps.setBigDecimal(2, costoRenovacion);
            ps.setInt(3, membresia.getId_membresia());
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                LocalDate nuevaFechaFin = membresia.getFechaFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(duracionMeses);
                membresia.setFechaFin(Date.valueOf(nuevaFechaFin));
                membresia.setCosto(membresia.getCosto().add(costoRenovacion));
                System.out.println("Membresía renovada hasta: " + nuevaFechaFin);
            } else {
                System.out.println("No se pudo renovar la membresía.");
            }
        } catch (SQLException e) {
            System.out.println("Error al renovar la membresía: " + e.getMessage());
        }
    }

    public void cancelarMembresia(Membresia membresia) {
    String sql = "UPDATE membresias SET Estado = false WHERE Id_Membresia = ?";
    try (Connection con = Conexion.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, membresia.getId_membresia());
        int filasActualizadas = ps.executeUpdate();
        if (filasActualizadas > 0) {
            membresia.setEstado(false);
            System.out.println("Membresía cancelada exitosamente.");
        } else {
            System.out.println("No se pudo cancelar la membresía.");
        }
    } catch (SQLException e) {
        System.out.println("Error al cancelar la membresía: " + e.getMessage());
    }
}

    public List<Membresia> obtenerMembresiasPorSocio(int idSocio) {
        List<Membresia> membresias = new ArrayList<>();
        String sql = "SELECT * FROM membresias WHERE Id_Socio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setId_membresia(rs.getInt("Id_Membresia"));
                Socio socio = new Socio();
                socio.setId_Socio(rs.getInt("Id_Socio"));
                membresia.setSocio(socio);
                membresia.setCantidadPases(rs.getInt("CantidadPases"));
                membresia.setFechaInicio(rs.getDate("Fecha_inicio"));
                membresia.setFechaFin(rs.getDate("Fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("Costo"));
                membresia.setEstado(rs.getBoolean("Estado"));
                membresias.add(membresia);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las membresías: " + e.getMessage());
        }
        return membresias;
    }

    public Membresia obtenerMembresiaPorId(int idMembresia) {
        Membresia membresia = null;
        String sql = "SELECT * FROM membresias WHERE ID_Membresia = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idMembresia);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    membresia = new Membresia();
                    membresia.setId_membresia(rs.getInt("ID_Membresia"));
                    Socio socio = new Socio();
                    socio.setId_Socio(rs.getInt("Id_Socio"));
                    membresia.setSocio(socio);
                    membresia.setCantidadPases(rs.getInt("CantidadPases"));
                    membresia.setFechaInicio(rs.getDate("Fecha_inicio"));
                    membresia.setFechaFin(rs.getDate("Fecha_fin"));
                    membresia.setCosto(rs.getBigDecimal("Costo"));
                    membresia.setEstado(rs.getBoolean("Estado"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la membresía: " + e.getMessage());
        }
        return membresia;
    }

    public List<Membresia> obtenerMembresias() {
        List<Membresia> membresias = new ArrayList<>();
        String sql = "SELECT * FROM membresias";
        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Membresia membresia = new Membresia();
                membresia.setId_membresia(rs.getInt("ID_Membresia"));
                Socio socio = new Socio();
                socio.setId_Socio(rs.getInt("Id_Socio"));
                membresia.setSocio(socio);
                membresia.setCantidadPases(rs.getInt("CantidadPases"));
                membresia.setFechaInicio(rs.getDate("Fecha_inicio"));
                membresia.setFechaFin(rs.getDate("Fecha_fin"));
                membresia.setCosto(rs.getBigDecimal("Costo"));
                membresia.setEstado(rs.getBoolean("Estado"));
                membresias.add(membresia);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las membresías: " + e.getMessage());
        }
        return membresias;
    }

    public void actualizarMembresia(Membresia membresia) {
        String sql = "UPDATE membresias SET Fecha_fin = ? WHERE ID_Membresia = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(membresia.getFechaFin().getTime()));
            ps.setInt(2, membresia.getId_membresia());
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Membresía actualizada exitosamente.");
            } else {
                System.out.println("No se pudo actualizar la membresía.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la membresía: " + e.getMessage());
        }
    }
    public boolean tieneMembresiaActiva(int idSocio) {
        String sql = "SELECT * FROM membresia WHERE id_socio = ? AND estado = true AND fecha_fin >= CURDATE()";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSocio);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si hay al menos una membresía activa
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar membresía activa: " + e.getMessage());
            return false;
        }
    }
}
