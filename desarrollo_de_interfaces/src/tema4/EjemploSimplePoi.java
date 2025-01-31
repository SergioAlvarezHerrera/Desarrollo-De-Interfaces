package tema4;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EjemploSimplePoi {
	
	
	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Datos");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Hola , Apache Poi");
		
		try(FileOutputStream outputStream = new FileOutputStream("Ejemplo.xlsx")) {
			workbook.write(outputStream);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Archivo Excel creado exitosamente");
	}

}
