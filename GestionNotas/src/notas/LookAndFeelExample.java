package notas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelExample extends JComboBox<String> {

    public LookAndFeelExample() {
        super(new String[]{"Metal", "Nimbus", "Windows", "Windows Classic", "Motif"});

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLook = (String) getSelectedItem();
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
                    SwingUtilities.updateComponentTreeUI(SwingUtilities.getWindowAncestor(LookAndFeelExample.this));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Look and Feel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new LookAndFeelExample());
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
