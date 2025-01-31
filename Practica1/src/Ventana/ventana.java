package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ventana extends JFrame {

    private JLabel infoLabel;

    public ventana() throws HeadlessException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creamos un slider
        JSlider slider = new JSlider();
        
        // Creamos un spinner
        JSpinner spiner = new JSpinner();
        
        // Creamos y configuramos el panel
        JPanel panel = new JPanel(new BorderLayout());
        setContentPane(panel);
        
        // Creamos la barra del menú con sus menús y submenús
        JMenuBar menuBar = new JMenuBar();

        JMenu Archivos = new JMenu("Archivos");
        menuBar.add(Archivos);
        
        JMenuItem abrir = new JMenuItem("Abrir archivo");
        Archivos.add(abrir);
        
        JMenuItem guardar = new JMenuItem("Guardar archivo");
        Archivos.add(guardar);
        
        

        JMenuItem Nuevo = new JMenuItem("Nuevo");
        Archivos.add(Nuevo);

        JMenuItem Salir = new JMenuItem("Salir");
        Archivos.add(Salir);

        JMenu Estilo = new JMenu("Estilo");
        menuBar.add(Estilo);
        
        JMenuItem color = new JMenuItem("Color");
        Estilo.add(color);
        
        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
        Estilo.add(negrita);

        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
        Estilo.add(cursiva);
        
        // Añadimos un área de texto en el centro de la ventana
        JTextArea texto = new JTextArea();
        panel.add(texto, BorderLayout.CENTER);
    
        // Añadimos un scroll al área de texto 
        JScrollPane scroll = new JScrollPane(texto);
        panel.add(scroll);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        // Creamos un subpanel en la parte superior de la ventana
        JPanel subpanel = new JPanel(new FlowLayout());
        panel.add(subpanel, BorderLayout.NORTH);

        // Añadimos el spinner al subpanel
        subpanel.add(spiner);
        int tamañotexto = texto.getFont().getSize();
        spiner.setValue(tamañotexto);
        
        // Configuramos el tamaño de fuente del textArea con el spinner 
        spiner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int tamaño1 = (int) spiner.getValue();
                texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), tamaño1));
                slider.setValue(tamaño1);
                actualizarInfoLabel(texto);
            }
        });
        
        // Añadimos un slider al subpanel
        subpanel.add(slider);
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setMajorTickSpacing(10);
        slider.setValue(tamañotexto);
        slider.setPaintLabels(true);
       
        // Configuramos el tamaño de fuente del textArea con el slider
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int tamaño2 = slider.getValue();
                texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), tamaño2));
                spiner.setValue(tamaño2);
                actualizarInfoLabel(texto);
            }
        });
        
        // Añadimos el checkbox para negrita
        JCheckBox negrita1 = new JCheckBox("Negrita");
        subpanel.add(negrita1);

        // Añadimos el checkbox para cursiva
        JCheckBox cursiva1 = new JCheckBox("Cursiva");
        subpanel.add(cursiva1);

        // Añadimos un combo box para seleccionar la fuente
        String[] FontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox<String> tipoLetra = new JComboBox<>(FontNames);
        subpanel.add(tipoLetra);
        String fuenteDefecto = "Dialog";
        
        int estiloActual = texto.getFont().getStyle();
        int tamañoDefecto = texto.getFont().getSize();
        tipoLetra.setSelectedItem(fuenteDefecto);
        texto.setFont(new Font(fuenteDefecto, estiloActual, tamañoDefecto)); 
        
        // Configurando el comboBox Action Listener
        tipoLetra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font(tipoLetra.getSelectedItem().toString(), texto.getFont().getStyle(), texto.getFont().getSize()));
                spiner.setValue(texto.getFont().getSize());
                slider.setValue(texto.getFont().getSize());
                actualizarInfoLabel(texto);
            }
        });
        
        // Configuramos los checkBox para que realicen la acción
        ActionListener estilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int estilo = Font.PLAIN;
                if (negrita1.isSelected() || negrita.isSelected()) {
                    estilo += Font.BOLD;
                }
                if (cursiva1.isSelected() || cursiva.isSelected()) {
                    estilo += Font.ITALIC;
                }
                texto.setFont(new Font(texto.getFont().getName(), estilo, texto.getFont().getSize()));
                actualizarInfoLabel(texto);
            }
        };
        
		abrir.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						openFile(texto);				
					}
				});
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFile(texto);
				
			}
		});
		
		Nuevo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						texto.setText("");
						
					}
				});
		
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Color colorSeleccionado = JColorChooser.showDialog(panel, "Elige un color", Color.BLACK);
				 panel.setForeground(colorSeleccionado);
				 texto.setForeground(colorSeleccionado);
			}
		});
			
		        negrita1.addActionListener(estilo);
		        cursiva1.addActionListener(estilo);
		        negrita.addActionListener(estilo);
		        cursiva.addActionListener(estilo);
        
        // Coordinamos los JCheckBoxMenuItem con los JCheckBox 
        negrita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                negrita1.setSelected(negrita.isSelected());
            }
        });

        cursiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cursiva1.setSelected(cursiva.isSelected());
            }
        });

        negrita1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                negrita.setSelected(negrita1.isSelected());
            }
        });

        cursiva1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cursiva.setSelected(cursiva1.isSelected());
            }
        });

        // Añadimos la barra de información
        infoLabel = new JLabel();
        panel.add(infoLabel, BorderLayout.SOUTH);
        actualizarInfoLabel(texto);

        // Añadimos un DocumentListener para actualizar la barra de información cuando el texto cambia
        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarInfoLabel(texto);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarInfoLabel(texto);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarInfoLabel(texto);
            }
        });

        spiner.setSize(100, 100);
        scroll.setVisible(true);
        panel.setVisible(true);
        setJMenuBar(menuBar);
        menuBar.setVisible(true);
        this.setSize(600, 600);
        
        setTitle("mi ventana");
        setLocation(100, 200);    
        setVisible(true);
        setSize(800, 500);
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int respuesta = JOptionPane.showConfirmDialog(null, "Desea guardar este archivo");
				
				switch (respuesta) {
				case 0:
					saveFile(texto);
					break;
				case 1 :
					System.exit(0);
					break;
				case 2: 
					
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    //Creamos el metodo que ira actualizando la barra de informacion y lo configuramos 
    private void actualizarInfoLabel(JTextArea texto) {
        String estilo = "";
        if (texto.getFont().isBold()) {
            estilo += "Negrita ";
        }
        if (texto.getFont().isItalic()) {
            estilo += "Cursiva ";
        } else if (texto.getFont().isBold() && texto.getFont().isItalic()) {
        	estilo += " Negrita y Cursiva ";
        }
        String tipoLetra = texto.getFont().getFontName();
        int palabras = texto.getText().split("\\s+").length;
        int caracteres = texto.getText().length();
        infoLabel.setText(String.format("Estilo: %s | Tipo de letra: %s | Palabras: %d | Caracteres: %d", estilo, tipoLetra, palabras, caracteres));
    }
    
    private void openFile(JTextArea texto) {
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (.txt)" , "txt"));
    	
    	
    	int result = fileChooser.showOpenDialog(this);
    	
    	if (result == JFileChooser.APPROVE_OPTION) {
    		File selectedFile = fileChooser.getSelectedFile();
    		try(BufferedReader reader = new BufferedReader(new FileReader(selectedFile))){
    			texto.read(reader,null);
    			System.out.println("Archivo abierto: " + selectedFile.getAbsolutePath());
    		} catch (IOException ex) {
    			ex.printStackTrace();
    			JOptionPane.showMessageDialog(this, "Error al abrir el archivo" , "Error" , JOptionPane.ERROR_MESSAGE);
    		}
    	}
    
    
    }
    
    private void saveFile(JTextArea texto) {
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (.txt)" , "txt"));
    	
		int result = fileChooser.showSaveDialog(this);
		    	
		    	if (result == JFileChooser.APPROVE_OPTION) {
		    		File fileToSave = fileChooser.getSelectedFile();
		    		
		    		if(!fileToSave.getName().endsWith(".txt")) {
		    			fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
		    		}
		    		
		    		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))){
		    			texto.write(writer);
		    			System.out.println("Archivo guardado: " + fileToSave.getAbsolutePath());
		    		} catch (IOException ex) {
		    			ex.printStackTrace();
		    			JOptionPane.showMessageDialog(this, "Error al guardar el archivo" , "Error" , JOptionPane.ERROR_MESSAGE);
		    		}
		    			
		    	}
		    	
		    	
    	
    }
    
    
    
    
    

    public static void main(String[] args) {
        ventana window = new ventana();
    }
}
