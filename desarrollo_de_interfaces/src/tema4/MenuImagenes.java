package tema4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuImagenes extends JFrame {

    private JLabel imageLabel;
    private Image image;

    public MenuImagenes() {
        setTitle("Cargar Imagen");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem loadItem = new JMenuItem("Cargar Imagen");
        loadItem.addActionListener(e -> loadImage());
        menu.add(loadItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

      
        imageLabel = new JLabel();
       // imageLabel.setHorizontalAlignment(JLabel.CENTER);

       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 500));

       
        //imageLabel.setBounds(0, 0, 500, 500);
       

       
       /* JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBounds(0, 0, 500, 500);
        panel.add(buttonPanel, Integer.valueOf(1));

        
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);*/

        
        add(panel, BorderLayout.CENTER);
        panel.add(imageLabel,BorderLayout.CENTER);
        
        addComponentListener(new ComponentListener() {
			
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				if (image != null) {
					updateImage();
				}
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        

        setVisible(true);
    }
    
    private void updateImage() {
    	//imageLabel.getIcon();
    	
    	/*ImageIcon icono = (ImageIcon) imageLabel.getIcon();
    	Image image = icono.getImage();*/
    	
    	int nuevoAlto = imageLabel.getHeight();
    	int nuevoAncho = imageLabel.getWidth();
    	
    	Image nuevaImagen = image.getScaledInstance(nuevoAncho,nuevoAlto,  Image.SCALE_SMOOTH);
    	
    	imageLabel.setIcon(new ImageIcon(nuevaImagen));

    	
    	/*
    	
    	int anchoFinal = 60;

    	int altoFinal = 70;

    	int altoOriginal = icono.getIconHeight();

    	int anchoOriginal = icono.getIconWidth();

    	

    	double relacionAncho = (double)anchoFinal / anchoOriginal;

    	double relacionAlto = (double)altoFinal / altoOriginal;

    	

    	double relacion = Math.min(relacionAlto, relacionAncho);

    	int anchoRecomendado = (int)(anchoOriginal * relacion);

    	int altoRecomendado = (int)(altoOriginal * relacion);

    	

    	icono.setImage(icono.getImage().getScaledInstance(anchoRecomendado, altoRecomendado, Image.SCALE_SMOOTH));*/
    }
    
    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                image = ImageIO.read(selectedFile);
                ImageIcon imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
       MenuImagenes hola = new MenuImagenes();
    }
}

