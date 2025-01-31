package desarrollo_de_interfaces;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejercicio3 extends JFrame {

	public Ejercicio3() throws HeadlessException {
		JPanel panel = new JPanel();
		setContentPane(panel);
		
		JTextArea texto = new JTextArea(25,35);
		panel.add(texto);
		
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int tamañotexto = (int)texto.getFont().getSize();
		
		JSpinner spiner = new JSpinner();
		panel.add(spiner);
		spiner.setValue(tamañotexto);
		
		
		
		
		JSlider slider = new JSlider();
		panel.add(slider);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setMajorTickSpacing(10);
		slider.setValue(tamañotexto);
		slider.setPaintLabels(true);
		
		
		spiner.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				int tamaño1 = (int)spiner.getValue();
				texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), tamaño1));
				
				slider.setValue(tamaño1);
				
			}
			
		});
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int tamaño2=(int)slider.getValue();
				texto.setFont(new Font(texto.getFont().getName() , texto.getFont().getStyle() , tamaño2));
				
				spiner.setValue(tamaño2);
			}
			
		});
		String[] FontNames= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		String[] marcasMoto= {"honda" ,"suzuki" , "kawasaki"};
		JComboBox combomotos= new JComboBox(marcasMoto);
		panel.add(combomotos);
		
		
		
		setTitle("Ejercicio3");
		setLocation(100,200);
		setVisible(true);
		setSize(500,500);
		
	}

	
	public static void main(String[] args) {
		Ejercicio3 panel = new Ejercicio3();

	}

}
