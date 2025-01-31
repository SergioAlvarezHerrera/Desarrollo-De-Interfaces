package tema3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class AccesoPorTeclado extends JFrame{
	
	
	public AccesoPorTeclado() {
		JMenu fileMenu = new JMenu("Archivo");
		fileMenu.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem openItem = new JMenuItem("Abrir");
		JMenuItem saveItem = new JMenuItem("Guardar");
		
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"Opcion 'Abrir' seleccionada");
			}
		});
		
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Opcion 'Guardar' seleccionada");
			}
		});
		
	}
	

}
