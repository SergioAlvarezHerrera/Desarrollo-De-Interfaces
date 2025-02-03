package modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main extends JFrame {

    private EquipoDAO equipoDAO;
    private JugadorDAO jugadorDAO;

    private JTable tablaEquipos;
    private JTable tablaJugadores;

    private DefaultTableModel modeloEquipos;
    private DefaultTableModel modeloJugadores;

    private JPanel panelInformacion;
    private JLabel lblInformacion;

    public Main(Connection conexion) {
        equipoDAO = new EquipoDAO(conexion);
        jugadorDAO = new JugadorDAO(conexion);

        setTitle("Gestión de Equipos de Fútbol");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     
        JPanel panelTablas = new JPanel();
        panelTablas.setLayout(new BoxLayout(panelTablas, BoxLayout.Y_AXIS));
        
        
        JLabel labelEquipos = new JLabel("Tabla Equipo", JLabel.CENTER);
        labelEquipos.setFont(new Font("Arial", Font.BOLD, 16));
        labelEquipos.setForeground(Color.WHITE);
        labelEquipos.setBackground(new Color(0, 102, 204)); 
        labelEquipos.setOpaque(true);
        panelTablas.add(labelEquipos);

        modeloEquipos = new DefaultTableModel(new String[]{"ID", "Nombre", "Ciudad", "Estadio"}, 0);
        tablaEquipos = new JTable(modeloEquipos);
        panelTablas.add(new JScrollPane(tablaEquipos));

       
        JLabel labelJugadores = new JLabel("Tabla Jugadores", JLabel.CENTER);
        labelJugadores.setFont(new Font("Arial", Font.BOLD, 16));
        labelJugadores.setForeground(Color.WHITE);
        labelJugadores.setBackground(new Color(0, 102, 204)); 
        labelJugadores.setOpaque(true);
        panelTablas.add(labelJugadores);

        modeloJugadores = new DefaultTableModel(new String[]{"ID", "Nombre", "Posición", "Equipo ID"}, 0);
        tablaJugadores = new JTable(modeloJugadores);
        panelTablas.add(new JScrollPane(tablaJugadores));

        
        panelInformacion = new JPanel();
        panelInformacion.setLayout(new BorderLayout());
        panelInformacion.setBackground(new Color(173, 216, 230)); 
        panelInformacion.setPreferredSize(new Dimension(300, 600));

        lblInformacion = new JLabel("Seleccione un equipo o jugador para ver más información.");
        lblInformacion.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInformacion.setHorizontalAlignment(JLabel.CENTER);
        panelInformacion.add(lblInformacion, BorderLayout.CENTER);

      
        add(panelTablas, BorderLayout.CENTER);
        add(panelInformacion, BorderLayout.EAST);

    
        JPanel panelBotones = new JPanel(new GridLayout(2, 3)); 
        JButton btnAgregarEquipo = new JButton("Agregar Equipo");
        JButton btnEditarEquipo = new JButton("Editar Equipo");
        JButton btnEliminarEquipo = new JButton("Eliminar Equipo");
        JButton btnAñadirPDF = new JButton("Añadir PDF");
        JButton btnAgregarJugador = new JButton("Agregar Jugador");
        JButton btnEditarJugador = new JButton("Editar Jugador");
        JButton btnEliminarJugador = new JButton("Eliminar Jugador");
        JButton btnAñadirExcel = new JButton("Añadir Excel");

        panelBotones.add(btnAgregarEquipo);
        panelBotones.add(btnEditarEquipo);
        panelBotones.add(btnEliminarEquipo);
        panelBotones.add(btnAñadirPDF); 
        panelBotones.add(btnAgregarJugador);
        panelBotones.add(btnEditarJugador);
        panelBotones.add(btnEliminarJugador);  
        panelBotones.add(btnAñadirExcel); 
        add(panelBotones, BorderLayout.SOUTH);

        
        btnAgregarEquipo.addActionListener(e -> mostrarDialogoAgregarEquipo(conexion));
        btnEditarEquipo.addActionListener(e -> mostrarDialogoEditarEquipo(conexion));
        btnEliminarEquipo.addActionListener(e -> eliminarEquipo());
        btnAgregarJugador.addActionListener(e -> mostrarDialogoAgregarJugador(conexion));
        btnEditarJugador.addActionListener(e -> mostrarDialogoEditarJugador(conexion));
        btnEliminarJugador.addActionListener(e -> eliminarJugador());
       
        

       
        btnAñadirPDF.addActionListener(e -> {
            try {
                List<Equipo> equipos = equipoDAO.obtenerListaEquipos();
                for (Equipo equipo : equipos) {
                    equipo.setListaJugadores(jugadorDAO.obtenerListaJugadores(equipo.getId()));
                }
                generarPDF("equipos.pdf", equipos);
                JOptionPane.showMessageDialog(null, "PDF generado correctamente.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        btnAñadirExcel.addActionListener(e -> {
            List<Equipo> equipos = new ArrayList<>(); 

            try {
                equipos = equipoDAO.obtenerListaEquipos();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "Error al obtener la lista de equipos: " + e1.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
                return; 
            }

            if (equipos == null || equipos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay equipos disponibles para exportar.", 
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombreArchivo = "equipos_y_jugadores.xlsx";

            
            try {
                generarExcel(nombreArchivo, equipos);
                JOptionPane.showMessageDialog(null, "Excel generado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al generar el archivo Excel: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

       
        tablaEquipos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tablaEquipos.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int equipoId = (int) modeloEquipos.getValueAt(filaSeleccionada, 0);
                        cargarJugadoresPorEquipo(equipoId);
                        mostrarInformacionEquipo();
                    }
                }
            }
        });

        
        tablaJugadores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tablaJugadores.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int jugadorId = (int) modeloJugadores.getValueAt(filaSeleccionada, 0);
                        mostrarInformacionJugador();
                    }
                }
            }
        });

        cargarEquipos();
    }

    private void mostrarInformacionEquipo() {
        int filaSeleccionada = tablaEquipos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int equipoId = (int) modeloEquipos.getValueAt(filaSeleccionada, 0);
            String info = "<html><b>Equipo seleccionado:</b><br>" +
                          "Nombre: " + modeloEquipos.getValueAt(filaSeleccionada, 1) + "<br>" +
                          "Ciudad: " + modeloEquipos.getValueAt(filaSeleccionada, 2) + "<br>" +
                          "Estadio: " + modeloEquipos.getValueAt(filaSeleccionada, 3) + "</html>";
            lblInformacion.setText(info);
            lblInformacion.revalidate();
            lblInformacion.repaint();
            cargarJugadoresPorEquipo(equipoId);
        } else {
            lblInformacion.setText("No hay equipo seleccionado.");
        }
    }

    private void mostrarInformacionJugador() {
        int filaSeleccionada = tablaJugadores.getSelectedRow();
        if (filaSeleccionada != -1) {
            String info = "<html><b>Jugador seleccionado:</b><br>" +
                          "Nombre: " + modeloJugadores.getValueAt(filaSeleccionada, 1) + "<br>" +
                          "Posición: " + modeloJugadores.getValueAt(filaSeleccionada, 2) + "</html>";
            lblInformacion.setText(info);
            lblInformacion.revalidate();
            lblInformacion.repaint();
        } else {
            lblInformacion.setText("No hay jugador seleccionado.");
        }
    }


    
    
    private void mostrarDialogoAgregarEquipo(Connection conexion) {
        JDialog dialogo = new JDialog(this, "Agregar Equipo", true);
        dialogo.setLayout(new GridLayout(4, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtCiudad = new JTextField();
        JTextField txtEstadio = new JTextField();
        JButton btnGuardar = new JButton("Guardar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Ciudad:"));
        dialogo.add(txtCiudad);
        dialogo.add(new JLabel("Estadio:"));
        dialogo.add(txtEstadio);
        dialogo.add(new JLabel());
        dialogo.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                String ciudad = txtCiudad.getText();
                String estadio = txtEstadio.getText();

                int id = 0;
                String sql = "SELECT MAX(id)+1 AS newid FROM Equipos";

                try (Statement stmt = conexion.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        id = rs.getInt("newid");
                    }
                }

                Equipo equipo = new Equipo(id, nombre, ciudad, estadio);
                equipoDAO.agregarEquipo(equipo);

                cargarEquipos();
                JOptionPane.showMessageDialog(this, "Equipo agregado correctamente.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar equipo: " + ex.getMessage());
            }
        });

        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }
    private void mostrarDialogoEditarEquipo(Connection conexion) {
        int filaSeleccionada = tablaEquipos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo para editar.");
            return;
        }

        int equipoId = (int) modeloEquipos.getValueAt(filaSeleccionada, 0);
        String nombreActual = (String) modeloEquipos.getValueAt(filaSeleccionada, 1);
        String ciudadActual = (String) modeloEquipos.getValueAt(filaSeleccionada, 2);
        String estadioActual = (String) modeloEquipos.getValueAt(filaSeleccionada, 3);

        JDialog dialogo = new JDialog(this, "Editar Equipo", true);
        dialogo.setLayout(new GridLayout(4, 2));

        JTextField txtNombre = new JTextField(nombreActual);
        JTextField txtCiudad = new JTextField(ciudadActual);
        JTextField txtEstadio = new JTextField(estadioActual);
        JButton btnGuardar = new JButton("Guardar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Ciudad:"));
        dialogo.add(txtCiudad);
        dialogo.add(new JLabel("Estadio:"));
        dialogo.add(txtEstadio);
        dialogo.add(new JLabel());
        dialogo.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                String nuevoNombre = txtNombre.getText();
                String nuevaCiudad = txtCiudad.getText();
                String nuevoEstadio = txtEstadio.getText();

                Equipo equipo = new Equipo(equipoId, nuevoNombre, nuevaCiudad, nuevoEstadio);
                equipoDAO.actualizarEquipo(equipo);

                cargarEquipos();
                JOptionPane.showMessageDialog(this, "Equipo actualizado correctamente.");
                dialogo.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar equipo: " + ex.getMessage());
            }
        });

        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoEditarJugador(Connection conexion) {
        int filaSeleccionada = tablaJugadores.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un jugador para editar.");
            return;
        }

        int jugadorId = (int) modeloJugadores.getValueAt(filaSeleccionada, 0);
        String nombreActual = (String) modeloJugadores.getValueAt(filaSeleccionada, 1);
        String posicionActual = (String) modeloJugadores.getValueAt(filaSeleccionada, 2);
        int equipoIdActual = (int) modeloJugadores.getValueAt(filaSeleccionada, 3);

        JDialog dialogo = new JDialog(this, "Editar Jugador", true);
        dialogo.setLayout(new GridLayout(4, 2));

        JTextField txtNombre = new JTextField(nombreActual);
        JTextField txtPosicion = new JTextField(posicionActual);
        JTextField txtEquipoId = new JTextField(String.valueOf(equipoIdActual));
        JButton btnGuardar = new JButton("Guardar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Posición:"));
        dialogo.add(txtPosicion);
        dialogo.add(new JLabel("Equipo ID:"));
        dialogo.add(txtEquipoId);
        dialogo.add(new JLabel());
        dialogo.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                String nuevoNombre = txtNombre.getText();
                String nuevaPosicion = txtPosicion.getText();
                int nuevoEquipoId = Integer.parseInt(txtEquipoId.getText());

                Jugador jugador = new Jugador(jugadorId, nuevoNombre, nuevaPosicion, nuevoEquipoId);
                jugadorDAO.actualizarJugador(jugador);

                cargarJugadoresPorEquipo(nuevoEquipoId);
                JOptionPane.showMessageDialog(this, "Jugador actualizado correctamente.");
                dialogo.dispose();
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar jugador: " + ex.getMessage());
            }
        });

        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarDialogoAgregarJugador(Connection conexion) {
        JDialog dialogo = new JDialog(this, "Agregar Jugador", true);
        dialogo.setLayout(new GridLayout(4, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtPosicion = new JTextField();
        JTextField txtEquipoId = new JTextField();
        JButton btnGuardar = new JButton("Guardar");

        dialogo.add(new JLabel("Nombre:"));
        dialogo.add(txtNombre);
        dialogo.add(new JLabel("Posición:"));
        dialogo.add(txtPosicion);
        dialogo.add(new JLabel("Equipo ID:"));
        dialogo.add(txtEquipoId);
        dialogo.add(new JLabel());
        dialogo.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                String posicion = txtPosicion.getText();
                int equipoId = Integer.parseInt(txtEquipoId.getText());
                int id = 0;
                
                String sql = "SELECT MAX(id)+1 AS newid FROM Jugadores";

                try (Statement stmt = conexion.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        id = rs.getInt("newid");
                    }
                }

                Jugador jugador = new Jugador(id, nombre, posicion, equipoId);
                jugadorDAO.agregarJugador(jugador);
                cargarJugadoresPorEquipo(equipoId);
                JOptionPane.showMessageDialog(this, "Jugador agregado correctamente.");
                dialogo.dispose();
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar jugador: " + ex.getMessage());
            }
        });

        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void eliminarEquipo() {
        try {
            int selectedRow = tablaEquipos.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) modeloEquipos.getValueAt(selectedRow, 0);
                equipoDAO.eliminarEquipo(id);
                cargarEquipos();
                modeloJugadores.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Equipo eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un equipo para eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar equipo: " + ex.getMessage());
        }
    }

    private void eliminarJugador() {
        try {
            int selectedRow = tablaJugadores.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) modeloJugadores.getValueAt(selectedRow, 0);
                jugadorDAO.eliminarJugador(id);

                int filaSeleccionada = tablaEquipos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int equipoId = (int) modeloEquipos.getValueAt(filaSeleccionada, 0);
                    cargarJugadoresPorEquipo(equipoId);
                }

                JOptionPane.showMessageDialog(this, "Jugador eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un jugador para eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar jugador: " + ex.getMessage());
        }
    }

    private void cargarEquipos() {
        try {
            modeloEquipos.setRowCount(0);
            List<Equipo> equipos = equipoDAO.obtenerListaEquipos();
            for (Equipo equipo : equipos) {
                modeloEquipos.addRow(new Object[]{equipo.getId(), equipo.getNombre(), equipo.getCiudad(), equipo.getEstadio()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar equipos: " + ex.getMessage());
        }
    }

    private void cargarJugadoresPorEquipo(int equipoId) {
        try {
            modeloJugadores.setRowCount(0);
            List<Jugador> jugadores = jugadorDAO.obtenerListaJugadores(equipoId);
            for (Jugador jugador : jugadores) {
                modeloJugadores.addRow(new Object[]{jugador.getId(), jugador.getNombre(), jugador.getPosicion(), jugador.getEquipoId()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar jugadores: " + ex.getMessage());
        }
    }
    
    public static void generarPDF(String nombreArchivo, List<Equipo> equipos) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            document.add(new Paragraph("Lista de Equipos y Jugadores", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));

            for (Equipo equipo : equipos) {
                document.add(new Paragraph("Equipo: " + equipo.getNombre(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
                
                List<Jugador> jugadores = equipo.getListaJugadores(); 
                if (jugadores == null || jugadores.isEmpty()) {
                    document.add(new Paragraph("   No hay jugadores en este equipo."));
                } else {
                    PdfPTable tabla = new PdfPTable(2);
                    tabla.addCell("Jugador");
                    tabla.addCell("Posición");

                    for (Jugador jugador : jugadores) {
                        tabla.addCell(jugador.getNombre());
                        tabla.addCell(jugador.getPosicion());
                    }
                    document.add(tabla);
                }
                document.add(new Paragraph(" "));
            }

            document.close();
            System.out.println("PDF generado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarExcel(String nombreArchivo, List<Equipo> equipos) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Equipos y Jugadores");

        int rowNum = 0;

       
        Row tituloRow = sheet.createRow(rowNum++);
        Cell tituloCell = tituloRow.createCell(0);
        tituloCell.setCellValue("Lista de Equipos y Jugadores");

        
        CellStyle estiloTitulo = workbook.createCellStyle();
        XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        estiloTitulo.setFont(font);
        tituloCell.setCellStyle(estiloTitulo);

        rowNum++; 

        for (Equipo equipo : equipos) {
          
            Row rowEquipo = sheet.createRow(rowNum++);
            rowEquipo.createCell(0).setCellValue("Equipo: " + equipo.getNombre());

           
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Jugador");
            headerRow.createCell(1).setCellValue("Posición");

            List<Jugador> jugadores = equipo.getListaJugadores();
            if (jugadores != null && !jugadores.isEmpty()) {
                for (Jugador jugador : jugadores) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(jugador.getNombre());
                    row.createCell(1).setCellValue(jugador.getPosicion());
                }
            } else {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue("No hay jugadores en este equipo.");
            }

            rowNum++; 
        }

        
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            workbook.write(fileOut);
            System.out.println("Excel generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el archivo Excel: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    private static boolean realizarLogin() {
        
        JTextField usuarioField = new JTextField(15);
        JPasswordField contraseñaField = new JPasswordField(15);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Usuario:"));
        panel.add(usuarioField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(contraseñaField);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            String usuario = usuarioField.getText();
            char[] contraseña = contraseñaField.getPassword();

          
            return validarCredenciales(usuario, new String(contraseña));
        } else {
            return false; 
        }
    }

   
    private static boolean validarCredenciales(String usuario, String contraseña) {
        
        String usuarioCorrecto = "admin";
        String contraseñaCorrecta = "1234";

        return usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta);
    }
            
        
    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setVisible(true);

        new Thread(() -> {
            try {
                
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50);
                    splashScreen.updateProgress(i);
                }

                splashScreen.dispose();
                
                
                if (realizarLogin()) {
                   
                    Connection conexion = ConexionBBDD.getConnection();

                    SwingUtilities.invokeLater(() -> {
                        new Main(conexion).setVisible(true); 
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Login fallido. La aplicación se cerrará.");
                    System.exit(0); 
                }

            } catch (SQLException | InterruptedException ex) {
                splashScreen.dispose();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }).start();
    }
}
    
    	
    