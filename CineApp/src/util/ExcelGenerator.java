package util;

import cineapp.PeliculaManager;
import cineapp.Pelicula;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelGenerator {

    public static void generarExcel(PeliculaManager manager, String archivoDestino) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Películas");
        Row headerRow = sheet.createRow(0);

      
        String[] columnas = {"Título", "Tipo", "Resumen", "Imagen"};
        for (int i = 0; i < columnas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        List<Pelicula> peliculas = manager.getPeliculas();
        int rowNum = 1;
        for (Pelicula pelicula : peliculas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(pelicula.getTitulo());
            row.createCell(1).setCellValue(pelicula.getTipo());
            row.createCell(2).setCellValue(pelicula.getResumen());
            row.createCell(3).setCellValue(pelicula.getImagePath() != null ? pelicula.getImagePath() : "Sin Imagen");
        }

        Row totalRow = sheet.createRow(rowNum);
        totalRow.createCell(0).setCellValue("Total");
        totalRow.createCell(1).setCellValue(peliculas.size());

        
        for (int i = 0; i < columnas.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(archivoDestino)) {
            workbook.write(fileOut);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}