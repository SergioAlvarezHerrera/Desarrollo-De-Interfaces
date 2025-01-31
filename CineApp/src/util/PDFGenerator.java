package util;

import cineapp.PeliculaManager;
import cineapp.Pelicula;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFGenerator {

    public static void generarPDF(PeliculaManager manager, String archivoDestino) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(archivoDestino));
            document.open();

            
            document.add(new Paragraph("Listado de Películas", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            document.add(Chunk.NEWLINE);

            
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.addCell("Título");
            table.addCell("Tipo");
            table.addCell("Resumen");
            table.addCell("Imagen");

            List<Pelicula> peliculas = manager.getPeliculas();
            for (Pelicula pelicula : peliculas) {
                table.addCell(pelicula.getTitulo());
                table.addCell(pelicula.getTipo());
                table.addCell(pelicula.getResumen());
                table.addCell(pelicula.getImagePath() != null ? pelicula.getImagePath() : "Sin Imagen");
            }

            document.add(table);
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
