package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
	
	private Connection conexion;
	
	public JugadorDAO(Connection conexion) {
        this.conexion = conexion;
    }
	
	public void agregarJugador(Jugador jugador) throws SQLException{
			String sql = "INSERT INTO Jugadores (id, nombre, posicion ,equipo_id) VALUES (? ,?,?,?)";
			
		try (PreparedStatement stmt = conexion.prepareStatement(sql)){
			stmt.setInt(1, jugador.getId());
	        stmt.setString(2, jugador.getNombre());
	        stmt.setString(3, jugador.getPosicion());
	        stmt.setInt(4, jugador.getEquipoId());
	        stmt.executeUpdate();
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public List<Jugador> obtenerListaJugadores(int equipoId) throws SQLException {
	    List<Jugador> jugadores = new ArrayList<>();
	    String sql = "SELECT * FROM Jugadores WHERE equipo_id = ?";
	    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	        stmt.setInt(1, equipoId); 
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            jugadores.add(new Jugador(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getString("posicion"),
	                rs.getInt("equipo_id")
	            ));
	        }
	    }
	    return jugadores;
	}

	
	public void actualizarJugador(Jugador jugador) throws SQLException {
        String sql = "UPDATE Jugadores SET nombre = ?, posicion = ?, equipo_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getPosicion());
            stmt.setInt(3, jugador.getEquipoId());
            stmt.setInt(4, jugador.getId());
            stmt.executeUpdate();
        }
    }
	
	public void eliminarJugador(int id) throws SQLException {
        String sql = "DELETE FROM Jugadores WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

