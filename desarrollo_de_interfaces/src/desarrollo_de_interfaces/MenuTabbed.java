package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class MenuTabbed extends JFrame {
	private int contador = 1;

	public MenuTabbed() throws HeadlessException {
		// TODO Auto-generated constructor stub
		JTabbedPane tabbed = new JTabbedPane();
		setContentPane(tabbed);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu Archivo = new JMenu("Archivo");
		menubar.add(Archivo);
		
		JMenuItem nueva = new JMenuItem("nueva pestaña");
		Archivo.add(nueva);
		
		JMenuItem cerrar = new JMenuItem("cerrar pestaña");
		Archivo.add(cerrar);
		
		setVisible(true);
		setSize(400,400);
		
		
		
		nueva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextArea texto = new JTextArea();
				JPanel panel = new JPanel(new BorderLayout());
				panel.add(texto , BorderLayout.CENTER);
				
				tabbed.addTab("Pestaña" +contador++, panel);
				tabbed.setSelectedComponent(panel);
			}
		});
		
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tabbed.remove(tabbed.getSelectedComponent());
				contador -- ;
				
				
			}
		});

		
			
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuTabbed tabbed = new MenuTabbed();
	}

}
