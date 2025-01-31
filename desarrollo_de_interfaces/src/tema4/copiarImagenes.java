package tema4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class copiarImagenes extends JFrame{
	
	public copiarImagenes() {
		
		
		JLabel mensajeLabel = new JLabel();
		
		JButton boton = new JButton("Seleccionar archivo de origen");
		
		boton.addActionListener(e -> {
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(this);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File archivoOrigen = fileChooser.getSelectedFile();
				mensajeLabel.setText("Archivo seleccionado: " + archivoOrigen.getAbsolutePath());
				seleccionarDestino(this , archivoOrigen , mensajeLabel);
			}
			
		});
		
		
	}
	
	
	private static void seleccionarDestino(JFrame frame , File archivoOrigen , JLabel mensajeLabel) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecciona el directorio de destino");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int seleccion = fileChooser.showSaveDialog(frame);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File directorioDestino = fileChooser.getSelectedFile();
		
			
			File archivoDestino = new File(directorioDestino , archivoOrigen.getName());
			
			try {
				Files.copy(archivoOrigen.toPath(), archivoDestino.toPath() , StandardCopyOption.REPLACE_EXISTING);
				mensajeLabel.setText("Archivo copiado a: " + archivoDestino.getAbsolutePath());
			}catch(IOException ex){
				 mensajeLabel.setText("Error al copiar el archivo: " + ex.getMessage());
			}
		} else {
			mensajeLabel.setText("operacion cancelada");
		}
		
	}

	
}
