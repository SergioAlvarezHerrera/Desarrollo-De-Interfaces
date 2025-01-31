package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gridLayout {


	public static void main(String[] args) {
		JFrame frame = new JFrame ("GridLayout Example");
		JPanel panel = new JPanel(new GridLayout(2,3));
		
		for (int i = 1;i<=6;i++ ) {
			panel.add(new JButton("boton" + i));
		}
		
		frame.add(panel);
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
