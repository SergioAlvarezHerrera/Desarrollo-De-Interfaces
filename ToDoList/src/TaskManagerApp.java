import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerApp {
    private DefaultListModel<Tarea> modeloTareas;
    private JList<Tarea> listaTareas;
    private JTextField nombreTareaField;
    private JComboBox<String> prioridadComboBox;

    public TaskManagerApp() {
        modeloTareas = new DefaultListModel<>();
        listaTareas = new JList<>(modeloTareas);
        listaTareas.setCellRenderer(new TaskCellRenderer());

        nombreTareaField = new JTextField(20);
        prioridadComboBox = new JComboBox<>(new String[]{"alta", "media", "baja"});
        JButton agregarButton = new JButton("Agregar Tarea");
        JButton eliminarButton = new JButton("Eliminar Tarea");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTareaField.getText();
                String prioridad = (String) prioridadComboBox.getSelectedItem();
                if (!nombre.isEmpty() && prioridad != null) {
                    modeloTareas.addElement(new Tarea(nombre, prioridad));
                    nombreTareaField.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaTareas.getSelectedIndex();
                if (selectedIndex != -1) {
                    modeloTareas.remove(selectedIndex);
                }
            }
        });

        listaTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = listaTareas.locationToIndex(evt.getPoint());
                if (index >= 0) {
                    Tarea tarea = modeloTareas.getElementAt(index);
                    tarea.toggleEstado();
                    listaTareas.repaint();
                }
            }
        });
        
        
        JFrame frame = new JFrame("Administrador de Tareas Diarias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        
        
        String[] looks = {
                "Metal",
                "Nimbus",
                "Windows",
                "Windows Classic",
                "Motif"
            };

            JComboBox<String> comboBox = new JComboBox<>(looks);
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedLook = (String) comboBox.getSelectedItem();
                    try {
                        switch (selectedLook) {
                            case "Metal":
                                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                                JOptionPane.showConfirmDialog(null, "Metal ");
                                break;
                            case "Nimbus":
                                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                                JOptionPane.showConfirmDialog(null, "nimbus");
                                break;
                            case "Windows":
                                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                                JOptionPane.showConfirmDialog(null, "Whindows ");
                                break;
                            case "Windows Classic":
                                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                                JOptionPane.showConfirmDialog(null, "Windows Classic ");
                                break;
                            case "Motif":
                                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                                JOptionPane.showConfirmDialog(null, "Motif ");
                                break;
                            default:
                            	UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                            	break;
                        }
                        // Actualizar la UI con el nuevo Look & Feel
                        SwingUtilities.updateComponentTreeUI(frame);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        
        

        

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nombre de la Tarea:"));
        panel.add(nombreTareaField);
        panel.add(new JLabel("Prioridad:"));
        panel.add(prioridadComboBox);
        panel.add(agregarButton);
        panel.add(eliminarButton);
        
        panel.add(comboBox);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(listaTareas), BorderLayout.CENTER);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManagerApp();
            }
        });
    }
}