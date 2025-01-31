package panels;

import cineapp.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPanel extends JPanel {
    private JTextField tituloField;
    private JComboBox<String> tipoCombo;
    private JTextArea resumenArea;
    private JLabel imagenPreviewLabel;
    private JButton seleccionarImagenButton, guardarButton, cancelarButton;
    private String imagenPath = null;
    private PeliculaManager manager;

    public FormularioPanel(PeliculaManager manager) {
        this.manager = manager;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(250, 250, 250));
        formPanel.setBorder(BorderFactory.createTitledBorder("Añadir Nueva Película"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        tituloField = new JTextField(20);
        tipoCombo = new JComboBox<>(new String[]{"Acción", "Comedia", "Terror", "Drama"});
        resumenArea = new JTextArea(5, 20);
        resumenArea.setLineWrap(true);
        resumenArea.setWrapStyleWord(true);
        JScrollPane resumenScroll = new JScrollPane(resumenArea);

        imagenPreviewLabel = new JLabel();
        imagenPreviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagenPreviewLabel.setPreferredSize(new Dimension(200, 200));
        imagenPreviewLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        seleccionarImagenButton = new JButton("Seleccionar Imagen");
        seleccionarImagenButton.setBackground(new Color(100, 149, 237));
        seleccionarImagenButton.setForeground(Color.BLACK);
        seleccionarImagenButton.setFocusPainted(false);

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        styleButton(guardarButton, new Color(34, 139, 34)); 
        styleButton(cancelarButton, new Color(178, 34, 34)); 

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Título:"), gbc);

        gbc.gridx = 1;
        formPanel.add(tituloField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Tipo:"), gbc);

        gbc.gridx = 1;
        formPanel.add(tipoCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Resumen:"), gbc);

        gbc.gridx = 1;
        formPanel.add(resumenScroll, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Imagen:"), gbc);

        gbc.gridx = 1;
        formPanel.add(imagenPreviewLabel, gbc);

        gbc.gridy = 4;
        formPanel.add(seleccionarImagenButton, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(guardarButton);
        buttonPanel.add(cancelarButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

       
        seleccionarImagenButton.addActionListener(e -> seleccionarImagen());

        
        guardarButton.addActionListener(e -> guardarPelicula());

       
        cancelarButton.addActionListener(e -> cancelar());
    }

    private void styleButton(JButton button, Color color) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
    }

    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            imagenPath = fileChooser.getSelectedFile().getAbsolutePath();
            ImageIcon icon = new ImageIcon(imagenPath);
            Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imagenPreviewLabel.setIcon(new ImageIcon(scaledImage));
        }
    }

    private void guardarPelicula() {
        String titulo = tituloField.getText();
        String tipo = (String) tipoCombo.getSelectedItem();
        String resumen = resumenArea.getText();

        if (titulo.isEmpty() || tipo == null || resumen.isEmpty() || imagenPath == null) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pelicula nuevaPelicula = new Pelicula(titulo, tipo, resumen, imagenPath);
        manager.addPelicula(nuevaPelicula);

   
        SwingUtilities.getWindowAncestor(this).repaint();

        JOptionPane.showMessageDialog(this, "Película añadida exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelar() {
        JOptionPane.showMessageDialog(this, "Operación cancelada.", "Cancelado", JOptionPane.WARNING_MESSAGE);
    }
}

