package cineapp;

import panels.ListadoPanel;
import panels.FormularioPanel;

import panels.GraficosPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CineApp extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private PeliculaManager peliculaManager;
    private SplashScreen splashScreen;

    public CineApp() {
        peliculaManager = new PeliculaManager();
        splashScreen = new SplashScreen();
        splashScreen.showSplash(); 

        setTitle("CineApp");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
       
        ListadoPanel listadoPanel = new ListadoPanel(peliculaManager);
        mainPanel.add(listadoPanel, "listado");

       
        FormularioPanel formularioPanel = new FormularioPanel(peliculaManager);
        mainPanel.add(formularioPanel, "formulario");

        
        GraficosPanel graficoPanel = new GraficosPanel(peliculaManager);
        mainPanel.add(graficoPanel, "grafico");

        
        JPanel navPanel = new JPanel();
        JButton listadoButton = new JButton("Listado");
        JButton formularioButton = new JButton("Añadir Película");
        JButton graficoButton = new JButton("Gráfico");

        listadoButton.addActionListener(e -> cardLayout.show(mainPanel, "listado"));
        formularioButton.addActionListener(e -> cardLayout.show(mainPanel, "formulario"));
        graficoButton.addActionListener(e -> cardLayout.show(mainPanel, "grafico"));

        navPanel.add(listadoButton);
        navPanel.add(formularioButton);
        navPanel.add(graficoButton);

        
        add(navPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CineApp::new);
    }
}

