package desarrollo_de_interfaces;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gridBagLayout2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("GridBagLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		JButton boton1 = new JButton("Boton1");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill= GridBagConstraints.NONE;
		c.weightx = 0;
		c.weighty = 0;
		frame.add(boton1,c);
		
		
		JButton boton2 = new JButton("Boton2");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill= GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		frame.add(boton2,c);
		
		JButton boton3 = new JButton("Boton3");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill= GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 0;
		frame.add(boton3,c);
		
		JButton boton4 = new JButton("Boton4");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill= GridBagConstraints.NONE;
		c.weightx = 0;
		c.weighty = 0;
		frame.add(boton4,c);
	
		frame.setVisible(true);
	}

}
