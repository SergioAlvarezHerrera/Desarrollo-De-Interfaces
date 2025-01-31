package modelo;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JugadoresGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("posicion");
        tableModel.addColumn("Id Equipo");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        
        try (Connection conn = ConexionBBDD.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Jugadores");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String posicion = rs.getString("posicion");
                int idEquipo = rs.getInt("equipo_id");

                tableModel.addRow(new Object[]{id, nombre, posicion ,idEquipo});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        frame.setVisible(true);
    }
}
