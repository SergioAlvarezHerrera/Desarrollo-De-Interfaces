package tema3;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Look_y_feel extends JFrame {
	
	public Look_y_feel(){
		JButton boton = new JButton();
		
		boton.setToolTipText("Gonzalo MARICON");
		boton.setMnemonic(KeyEvent.VK_N);
		try { UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

		} catch (ClassNotFoundException e) { e.printStackTrace(); }

		catch (InstantiationException e) { e.printStackTrace(); }

		catch (IllegalAccessException e) { e.printStackTrace(); }

		catch (UnsupportedLookAndFeelException e) { e.printStackTrace(); }
		
		this.add(boton);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Look_y_feel hola = new Look_y_feel();	
	}
	
	
}
