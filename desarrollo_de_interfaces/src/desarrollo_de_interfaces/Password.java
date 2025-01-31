package desarrollo_de_interfaces;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Password extends JFrame {

	public Password() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//creamos el panel
		JPanel panel = new JPanel();
		setContentPane(panel);
		
		//Creamos el label 
		JLabel label = new JLabel();
		//Le damos propiedades al label
		label.setVisible(true);
		//añadimos el JLabel al JPanel
		panel.add(label);
		
		
		//creamos un jtextfield
		JTextField cajatexto=new JTextField (20);
		//configuramos las propiedades del JTextField
		panel.add(cajatexto);
		cajatexto.setVisible(true);
		
		//Añadimos el Jtextfield al panel
		panel.add(cajatexto);
		
		//Usamos un campo password
		JPasswordField contraseña = new JPasswordField(20);
		
		//añadimos el Jpasswordfield al panel
		panel.add(contraseña);
		
		//añadimos un boton
		JButton boton = new JButton("boton");
		
		//añadimos el boton al panel
		panel.add(boton);
		
		//añadir una accion al boton
		boton.addActionListener (new ActionListener(){
			@Override	
			public void actionPerformed (ActionEvent e) { 
				//accion que se ejecuta cuando pulsamos el boton
				if (String.valueOf(contraseña.getPassword()).equals("1234") & cajatexto.getText().equals("sergio")) 
					label.setText("contraseña  y usuario correctos");
				
				if ((!String.valueOf(contraseña.getPassword()).equals("1234"))&(!cajatexto.getText().equals("sergio")))
					label.setText("contraseña y usuario incorrectos");
				
				if (cajatexto.getText().equals("sergio") &(!String.valueOf(contraseña.getPassword()).equals("1234")))
					label.setText("usuario correcto y contraseña incorrecta");
				
				if((!cajatexto.getText().equals("sergio")) & String.valueOf(contraseña.getPassword()).equals("1234"))
					label.setText("usuario incorrecto y contraseña correcta");
	
			}		
			});
		
		setTitle("mi ventana");
		setLocation(100,200);
		setVisible(true);
		setSize(500,500);
		
		
		
	}


	public static void main(String[] args) {
		Password panel= new Password();

	}

}
