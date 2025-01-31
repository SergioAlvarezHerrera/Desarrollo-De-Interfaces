package tema2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JOptionPaneEjemplos extends JFrame {
	
	
	public JOptionPaneEjemplos() throws HeadlessException {
		JPanel panel = new JPanel(); 
		setContentPane(panel);
		
		JButton boton = new JButton("pulsa");
		panel.add(boton);
		
		JTextArea texto = new JTextArea();
		panel.add(texto);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "tu programa te saluda");
				
			}
		});
		
		JButton boton1 = new JButton("pulsa");
		panel.add(boton);
		
		boton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "tu programa te saluda");
				
			}
		});
		
		
		JButton boton2 = new JButton("pulsa");
		panel.add(boton2);
		
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "tu programa te saluda");
				
			}
		});
		
		
		
		JButton boton3 = new JButton("pulsa");
		panel.add(boton3);
		
		boton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre");
				texto.setText(nombre);
			}
		});
		
		String[] opciones = {"Opcion A" , "Opcion B" , "Opcion B" ,"Opcion B"};
		int respuesta = JOptionPane.showOptionDialog(null, "es necesario que seleccione ina opcion " , "titulo" , JOptionPane.YES_NO_CANCEL_OPTION ,JOptionPane.QUESTION_MESSAGE,null,opciones,null);
		
	
		setLocation(100, 200);    
        setVisible(true);
        setSize(800, 500);

	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPaneEjemplos hola = new JOptionPaneEjemplos();
	}

}
