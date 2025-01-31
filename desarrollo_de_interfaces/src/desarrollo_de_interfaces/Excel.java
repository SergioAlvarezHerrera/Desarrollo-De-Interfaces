package desarrollo_de_interfaces;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Excel extends JFrame {

	public Excel() throws HeadlessException {
		// TODO Auto-generated constructor stub
		
		JPanel panel = new JPanel(new BorderLayout());
		setContentPane(panel);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar , BorderLayout.NORTH );
		
		JMenu archivo =  new JMenu("Archivo");
		menuBar.add(archivo);
		
		JMenuItem Salir = new JMenuItem("Salir");
		archivo.add(Salir);
		
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		JMenu Editar = new JMenu("Editar");
		menuBar.add(Editar);
		
		JMenuItem agregarF= new JMenuItem("Agregar Fila");
		Editar.add(agregarF);
		
		
		JMenuItem agregarC = new JMenuItem("Agregar Columna");
		Editar.add(agregarC);
		
		JMenuItem eliminarF = new JMenuItem("Eliminar Fila");
		Editar.add(eliminarF);
		
		JMenuItem eliminarC = new JMenuItem("Eliminar Columna");
		Editar.add(eliminarC);
		
		DefaultTableModel modelo = new DefaultTableModel(20,5);
		JTable table = new JTable(modelo);
		
		
		JScrollPane scrol = new JScrollPane(table);
		panel.add(scrol , BorderLayout.CENTER);
		
		
		agregarF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.addRow( new Object [] {null});
				 
			}
		});
		
		agregarC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modelo.addColumn( "nuevaColumna");
			}
		});
		
		
		
		eliminarF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					modelo.removeRow(selectedRow);
				}else {
					JOptionPane.showMessageDialog(null, "seleccione una fila a eliminar");
				}
				
				
			}
		});
		
		eliminarC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedColumn = table.getSelectedColumn();
				
				if(selectedColumn != -1) {
					table.removeColumn(table.getColumnModel().getColumn(selectedColumn));
				}else {
					JOptionPane.showMessageDialog(null, "seleccione una Columna a eliminar");
				}
				
				
			}
		});
				
				setVisible(true);
				setSize(700,700);
}
	
		
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel excel = new Excel();
	}

}
