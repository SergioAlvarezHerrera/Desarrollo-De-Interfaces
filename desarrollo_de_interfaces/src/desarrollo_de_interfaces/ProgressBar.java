package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class ProgressBar extends JFrame {

	public ProgressBar() throws HeadlessException {
		JPanel panel = new JPanel(new BorderLayout());
		setContentPane(panel);
		
		JProgressBar progressbar = new JProgressBar(0,100);
		progressbar.setValue(0);
		progressbar.setStringPainted(true);
		 
		panel.add(progressbar);
		
	
		
		new Timer (100, e-> {
			int value = progressbar.getValue();
			if (value <100) {
				progressbar.setValue(value +1);
			}else {
				((Timer) e.getSource()).stop();
			}
		}).start();
		
		setVisible(true);
		setSize(400,200);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgressBar progressbar= new ProgressBar();
	}

}
