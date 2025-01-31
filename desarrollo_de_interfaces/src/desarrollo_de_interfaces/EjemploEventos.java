package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploEventos extends JFrame implements FocusListener , MouseListener{
	
		private JTextField campoTexto,campoTexto2;
		private JPanel panel;
	public EjemploEventos() throws HeadlessException {
		
		setTitle("Ejemplo de Eventos de Foco y Mouse");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		campoTexto=new JTextField("Haz clic para ganar el foco");
		campoTexto.addFocusListener(this);
		campoTexto.setBackground(Color.WHITE);
		add(campoTexto,BorderLayout.NORTH);
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.addMouseListener(this);
		add(panel,BorderLayout.CENTER);
		
		campoTexto2 = new JTextField("haz clic para que el campo 1 pierda el foco");
		campoTexto2.setBackground(Color.WHITE);
		add(campoTexto2, BorderLayout.SOUTH);
		
		
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EjemploEventos ventana = new EjemploEventos();
		ventana.setVisible(true);
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("El raton ha hecho clic en el panel");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Boton del raton presionado en el panel");
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Boton del raton soltado en el panel");
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("El raton ha entrado en el panel");
		panel.setBackground(Color.GREEN);
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("El raton ha entrado en el panel");
		panel.setBackground(Color.LIGHT_GRAY);
	}



	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("El campo de texto ha ganado el foco");
		campoTexto.setBackground(Color.RED);
		
	}



	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		System.out.println("El campo de texto ha perdido el foco");
		campoTexto.setBackground(Color.WHITE);
		
	}

}
