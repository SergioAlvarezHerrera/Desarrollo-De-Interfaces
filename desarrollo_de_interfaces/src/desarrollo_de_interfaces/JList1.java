package desarrollo_de_interfaces;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JList1 extends JFrame {

	public JList1() throws HeadlessException {
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		
		String[] grupos_de_musica = { "estopa" , "melendi" , "extremoDuro" , "Green Day" , "Anuel"};
		JList<String> lista = new JList<>(grupos_de_musica);
		
		panel.add(lista);
		
		lista.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					String selectedValue = lista.getSelectedValue();
					System.out.println("Elemento seleccionado: " + selectedValue);
					}
			}
		});
		
		setVisible(true);
		setSize(500,500);
		
		
		
	}

	

	

	public static void main(String[] args) {
		JList1 lista = new JList1();
	}

}
