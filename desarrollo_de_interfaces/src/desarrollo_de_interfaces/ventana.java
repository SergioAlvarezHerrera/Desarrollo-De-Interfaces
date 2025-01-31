package desarrollo_de_interfaces;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class ventana extends JFrame {

	public ventana() throws HeadlessException{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//Establecemos el contenedor de segundo nivel 
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		//Creamos la barra de menus
		JMenuBar menuBar;
		
		//Creamos el primer menu
		JMenu menu;
		
		//Creo la primera linea dentro del menu
		JMenuItem menuItem;
		
		//Hago una instancia del menu bar
		menuBar = new JMenuBar();
		
		//hago una instancia del menu
		menu= new JMenu("Menu");
		
		//Hago una instancia del submenu
		menuItem = new JMenuItem("opcion1");
		
		//Añadimos el menu a la barra de menus
		menuBar.add(menu);
		
		//añadimos un submenu a la barra de tareas
		menu.add(menuItem);
		
		//añadimos la barra de menus al JFrame
		setJMenuBar(menuBar);
		
		//Ponemos la barra de menus visible
		menuBar.setVisible(true);
		
		//titulo de la ventan
		setTitle("Mi Ventana");
				
		//posicion de la ventan
		setLocation(100,200);
				
				
		//Haces visible la ventana
		setVisible(true);
				
		//tamaño de la ventana
		setSize(500,500);
		
		
		
		
}


	
	public static void main(String[] args) {
		ventana window= new ventana();

	}

}
