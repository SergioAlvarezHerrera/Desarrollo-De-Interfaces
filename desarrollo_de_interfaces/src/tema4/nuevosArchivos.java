package tema4;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class nuevosArchivos {
	
	public static void copiarFotoRedimensionada(File inputFile, File outputFile , int anchoFinal , int altoFinal ) throws IOException {
		
		BufferedImage inputImage = ImageIO.read(inputFile);
		
		int altoOriginal = inputImage.getHeight();
		int anchoOriginal = inputImage.getWidth();
		
		double proporcionAncho = (double) anchoFinal / (double) anchoOriginal;
		double proporcionAlto = (double) altoFinal / (double) altoOriginal;
		double proporcion = Math.min(proporcionAlto,proporcionAncho);
		int anchoRecomendado = (int) (anchoOriginal*proporcion);
		int altoRecomendado = (int) (altoOriginal*proporcion);
		
		BufferedImage outputImage = new BufferedImage( anchoRecomendado, altoRecomendado , inputImage.getType());
		
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage ,0,0,anchoRecomendado,altoRecomendado,null);
		g2d.dispose();
		
		Image.IO.write(outputImage, "png" , outputFile);
		
	}
	
	public static void main(String[] args) {
		nuevosArchivos hola = new nuevosArchivos();
	}
}
