package desarrollo_de_interfaces;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class boxLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("GridLayout Example");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(new JButton("boton 1"));
		panel.add(new JButton("boton 2"));
		panel.add(new JButton("boton 3"));
		
		frame.add(panel);
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
