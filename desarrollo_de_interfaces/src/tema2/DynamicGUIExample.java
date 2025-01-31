package tema2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DynamicGUIExample extends JFrame {
	
	private JPanel labelPanel;
	private JTextField inputField;
	private JButton addButton;

	public DynamicGUIExample(){
		setTitle("Ejemplo de gui dinamica tipo chat");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel , BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(labelPanel);
		add(scrollPane,BorderLayout.CENTER);
		
		JPanel inputPanel = new JPanel (new FlowLayout());
		inputField = new JTextField(20);
		addButton = new JButton("Agregar");
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel();
				
			}
		});
		
		inputField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel();
				
			}
		});
		
		inputPanel.add(inputField);
		inputPanel.add(addButton);
		add(inputPanel,BorderLayout.SOUTH);
		
		
	}
	
	private void addLabel() {
		String text = inputField.getText().trim();
		if(text.isEmpty()) {
			JLabel newLabel = new JLabel(text);
			labelPanel.add(newLabel);
			labelPanel.revalidate();
			labelPanel.repaint();
			
			inputField.setText("");
		}
	}
	
	public static void main(String[] args){
		DynamicGUIExample example = new DynamicGUIExample();
		example.setVisible(true);
	}
}
