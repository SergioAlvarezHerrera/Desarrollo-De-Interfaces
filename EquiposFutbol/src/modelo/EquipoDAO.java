package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
	
	private Connection conexion;
	
	public EquipoDAO(Connection conexion) {
        this.conexion = conexion;
    }
   
    public void agregarEquipo(Equipo equipo) throws SQLException {
        String sql = "INSERT INTO Equipos (id, nombre, ciudad, estadio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, equipo.getId());
            stmt.setString(2, equipo.getNombre());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.executeUpdate();
        }
    }
    
     public List<Equipo> obtenerListaEquipos() throws SQLException {
        String sql = "SELECT * FROM Equipos";
        List<Equipo> equipos = new ArrayList<>();
        try (Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
               while (rs.next()) {
                   equipos.add(new Equipo(
                       rs.getInt("id"),
                       rs.getString("nombre"),
                       rs.getString("ciudad"),
                       rs.getString("estadio")
                   ));
               }
              
            }
        
        return equipos;
    }
     
     public void actualizarEquipo(Equipo equipo) throws SQLException {
         String sql = "UPDATE Equipos SET nombre = ?, ciudad = ?, estadio = ? WHERE id = ?";
         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
             stmt.setString(1, equipo.getNombre());
             stmt.setString(2, equipo.getCiudad());
             stmt.setString(3, equipo.getEstadio());
             stmt.setInt(4, equipo.getId());
             stmt.executeUpdate();
         }
     }
     
     public void eliminarEquipo(int id) throws SQLException {
    	    String sqlEliminarJugadores = "DELETE FROM Jugadores WHERE equipo_id = ?"; // Aquí corregido
    	    String sqlEliminarEquipo = "DELETE FROM Equipos WHERE id = ?";

    	    try (PreparedStatement stmtJugadores = conexion.prepareStatement(sqlEliminarJugadores);
    	         PreparedStatement stmtEquipo = conexion.prepareStatement(sqlEliminarEquipo)) {

    	        // Primero eliminar los jugadores asociados al equipo
    	        stmtJugadores.setInt(1, id);
    	        stmtJugadores.executeUpdate();

    	        // Luego eliminar el equipo
    	        stmtEquipo.setInt(1, id);
    	        stmtEquipo.executeUpdate();
    	    }
    	}



	public Connection getConexion() {
		// TODO Auto-generated method stub
		return null;
	}
}
