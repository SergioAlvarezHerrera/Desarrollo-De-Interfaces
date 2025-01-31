package tema2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class JFileChooserEjemplo extends JFrame {
	
	private JButton openButton;
	
	public JFileChooserEjemplo() {
		setTitle("Ejemplo JFileChooser");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		openButton = new JButton("Abrir archivo");
		openButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFileChooser();
				
			}
		});
		
		add(openButton);
		setVisible(true);
		setSize(400,200);
	}
	
	
	private void openFileChooser() {
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
			
		}else {
			System.out.println("Seleccion cancelada");
			
		}
	}
	
	public static void main (String[] args) {
		JFileChooserEjemplo ventana = new JFileChooserEjemplo();
	}

}
