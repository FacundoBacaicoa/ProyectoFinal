package gestiongimnasio.DAO;

import gestiongimnasio.Entidades.Membresia;
import gestiongimnasio.Entidades.Socio;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class MembresiaData {

    private Connection con = null;
        private SocioDAO socioData;

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

public void renovarMembresia(Membresia membresia, int cantidadPases) {
    String sql = "UPDATE membresias SET Fecha_inicio = ?, Fecha_fin = ?, CantidadPases = ?, Costo = ?, Estado = ? WHERE Id_Membresia = ?";

    try (Connection conn = Conexion.getConexion(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setDate(1, new java.sql.Date(membresia.getFechaInicio().getTime()));
        ps.setDate(2, new java.sql.Date(membresia.getFechaFin().getTime()));
        ps.setInt(3, cantidadPases);
        ps.setBigDecimal(4, membresia.getCosto());
        ps.setBoolean(5, true);
        ps.setInt(6, membresia.getId_membresia());

        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Membresía renovada y activada correctamente.");
        } else {
            System.out.println("No se pudo renovar la membresía.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al renovar la membresía: " + e.getMessage());
    }
}

    public void cancelarMembresia(Membresia membresia) {
        String sql = "UPDATE membresias SET Estado = false WHERE Id_Membresia = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
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

    public void actualizarMembresia(Membresia membresia) throws SQLException {
        String sql = "UPDATE membresias SET CantidadPases = ?, fecha_inicio = ?, fecha_fin = ?, costo = ?, estado = ? WHERE id_membresia = ?";

        try (Connection conn = Conexion.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, membresia.getCantidadPases());
            ps.setDate(2, new java.sql.Date(membresia.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(membresia.getFechaFin().getTime()));
            ps.setBigDecimal(4, membresia.getCosto());
            ps.setBoolean(5, membresia.isEstado());
            ps.setInt(6, membresia.getId_membresia());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas == 0) {
                throw new SQLException("No se pudo actualizar la membresía, no se encontró la ID.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la membresía: " + e.getMessage());
        }
    }

    public boolean tieneMembresiaActiva(int socioId) {
        String sql = "SELECT 1 FROM membresias WHERE Id_Socio = ? AND Estado = true";
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
    public Membresia obtenerMembresiaActivaPorNombre(String nombreCompleto) {
    Membresia membresia = null;
    String sql = "SELECT m.* FROM membresias m JOIN socios s ON m.Id_Socio = s.ID_Socio WHERE CONCAT(s.Nombre, ' ', s.Apellido) = ? AND m.Estado = true";
    try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setString(1, nombreCompleto);
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
        JOptionPane.showMessageDialog(null, "Error al obtener la membresía activa: " + e.getMessage());
    }
    return membresia;
}
public List<Object[]> buscarMembresiasPorNombre(String texto) {
    List<Object[]> resultados = new ArrayList<>();
    String sql = "SELECT m.*, s.Nombre, s.Apellido " +
                "FROM membresias m " +
                "JOIN socios s ON m.Id_Socio = s.ID_Socio " +
                "WHERE LOWER(CONCAT(s.Nombre, ' ', s.Apellido)) LIKE ?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + texto.toLowerCase() + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nombreCompleto = rs.getString("Nombre") + " " + rs.getString("Apellido");
                Object[] fila = {
                    rs.getInt("ID_Membresia"),
                    nombreCompleto,
                    rs.getInt("CantidadPases"),
                    rs.getDate("Fecha_inicio"),
                    rs.getDate("Fecha_fin"),
                    rs.getBigDecimal("Costo"),
                    rs.getBoolean("Estado") ? "Activo" : "Inactivo"
                };
                resultados.add(fila);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al buscar membresías por nombre: " + e.getMessage());
    }
    return resultados;
}

public List<Object[]> obtenerTodasLasMembresiasConNombres() {
    List<Object[]> resultados = new ArrayList<>();
    String sql = "SELECT m.*, s.Nombre, s.Apellido " +
                "FROM membresias m " +
                "JOIN socios s ON m.Id_Socio = s.ID_Socio " +
                "ORDER BY s.Nombre, s.Apellido";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nombreCompleto = rs.getString("Nombre") + " " + rs.getString("Apellido");
                Object[] fila = {
                    rs.getInt("ID_Membresia"),
                    nombreCompleto,
                    rs.getInt("CantidadPases"),
                    rs.getDate("Fecha_inicio"),
                    rs.getDate("Fecha_fin"),
                    rs.getBigDecimal("Costo"),
                    rs.getBoolean("Estado") ? "Activo" : "Inactivo"
                };
                resultados.add(fila);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener todas las membresías: " + e.getMessage());
    }
    return resultados;
}

public boolean descontarPase(int dniSocio) {
    int idSocio = obtenerIdSocioPorDni(dniSocio);
    if (idSocio == -1) {
        JOptionPane.showMessageDialog(null, "No se encontró un socio con el DNI: " + dniSocio);
        return false;
    }
    
    String sql = "UPDATE membresias SET CantidadPases = CantidadPases - 1 " +
                 "WHERE Id_Socio = ? AND Estado = true AND CantidadPases > 0";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            System.out.println("Pase descontado exitosamente para el socio con DNI: " + dniSocio);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se pudo descontar el pase. El socio no tiene membresía activa o no tiene pases disponibles.");
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al descontar pase: " + e.getMessage());
        return false;
    }
}

