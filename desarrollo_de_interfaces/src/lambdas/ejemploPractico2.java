package lambdas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ejemploPractico2 extends JFrame {
	
	public ejemploPractico2(){
			
			
			JPanel panel = new JPanel();
			
			JButton boton1 = new JButton("boton1");
			JButton boton2 = new JButton("boton2");
			
			boton1.addActionListener(e -> boton2.setBackground(Color.red));
			boton2.addActionListener(e -> boton1.setBackground(Color.blue));
			
			panel.add(boton1);
			panel.add(boton2);
			this.add(panel);
			this.setVisible(true);
			setSize(500,500);
		}
		
		public static void main(String[] args) {
			ejemploPractico2 hola = new ejemploPractico2();
		}
		
}
