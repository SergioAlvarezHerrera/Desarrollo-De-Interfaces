package modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class SplashScreen extends JDialog {
    private JProgressBar progressBar;

    public SplashScreen() {
        setSize(400, 250);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());
        setUndecorated(true); 

        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

       
        JLabel logoLabel = new JLabel();
        ImageIcon imagen = new ImageIcon("Lib/mafia.png");
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH));
        logoLabel.setIcon(imagenEscalada);

       
        JLabel messageLabel = new JLabel("Cargando recursos, por favor espere...", JLabel.CENTER);
        messageLabel.setFont(messageLabel.getFont().deriveFont(14f));
        messageLabel.setForeground(Color.WHITE);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.BLACK);

     
        mainPanel.add(logoLabel, BorderLayout.CENTER);
        mainPanel.add(messageLabel, BorderLayout.SOUTH);

        
        add(mainPanel, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }

    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setVisible(true);

 
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(25); 
                splashScreen.updateProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        splashScreen.dispose();

      
        JFrame mainApp = new JFrame("Aplicación Principal");
        mainApp.setSize(600, 400);
        mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainApp.setLocationRelativeTo(null);
        mainApp.setVisible(true);
    }
}
