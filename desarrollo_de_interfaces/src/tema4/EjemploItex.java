package tema4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

public class EjemploItex extends JFrame {
    private JTable tabla;
    private JButton btnGenerarPDF;
    private String[][] datos = {
        {"Juan", "Matemáticas", "85"},
        {"María", "Historia", "90"},
        {"Luis", "Ciencias", "78"},
        {"Ana", "Inglés", "92"}
    };
    private String[] columnas = {"Nombre", "Materia", "Nota Final"};

    public EjemploItex() {
        setTitle("Informe de Notas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        
        btnGenerarPDF = new JButton("Generar informe");
        btnGenerarPDF.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent e) {
            	try {
            	Document document = new Document();
                File directorio = new File("Reports");
                directorio.mkdir();
                PdfWriter.getInstance(document, new FileOutputStream("Reports/Informe.pdf"));

                
                document.open();

                
                PdfPTable table = new PdfPTable(columnas.length);
                
                for (String columna : columnas) {
                    table.addCell(columna);
                }
                
                for (String[] fila : datos) {
                    for (String dato : fila) {
                        table.addCell(dato);
                    }
                }
                
                document.add(table);

                document.close();
                
                

                
                document.close();

                System.out.println("¡Informe generado con éxito!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        
            }});
        

        
        add(scrollPane, BorderLayout.CENTER);
        add(btnGenerarPDF, BorderLayout.SOUTH);
    }

    
    public static void main(String[] args) {
      
            EjemploItex ventana = new EjemploItex();
            ventana.setVisible(true);
       
    }
}
