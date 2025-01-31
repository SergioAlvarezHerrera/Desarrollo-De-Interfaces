package paint;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint2 extends JPanel {

private List<Point> points = new ArrayList<>();
	
	public Paint2() {
		
		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				points.add(e.getPoint());
				repaint();
				
			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				points.add(e.getPoint());
				repaint();
				System.out.println();
				
			}
			
		});
	}
	
	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		for(int i = 1 ; i< points.size(); i++) {
			Point p1 = points.get(i-1);
			Point p2 = points.get(i);
			
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
			
			
		}
	}
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("paint basico en java");
		
		Paint2 paintPanel = new Paint2();
		
		frame.add(paintPanel , BorderLayout.CENTER);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
