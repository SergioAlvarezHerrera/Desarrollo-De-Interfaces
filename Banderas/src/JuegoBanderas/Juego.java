package JuegoBanderas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tema2.BotonSergio;
import tema2.JDialogEjemplo;

public class Juego extends JFrame {
    
    private int puntuacion = 0;
    private int puntuacionMaxima = 0; 
    private JLabel puntuacionLabel; 
    private JLabel puntuacionMaximaLabel; 

    public Juego() {
       
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(7, 1)); 
        add(panelPrincipal);
        
      
        JPanel panelPuntuacion = new JPanel();
        puntuacionLabel = new JLabel("Puntuación: " + puntuacion);
        puntuacionMaximaLabel = new JLabel("Máxima Puntuación: " + puntuacionMaxima); 
        panelPuntuacion.add(puntuacionLabel);
        panelPuntuacion.add(puntuacionMaximaLabel); 
        panelPrincipal.add(panelPuntuacion);
        
        
        JPanel panelEspana = new JPanel();
        panelEspana.setLayout(new GridLayout(1, 2));
        
        BotonSergio botonEspana = new BotonSergio("Iniciar");
        botonEspana.setBackground(Color.GRAY);
        panelEspana.add(botonEspana);
       
        ImageIcon espana = new ImageIcon("Lib/españa.png");
        
        JLabel etiquetaEspana = new JLabel(espana);
        panelEspana.add(etiquetaEspana);
        panelPrincipal.add(panelEspana);
        
