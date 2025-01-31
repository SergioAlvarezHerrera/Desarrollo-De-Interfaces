package panels;

import cineapp.Pelicula;
import cineapp.PeliculaManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ListadoPanel extends JPanel {
    private JLabel imageLabel, titleLabel, typeLabel, resumenLabel;
    private JButton prevButton, nextButton, editButton, deleteButton;
    private JButton generatePdfButton, generateExcelButton;
    private int currentIndex;
    private PeliculaManager manager;

    public ListadoPanel(PeliculaManager manager) {
        this.manager = manager;
        setupUI();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // Panel para mostrar la información de la película
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(245, 245, 245));

        imageLabel = new JLabel();
        titleLabel = new JLabel("Título: ");
        typeLabel = new JLabel("Tipo: ");
        resumenLabel = new JLabel("Resumen: ");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resumenLabel.setFont(new Font("Arial", Font.ITALIC, 12));

        contentPanel.add(imageLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(titleLabel);
        contentPanel.add(typeLabel);
        contentPanel.add(resumenLabel);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        prevButton = new JButton("Anterior");
        nextButton = new JButton("Siguiente");
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");
        generatePdfButton = new JButton("Generar PDF");
        generateExcelButton = new JButton("Generar Excel");

        styleButton(prevButton);
        styleButton(nextButton);
        styleButton(editButton);
        styleButton(deleteButton);
        styleButton(generatePdfButton);
        styleButton(generateExcelButton);

        prevButton.addActionListener(e -> showPrevious());
        nextButton.addActionListener(e -> showNext());
        editButton.addActionListener(e -> editMovie());
        deleteButton.addActionListener(e -> deleteMovie());
        generatePdfButton.addActionListener(e -> generatePdf());
        generateExcelButton.addActionListener(e -> generateExcel());

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(generatePdfButton);
        buttonPanel.add(generateExcelButton);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        updateView();
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(140, 40));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void updateView() {
        if (manager.getPeliculas().isEmpty()) {
            titleLabel.setText("No hay películas disponibles.");
            imageLabel.setIcon(null);
            typeLabel.setText("");
            resumenLabel.setText("");
        } else {
            Pelicula pelicula = manager.getPeliculas().get(currentIndex);
            titleLabel.setText("Título: " + pelicula.getTitulo());
            typeLabel.setText("Tipo: " + pelicula.getTipo());
            resumenLabel.setText("<html>Resumen: " + pelicula.getResumen() + "</html>");

            String imagePath = pelicula.getImagePath();
            if (imagePath != null && !imagePath.isEmpty()) {
                ImageIcon icon = new ImageIcon(imagePath);
                Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setIcon(null);
            }
        }
    }

    private void showPrevious() {
        if (!manager.getPeliculas().isEmpty()) {
            currentIndex = (currentIndex - 1 + manager.getPeliculas().size()) % manager.getPeliculas().size();
            updateView();
        }
    }

    private void showNext() {
        if (!manager.getPeliculas().isEmpty()) {
            currentIndex = (currentIndex + 1) % manager.getPeliculas().size();
            updateView();
        }
    }

    private void editMovie() {
        if (manager.getPeliculas().isEmpty()) return;

        Pelicula pelicula = manager.getPeliculas().get(currentIndex);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField tituloField = new JTextField(pelicula.getTitulo());
        JComboBox<String> tipoCombo = new JComboBox<>(new String[]{"Acción", "Comedia", "Terror", "Drama"});
        tipoCombo.setSelectedItem(pelicula.getTipo());
        JTextArea resumenArea = new JTextArea(pelicula.getResumen());
        resumenArea.setLineWrap(true);
        resumenArea.setWrapStyleWord(true);
        JScrollPane resumenScroll = new JScrollPane(resumenArea);

        formPanel.add(new JLabel("Título:"));
        formPanel.add(tituloField);
        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(tipoCombo);
        formPanel.add(new JLabel("Resumen:"));
        formPanel.add(resumenScroll);

        int result = JOptionPane.showConfirmDialog(this, formPanel, "Editar Película", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            pelicula.setTitulo(tituloField.getText());
            pelicula.setTipo((String) tipoCombo.getSelectedItem());
            pelicula.setResumen(resumenArea.getText());
            updateView();
        }
    }

    private void deleteMovie() {
        if (manager.getPeliculas().isEmpty()) return;

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta película?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            manager.getPeliculas().remove(currentIndex);
            if (currentIndex >= manager.getPeliculas().size()) {
                currentIndex = manager.getPeliculas().size() - 1;
            }
            updateView();
        }
    }

    private void generatePdf() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar PDF");
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                
                // Asegurarse de que el archivo tenga la extensión .pdf
                if (!file.getName().toLowerCase().endsWith(".pdf")) {
                    file = new File(file.getAbsolutePath() + ".pdf");
                }

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                // Título del PDF
                Font titleFont = new Font(Font.DIALOG, 18, Font.BOLD);
                Paragraph title = new Paragraph("Listado de Películas");
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                document.add(new Paragraph(" ")); // Espacio

                // Tabla con las películas
                PdfPTable table = new PdfPTable(3); // 3 columnas
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                // Cabecera de la tabla
                table.addCell(new PdfPCell(new Phrase("Título")));
                table.addCell(new PdfPCell(new Phrase("Tipo")));
                table.addCell(new PdfPCell(new Phrase("Resumen")));

                // Agregar datos de las películas
                for (Pelicula pelicula : manager.getPeliculas()) {
                    table.addCell(pelicula.getTitulo());
                    table.addCell(pelicula.getTipo());
                    table.addCell(pelicula.getResumen());
                }

                document.add(table);
                document.close();

                JOptionPane.showMessageDialog(this, "PDF generado correctamente en: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage());
        }
    }


    private void generateExcel() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar Excel");
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Películas");

                Row headerRow = sheet.createRow(0);
                String[] headers = {"Título", "Tipo", "Resumen"};
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }

                List<Pelicula> peliculas = manager.getPeliculas();
                for (int i = 0; i < peliculas.size(); i++) {
                    Row row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue(peliculas.get(i).getTitulo());
                    row.createCell(1).setCellValue(peliculas.get(i).getTipo());
                    row.createCell(2).setCellValue(peliculas.get(i).getResumen());
                }

                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                workbook.close();

                JOptionPane.showMessageDialog(this, "Excel generado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

