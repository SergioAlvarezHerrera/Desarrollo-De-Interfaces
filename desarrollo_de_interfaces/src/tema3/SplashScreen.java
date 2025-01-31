package tema3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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
     mainPanel.setBackground(Color.WHITE);

     JLabel logoLabel = new JLabel("ALVARITO MARICON", JLabel.CENTER);
     logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
     logoLabel.setForeground(new Color(10, 102, 204));

    
     JLabel messageLabel = new JLabel("Cargando recursos, por favor espere...", JLabel.CENTER);
     messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
     messageLabel.setForeground(Color.GRAY);

     
     progressBar = new JProgressBar(0, 100);
     progressBar.setStringPainted(true);
     progressBar.setForeground(new Color(10, 102, 204));

     
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
             Thread.sleep(50); 
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