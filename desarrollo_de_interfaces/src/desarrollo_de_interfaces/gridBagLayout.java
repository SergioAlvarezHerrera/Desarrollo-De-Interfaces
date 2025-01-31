package desarrollo_de_interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gridBagLayout {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame ("GridBagLayout Example");
		JPanel panel = new JPanel(new GridLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(new JButton("boton 1") , c);
		
		
		c.gridx = 1;
		c.gridy = 0;
		
		panel.add(new JButton("boton 2") , c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		
		panel.add(new JButton("boton 3") , c);
		
		
		frame.add(panel);
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
