package notas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginDialog loginDialog = new LoginDialog(null);
        loginDialog.setVisible(true);
        
        if (loginDialog.isAuthenticated()) {
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
            NotesApp notesApp = new NotesApp();
            notesApp.setVisible(true);
        }
    }
}