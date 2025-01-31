package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame ("BorderLayout Example");
		JPanel panel = new JPanel(new BorderLayout());
		
		
		panel.add(new JButton("Norte"),BorderLayout.NORTH);
		panel.add(new JButton("sur"),BorderLayout.SOUTH);
		panel.add(new JButton("Este"),BorderLayout.EAST);
		panel.add(new JButton("Oeste"),BorderLayout.WEST);
		panel.add(new JButton("Centro"),BorderLayout.CENTER);
		
		frame.add(panel);
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}


	
	
	

}

	