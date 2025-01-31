package desarrollo_de_interfaces;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Scroll extends JFrame {

	public Scroll() throws HeadlessException {
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		
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
		
		JTextArea campo = new JTextArea(15,20);
		panel.add(campo);
		
		JScrollPane scroll = new JScrollPane(campo);
		panel.add(scroll);
		
		menuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					campo.setText("");
				
			}
		});
		
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JSpinner Spiner = new JSpinner();
		Spiner.setValue(30);
		panel.add(Spiner);
		
				
		
		JSlider Slider = new JSlider();
		Slider.setMinimum(10);
		Slider.setMaximum(100);
		Slider.setMajorTickSpacing(10);
		Slider.setValue(20);
		Slider.setPaintLabels(true);
		
		panel.add(Slider);
		
	}

	
	

	public static void main(String[] args) {
		Scroll panel= new Scroll();

	}

}
