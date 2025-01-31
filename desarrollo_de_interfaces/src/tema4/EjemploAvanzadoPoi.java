package tema4;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class EjemploAvanzadoPoi {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();

        // Crear una hoja llamada "Productos"
        Sheet sheet1 = workbook.createSheet("Productos");

        // Crear un estilo para la cabecera
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);

        // Crear la fila de la cabecera
        Row headerRow = sheet1.createRow(0);
        String[] headers = {"Producto", "Cantidad", "Precio Unitario", "Subtotal"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        
        Object[][] data = {
            {"Manzanas", 10, 2.5},
            {"Maranjas", 5, 3.0},
            {"Plátanos", 7, 1.8}
        };

        for (int i = 0; i < data.length; i++) {
            Row row = sheet1.createRow(i + 1);
            row.createCell(0).setCellValue((String) data[i][0]);
            row.createCell(1).setCellValue((Integer) data[i][1]);
            row.createCell(2).setCellValue((Double) data[i][2]);
           
            row.createCell(3).setCellFormula(String.format("B%d*C%d", i + 2, i + 2));
        }

       
        for (int i = 0; i < headers.length; i++) {
            sheet1.autoSizeColumn(i);
        }

        // Crear una segunda hoja llamada "Resumen"
        Sheet sheet2 = workbook.createSheet("Resumen");

        // Calcular el total de los subtotales
        Row resumenRow = sheet2.createRow(0);
        resumenRow.createCell(0).setCellValue("Total:");
        Cell totalCell = resumenRow.createCell(1);
        totalCell.setCellFormula("SUM(Productos!D2:D4)"); // Fórmula que suma los subtotales

        try (FileOutputStream outputStream = new FileOutputStream("ProductosAvanzado.xlsx")) {
            workbook.write(outputStream);
            System.out.println("Archivo Excel creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
