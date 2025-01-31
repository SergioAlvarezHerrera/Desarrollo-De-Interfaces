package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	
	public static final String conexion = "jdbc:sqlserver://localhost:1433;"
			+ "database=tempdb;"
			+ "encrypt=false;"
			+ "user=sa;"
			+ "password=1234";
	
	public static Connection getConnection() throws SQLException{
		try {
			return DriverManager.getConnection(conexion);
		} catch (SQLException ex) {
			System.out.println(ex.toString());
			return null;
			// TODO: handle exception
		}
	}
    
	
	
    
}