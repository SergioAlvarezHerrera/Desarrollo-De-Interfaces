package lambdas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class lambdaActionListener extends JFrame {
	
	
	public lambdaActionListener(){
		
		
		JButton boton = new JButton("boton");
		
		boton.addActionListener(e -> {
			
			boton.setBackground(Color.red);
			
		});
		this.add(boton);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		lambdaActionListener hola = new lambdaActionListener();
	}
	

}
