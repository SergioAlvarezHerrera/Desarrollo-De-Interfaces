package paint;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public class Paint extends JPanel {
	
	private List<Point> points = new ArrayList<>();
	
	public Paint() {
		
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
				
			}
			
		});
	}
	
	

	protected void paintComponet(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.BLACK);
		for (int i = 1; i<points.size(); i++) {
			Point p1 = points.get(i-1);
			Point p2 = points.get(i);
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("paint basico en java");
		
		
		/*JPanel menus = new JPanel(new BorderLayout());
		frame.add(menus);
		
		JMenuBar menubar = new JMenuBar();
		menus.add(menubar , BorderLayout.NORTH);
		
		JMenu cambiarColor = new JMenu("Cambiar el color");
		menubar.add(cambiarColor);
		
		JMenu forma = new JMenu ("Cambiar forma");
		menubar.add(forma);
		
		JMenuItem dibujoLibre = new JMenuItem ("Dibujo Libre");
		forma.add(dibujoLibre);
		
		JMenuItem lineaRecta = new JMenuItem ("Linea Recta");
		forma.add(lineaRecta);
		
		JMenuItem circulo = new JMenuItem ("Circulo");
		forma.add(circulo);
		
		JMenuItem cuadrado = new JMenuItem ("Cuadrado");
		forma.add(cuadrado);
		
		JMenuItem anchoPincel = new JMenuItem ("anchoPincel");
		forma.add(anchoPincel);
		
		*/
		
		
		Paint paintPanel = new Paint();
		frame.add(paintPanel , BorderLayout.CENTER);
		//frame.add(menus , BorderLayout.NORTH);
		
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
