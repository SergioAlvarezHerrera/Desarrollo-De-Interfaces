package paint;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SimplePaint extends JPanel {

    private List<List<Point>> linea = new ArrayList<>();
    private List<Point> points;
    private List<Color> colores = new ArrayList<>(); // Lista de colores para cada línea
    private Color colorActual = Color.BLACK; // Color por defecto
    private String modoDibujo = "Dibujo Libre"; // Modo de dibujo (Libre o Línea Recta)
    private Point puntoInicio; // Punto inicial para la línea recta

    public SimplePaint() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (modoDibujo.equals("Dibujo Libre")) {
                    // Modo Dibujo Libre
                    points = new ArrayList<>();
                    points.add(e.getPoint());
                    linea.add(points);
                    colores.add(colorActual); // Añadir el color actual para esta nueva línea
                } else if (modoDibujo.equals("Línea Recta")) {
                    // Modo Línea Recta
                    puntoInicio = e.getPoint();
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (modoDibujo.equals("Línea Recta")) {
    
                    List<Point> lineaRecta = new ArrayList<>();
                    lineaRecta.add(puntoInicio);
                    lineaRecta.add(e.getPoint());
                    linea.add(lineaRecta);
                    colores.add(colorActual); 
                    repaint();
                }
                points = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (modoDibujo.equals("Dibujo Libre")) {
                 
                    if (points != null) {
                        points.add(e.getPoint());
                        repaint();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < linea.size(); i++) {
            List<Point> linea1 = linea.get(i);
            g.setColor(colores.get(i)); 
            for (int j = 1; j < linea1.size(); j++) {
                Point p1 = linea1.get(j - 1);
                Point p2 = linea1.get(j);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint Básico");
        JPanel menus = new JPanel(new BorderLayout());
        JMenuBar menubar = new JMenuBar();
        menus.add(menubar, BorderLayout.NORTH);

   
        JMenu cambiarColor = new JMenu("Cambiar el color");
        menubar.add(cambiarColor);

        JMenuItem seleccionarColor = new JMenuItem("Seleccionar Color");
        cambiarColor.add(seleccionarColor);

        JMenu forma = new JMenu("Cambiar forma");
        menubar.add(forma);

     
        JMenuItem dibujoLibre = new JMenuItem("Dibujo Libre");
        forma.add(dibujoLibre);
        JMenuItem lineaRecta = new JMenuItem("Línea Recta");
        forma.add(lineaRecta);

        SimplePaint panel = new SimplePaint();

       
        dibujoLibre.addActionListener(e -> panel.modoDibujo = "Dibujo Libre");

        
        lineaRecta.addActionListener(e -> panel.modoDibujo = "Línea Recta");

        
        seleccionarColor.addActionListener(e -> {
            Color nuevoColor = JColorChooser.showDialog(null, "Seleccionar Color", panel.colorActual);
            if (nuevoColor != null) {
                panel.colorActual = nuevoColor;
            }
        });

        frame.add(menus, BorderLayout.NORTH);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

