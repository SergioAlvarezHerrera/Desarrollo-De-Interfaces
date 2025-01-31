package cineapp;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.showSplash();  

       
        SwingUtilities.invokeLater(() -> {
            CineApp cineAppWindow = new CineApp();
            cineAppWindow.setVisible(true);
        });
    }
}

