package desarrollo_de_interfaces;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjBoton extends JFrame {

	public EjBoton() throws HeadlessException {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("mi ventana");
		setLocation(100,200);
		setVisible(true);
		setSize(500,500);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		//Creamos un label
		JLabel etiqueta1 = new JLabel();
		
		//configuramos las propiedades del label
		etiqueta1.setText("soy una etiqueta");
		etiqueta1.setVisible(true);
		
		//añadimos la etiqueta al panel (contenedor de segundo nivel)
		contentPane.add(etiqueta1);
	
		
		JCheckBox seat = new JCheckBox("seat");
		JCheckBox hyundai = new JCheckBox("hyundai");
		JCheckBox toyota = new JCheckBox("toyota");
		
		contentPane.add(seat);
		contentPane.add(hyundai);
		contentPane.add(toyota);
		
		
		
		//Creamos el boton
		JButton boton1 = new JButton("boton");
		contentPane.add(boton1);
		
		boton1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueta1.setText("");
				if (seat.isSelected()) {
					etiqueta1.setText(etiqueta1.getText()+ seat.getText()+" ");
				}
				
				if (hyundai.isSelected()) {
					etiqueta1.setText(etiqueta1.getText()+ hyundai.getText()+" ");
				}
				
				if (toyota.isSelected()) {
					etiqueta1.setText(etiqueta1.getText()+ toyota.getText()+" ");
				}
				
				if (toyota.isSelected() & hyundai.isSelected() &seat.isSelected()){
					etiqueta1.setText("");
					etiqueta1.setText(etiqueta1.getText()+seat.getText()+" , "  + hyundai.getText()+" y " + toyota.getText()+"." );
				}
				
				if (toyota.isSelected() & hyundai.isSelected() &! seat.isSelected()){
					etiqueta1.setText("");
					etiqueta1.setText(etiqueta1.getText()+toyota.getText()+" y "  + hyundai.getText()+"." );
				}
				
				if (toyota.isSelected() & seat.isSelected() &! hyundai.isSelected()){
					etiqueta1.setText("");
					etiqueta1.setText(etiqueta1.getText()+toyota.getText()+" y "  + seat.getText()+"." );
				}
				
				if (hyundai.isSelected() & seat.isSelected() &! toyota.isSelected()){
					etiqueta1.setText("");
					etiqueta1.setText(etiqueta1.getText()+seat.getText()+" y "  + hyundai.getText()+"." );
				}
				
				
				
				
			}
		});
		
		
		
		
	}

	
	public static void main(String[] args) {
		EjBoton Window= new EjBoton();

	}

}
