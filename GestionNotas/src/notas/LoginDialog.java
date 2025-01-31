package notas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginDialog extends JDialog {
    private boolean authenticated = false;

    public LoginDialog(JFrame parent) {
        super(parent, "Iniciar Sesión", true);
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Iniciar Sesión");
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String password = new String(passwordField.getPassword());
                if (user.equals("usuario") && password.equals("contraseña")) {
                    authenticated = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
        		