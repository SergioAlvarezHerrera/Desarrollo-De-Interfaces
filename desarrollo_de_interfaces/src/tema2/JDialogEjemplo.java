package tema2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JDialogEjemplo extends JDialog {
    private BotonSergio aceptButton, cancelButton;
    private String texto1;

    public JDialogEjemplo(JFrame parent) {
        super(parent, "Dialogo Personalizado", true);
        JPanel panelBottom = new JPanel();
        JPanel panelCenter = new JPanel();
        JTextField texto = new JTextField(35);
        panelCenter.add(texto);

        aceptButton = new BotonSergio("Aceptar");
        cancelButton = new BotonSergio("Cancelar");

        panelBottom.add(aceptButton);
        panelBottom.add(cancelButton);

        add(panelBottom, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);

        setSize(400, 200);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        aceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto1 = texto.getText();
                dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto1 = "";
                dispose();
            }
        });
    }

    public String getEnteredValue() {
        return texto1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ventana principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new FlowLayout());

        JButton openDialogButton = new JButton("Abrir Dialogo");
        frame.add(openDialogButton);

        JTextArea text = new JTextArea(20, 40);
        text.setVisible(true);
        frame.add(text);

        openDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogEjemplo dialog = new JDialogEjemplo(frame);
                dialog.setVisible(true);
                String s = dialog.getEnteredValue();
                text.setText(s); // Actualizar el contenido del JTextArea sin duplicar
            }
        });

        frame.setVisible(true);
    }
}

