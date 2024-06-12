package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import org.mariadb.jdbc.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MembresiaData {
    private Connection con = null;

    public MembresiaData() {
        con = Conexion.getConexion();
    }

    public void registrarMembresia(Socio socio, int cantidadPases, int duracionMeses) {
        String sql = "INSERT INTO membresias (Id_Socio, CantidadPases, Fecha_inicio, Fecha_fin, Costo, Estado) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, socio.getId_Socio(1));
            ps.setInt(2, cantidadPases);

            LocalDate fechaInicio = LocalDate.now();
            ps.setDate(3, java.sql.Date.valueOf(fechaInicio));

            LocalDate fechaFin = fechaInicio.plusMonths(duracionMeses);
            ps.setDate(4, java.sql.Date.valueOf(fechaFin));

            BigDecimal costo = calcularCosto(cantidadPases, duracionMeses);
            ps.setBigDecimal(5, costo);
            ps.setBoolean(6, true);

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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Membresias");
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
                membresia.setFechaFin(java.sql.Date.valueOf(nuevaFechaFin));
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

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, membresia.getId_membresia());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                membresia.setEstado(false);
                System.out.println("Membresía cancelada.");
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
}
