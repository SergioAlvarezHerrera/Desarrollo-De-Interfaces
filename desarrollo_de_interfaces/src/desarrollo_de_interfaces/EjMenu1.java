package desarrollo_de_interfaces;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class EjMenu1 extends JFrame {

	public EjMenu1() throws HeadlessException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("mi ventana");
		setLocation(100,200);
		setVisible(true);
		setSize(500,500);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		JMenuBar  menuBar = new JMenuBar();
		
		JMenu Archivos = new JMenu("Archivos");
			menuBar.add(Archivos);

			JMenuItem Nuevo = new JMenuItem("Nuevo");
			Archivos.add(Nuevo);
			
			JMenuItem Abrir = new JMenuItem("Abrir");
			Archivos.add(Abrir);
			
			JSeparator separador = new JSeparator();
			Archivos.add(separador);
			
			JMenuItem Salir = new JMenuItem("Salir");
			Archivos.add(Salir);
			
			JCheckBoxMenuItem Caja =new JCheckBoxMenuItem("Caja");
			Archivos.add(Caja);
			
		
		JMenu Editar = new JMenu("Editar");
			menuBar.add(Editar);
			
			JMenuItem Copiar = new JMenuItem("Copiar");
			Editar.add(Copiar);
			
			JMenuItem Pegar = new JMenuItem("Pegar");
			Editar.add(Pegar);
			
			JRadioButtonMenuItem Radio = new JRadioButtonMenuItem("Radio");
			Editar.add(Radio);
			
		
		JMenu Formato = new JMenu("Formato");
		
			menuBar.add(Formato);
			
			JMenuItem Negrita = new JMenuItem("Negrita");
			Formato.add(Negrita);
			JMenuItem Cursiva = new JMenuItem("Cursiva");
			Formato.add(Cursiva);
			
			
		setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		
		EjMenu1 window = new EjMenu1();

	}

}
