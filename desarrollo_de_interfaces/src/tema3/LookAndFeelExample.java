package tema3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelExample extends JFrame {
    private JComboBox<String> comboBox;

    public LookAndFeelExample() {
        // Crear un JComboBox con las opciones de Look & Feel
        String[] looks = {
            "Metal",
            "Nimbus",
            "Windows",
            "Windows Classic",
            "Motif"
        };

        comboBox = new JComboBox<>(looks);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLook = (String) comboBox.getSelectedItem();
                try {
                    switch (selectedLook) {
                        case "Metal":
                            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                            break;
                        case "Nimbus":
                            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                            break;
                        case "Windows":
                            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                            break;
                        case "Windows Classic":
                            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                            break;
                        case "Motif":
                            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                            break;
                        default:
                            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                            break;
                    }
                    // Actualizar la UI con el nuevo Look & Feel
                    SwingUtilities.updateComponentTreeUI(SwingUtilities.getWindowAncestor(comboBox));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Configurar la ventana
        this.add(comboBox);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LookAndFeelExample());
    }
}

