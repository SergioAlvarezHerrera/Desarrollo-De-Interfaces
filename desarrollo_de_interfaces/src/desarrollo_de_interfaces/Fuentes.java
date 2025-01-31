package desarrollo_de_interfaces;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fuentes extends JFrame {
		JTextArea texto;
		

	public Fuentes() throws HeadlessException {
		
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		String[] FontNames= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		JComboBox<String> comboFuentes = new JComboBox<>(FontNames);
		panel.add(comboFuentes);
		
		texto = new JTextArea(20,20);
		
		comboFuentes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font (comboFuentes.getSelectedItem().toString(),Font.PLAIN,12));
				
			}
		});
		
		panel.add(texto);
		setSize(500,500);
		setVisible(true);
	

		
		
		
			
	}

	public static void main(String[] args) {
		Fuentes window = new Fuentes();

	}

}
