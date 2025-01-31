package desarrollo_de_interfaces;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JtabbedPane extends JFrame {

	public JtabbedPane() throws HeadlessException {
		// TODO Auto-generated constructor stub
		JTabbedPane tabbedpane = new JTabbedPane();
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Contenido de la pestaña 1"));
		
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Contenido de la pestaña 2"));
		
		JPanel panel3 = new JPanel();
		panel3.add(new JLabel("Contenido de la pestaña 3"));
		
		tabbedpane.addTab("Pestaña1", panel1);
		tabbedpane.addTab("Pestaña2", panel2);
		tabbedpane.addTab("Pestaña3", panel3);
		
		setContentPane(tabbedpane);
		
		setVisible(true);
		setSize(500,500);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JtabbedPane tabbedpane = new JtabbedPane();

	}

}
