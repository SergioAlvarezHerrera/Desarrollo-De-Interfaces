package tema3;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControlAcceso extends JDialog {
	
	public ControlAcceso() {
		
		
		JPanel panel = new JPanel(new GridLayout(5,1));
		
		JTextField usuario = new JTextField();
		panel.add(usuario);
		
		JPasswordField contraseña = new JPasswordField();
		panel.add(contraseña);
		
		JButton aceptar = new JButton("aceptar");
		panel.add(aceptar);
		
		JButton cancelar = new JButton("cancelar");
		panel.add(cancelar);
		
		
		aceptar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (usuario.getText().equals("sergio") && contraseña.getText().equals("hola")) {
					dispose();
					new LookAndFeelExample();
				}
				
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		this.add(panel);
		setModal(true);
		setUndecorated(true);
		setSize(400,400);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		ControlAcceso acesso = new ControlAcceso();
	}
}