public boolean devolverPase(int dniSocio) {
    int idSocio = obtenerIdSocioPorDni(dniSocio);
    if (idSocio == -1) {
        JOptionPane.showMessageDialog(null, "No se encontró un socio con el DNI: " + dniSocio);
        return false;
    }
    
    String sql = "UPDATE membresias SET CantidadPases = CantidadPases + 1 " +
                 "WHERE Id_Socio = ? AND Estado = true";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            System.out.println("Pase devuelto exitosamente para el socio con DNI: " + dniSocio);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se pudo devolver el pase. El socio no tiene membresía activa.");
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al devolver pase: " + e.getMessage());
        return false;
    }
}
public int obtenerIdSocioPorDni(int dni) {
    String sql = "SELECT ID_Socio FROM socios WHERE DNI = ?";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, dni);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("ID_Socio");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener ID del socio por DNI: " + e.getMessage());
    }
    return -1;
}

public int obtenerPasesDisponibles(int dniSocio) {
    int idSocio = obtenerIdSocioPorDni(dniSocio);
    if (idSocio == -1) {
        return -1;
    }
    
    String sql = "SELECT CantidadPases FROM membresias WHERE Id_Socio = ? AND Estado = true";
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("CantidadPases");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener pases disponibles: " + e.getMessage());
    }
    return -1;
}

public Membresia obtenerUltimaMembresiaDeSocio(int idSocio) {
    Membresia membresia = null;
    String sql = "SELECT * FROM membresias WHERE ID_Socio = ? ORDER BY Fecha_Fin DESC LIMIT 1";
    try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idSocio);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            membresia = new Membresia();
            membresia.setId_membresia(rs.getInt("ID_Membresia"));
            membresia.setCantidadPases(rs.getInt("Cantidad_Pases"));
            membresia.setFechaInicio(rs.getDate("Fecha_Inicio"));
            membresia.setFechaFin(rs.getDate("Fecha_Fin"));
            membresia.setCosto(rs.getBigDecimal("Costo"));
            membresia.setEstado(rs.getBoolean("Estado"));

            Socio socio = socioData.obtenerSocioPorId(idSocio);
            membresia.setSocio(socio);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la última membresía: " + e.getMessage());
    }
    return membresia;
}

public boolean eliminarMembresia(int idMembresia) {
    String sql = "DELETE FROM membresias WHERE Id_Membresia = ?";
    try (Connection conn = Conexion.getConexion(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, idMembresia);
        int filasEliminadas = ps.executeUpdate();
        
        if (filasEliminadas > 0) {
            System.out.println("Membresía eliminada exitosamente. ID: " + idMembresia);
            return true;
        } else {
            System.out.println("No se pudo eliminar la membresía. ID no encontrado: " + idMembresia);
            return false;
        }
    } catch (SQLException e) {
        System.err.println("Error al eliminar la membresía: " + e.getMessage());
        return false;
    }
}

}
