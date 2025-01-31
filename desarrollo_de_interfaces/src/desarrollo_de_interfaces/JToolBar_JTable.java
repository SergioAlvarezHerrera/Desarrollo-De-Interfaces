package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class JToolBar_JTable extends JFrame {

	public JToolBar_JTable() throws HeadlessException {
		// TODO Auto-generated constructor stub
		
		
		JToolBar toolBar = new JToolBar();
		add(toolBar);
		
		JButton boton1 = new JButton("Nuevo");
		JButton boton2 = new JButton("Abrir");
		JButton boton3 = new JButton("Guardar");
		
		toolBar.add(boton1);
		toolBar.add(boton2);
		toolBar.add(boton3);
		
		toolBar.addSeparator();
		
		JButton boton4 = new JButton("salir");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		toolBar.add(boton4);
		
		String[][] datos = {
		{"1", "sergio", "20"},
		{"2" , "Alvaro" , "19"},
		{"3" , "Ivan" , "19"},
		{"4" , "Carlos" , "20"},
		{"5" , "Gonzalo" , "19"},
		{"6" , "Joaquin" , "20"},
		{"7" , "Jorge" , "19"},
		{"8" , "Cuenca" , "20"},
			
		};
		
		String [] columnas = {"ID", "Nombre" , "Edad"};
		
		JTable table = new JTable(datos , columnas);
		
		JScrollPane scrolPane = new JScrollPane(table);
		add(scrolPane, BorderLayout.CENTER);
		
		
		
		
		add(toolBar ,BorderLayout.NORTH);
		
		setVisible(true);
		setSize(400,400);
		
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JToolBar_JTable añade = new  JToolBar_JTable();
	}

}
