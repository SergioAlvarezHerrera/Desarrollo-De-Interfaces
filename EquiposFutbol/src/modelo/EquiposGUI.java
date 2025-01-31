package modelo;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EquiposGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Equipos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Ciudad");
        tableModel.addColumn("Estadio");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        
        try (Connection conn = ConexionBBDD.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Equipos");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String estadio = rs.getString("estadio");

                tableModel.addRow(new Object[]{id, nombre, ciudad ,estadio});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }

        frame.setVisible(true);
    }
}