        botonEspana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialogo = new JDialogEjemplo(null);
                dialogo.setVisible(true);
                String respuesta = dialogo.getEnteredValue();
                if (respuesta.equalsIgnoreCase("españa") || respuesta.equals("España")) {
                    puntuacion += 50; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    if (puntuacion > puntuacionMaxima) {
                        puntuacionMaxima = puntuacion;
                        puntuacionMaximaLabel.setText("Máxima Puntuación: " + puntuacionMaxima);
                    }
                    JOptionPane.showMessageDialog(null, "Has acertado, felicidades", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    botonEspana.setBackground(Color.GREEN);
                    botonEspana.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Has fallado", "Muy mal", JOptionPane.ERROR_MESSAGE);
                    puntuacion -= 25; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    botonEspana.setBackground(Color.RED);
                }
            }
        });
        
        
        JPanel panelMarruecos = new JPanel();
        panelMarruecos.setLayout(new GridLayout(1, 2));
       
        BotonSergio botonMarruecos = new BotonSergio("Iniciar");
        botonMarruecos.setBackground(Color.GRAY);
        panelMarruecos.add(botonMarruecos);
        
        ImageIcon marruecos = new ImageIcon("Lib/marruecos.png");
        
        JLabel etiquetaMarruecos = new JLabel(marruecos);
        panelMarruecos.add(etiquetaMarruecos);
        panelPrincipal.add(panelMarruecos);
        
        botonMarruecos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialogo = new JDialogEjemplo(null);
                dialogo.setVisible(true);
                String respuesta = dialogo.getEnteredValue();
                if (respuesta.equalsIgnoreCase("marruecos") || respuesta.equals("Marruecos")) {
                    puntuacion += 50; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    if (puntuacion > puntuacionMaxima) {
                        puntuacionMaxima = puntuacion;
                        puntuacionMaximaLabel.setText("Máxima Puntuación: " + puntuacionMaxima);
                    }
                    JOptionPane.showMessageDialog(null, "Has acertado, felicidades", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    botonMarruecos.setBackground(Color.GREEN);
                    botonMarruecos.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Has fallado", "Muy mal", JOptionPane.WARNING_MESSAGE);
                    puntuacion -= 25; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    botonMarruecos.setBackground(Color.RED);
                }
            }
        });
        
      
        JPanel panelPeru = new JPanel();
        panelPeru.setLayout(new GridLayout(1, 2));
        
        BotonSergio botonPeru = new BotonSergio("Iniciar");
        botonPeru.setBackground(Color.GRAY);
        panelPeru.add(botonPeru);
       
        ImageIcon peru = new ImageIcon("Lib/peru.png");
        
        JLabel etiquetaPeru = new JLabel(peru); 
        panelPeru.add(etiquetaPeru);
        panelPrincipal.add(panelPeru);
        
        botonPeru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialogo = new JDialogEjemplo(null);
                dialogo.setVisible(true);
                String respuesta = dialogo.getEnteredValue();
                if (respuesta.equalsIgnoreCase("perú") || respuesta.equals("peru") || respuesta.equals("Peru")) {
                    puntuacion += 50; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                  
                    if (puntuacion > puntuacionMaxima) {
                        puntuacionMaxima = puntuacion;
                        puntuacionMaximaLabel.setText("Máxima Puntuación: " + puntuacionMaxima);
                    }
                    JOptionPane.showMessageDialog(null, "Has acertado, felicidades", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    botonPeru.setBackground(Color.GREEN);
                    botonPeru.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Has fallado", "Muy mal", JOptionPane.ERROR_MESSAGE);
                    puntuacion -= 25; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    botonPeru.setBackground(Color.RED);
                }
            }
        });

       
        JPanel panelBolivia = new JPanel();
        panelBolivia.setLayout(new GridLayout(1, 2));
        
        BotonSergio botonBolivia = new BotonSergio("Iniciar");
        botonBolivia.setBackground(Color.GRAY);
        panelBolivia.add(botonBolivia);
        
        ImageIcon bolivia = new ImageIcon("Lib/bolivia.png");
        
        JLabel etiquetaBolivia = new JLabel(bolivia);
        panelBolivia.add(etiquetaBolivia);
        panelPrincipal.add(panelBolivia);
        
        botonBolivia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialogo = new JDialogEjemplo(null);
                dialogo.setVisible(true);
                String respuesta = dialogo.getEnteredValue();
                if (respuesta.equalsIgnoreCase("bolivia") || respuesta.equals("Bolivia")) {
                    puntuacion += 50; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                  
                    if (puntuacion > puntuacionMaxima) {
                        puntuacionMaxima = puntuacion;
                        puntuacionMaximaLabel.setText("Máxima Puntuación: " + puntuacionMaxima);
                    }
                    JOptionPane.showMessageDialog(null, "Has acertado, felicidades", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    botonBolivia.setBackground(Color.GREEN);
                    botonBolivia.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Has fallado", "Muy mal", JOptionPane.ERROR_MESSAGE);
                    puntuacion -= 25; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    botonBolivia.setBackground(Color.RED);
                }
            }
        });

       
        JPanel panelMongolia = new JPanel();
        panelMongolia.setLayout(new GridLayout(1, 2)); 
        
        BotonSergio botonMongolia = new BotonSergio("Iniciar");
        botonMongolia.setBackground(Color.GRAY);
        panelMongolia.add(botonMongolia);
        
        ImageIcon mongolia = new ImageIcon("Lib/mongolia.png");
        
        JLabel etiquetaMongolia = new JLabel(mongolia);
        panelMongolia.add(etiquetaMongolia);
        panelPrincipal.add(panelMongolia);
        
        botonMongolia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialogo = new JDialogEjemplo(null);
                dialogo.setVisible(true);
                String respuesta = dialogo.getEnteredValue();
                if (respuesta.equalsIgnoreCase("mongolia") || respuesta.equals("Mongolia")) {
                    puntuacion += 50; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                   
                    if (puntuacion > puntuacionMaxima) {
                        puntuacionMaxima = puntuacion;
                        puntuacionMaximaLabel.setText("Máxima Puntuación: " + puntuacionMaxima);
                    }
                    JOptionPane.showMessageDialog(null, "Has acertado, felicidades", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    botonMongolia.setBackground(Color.GREEN);
                    botonMongolia.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Has fallado", "Muy mal", JOptionPane.ERROR_MESSAGE);
                    puntuacion -= 25; 
                    puntuacionLabel.setText("Puntuación: " + puntuacion);
                    botonMongolia.setBackground(Color.RED);
                }
            }
        });

    
        setSize(526, 800);
        setTitle("Quiz de Banderas"); 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        setVisible(true);
        this.setResizable(true);
        
      
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Juego.this, 
                    "¿Estás seguro de que quieres dejar de jugar?", "Salir", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } 
            }
        });
    }
    
    public static void main(String[] args) {
        Juego window = new Juego();
    }
}