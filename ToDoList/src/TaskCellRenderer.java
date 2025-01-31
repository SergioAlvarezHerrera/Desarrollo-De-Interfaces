import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class TaskCellRenderer extends JPanel implements  ListCellRenderer<Tarea>  {
	private JLabel nombreLabel;
    private JLabel prioridadLabel;
    
    public TaskCellRenderer() {
        setLayout(new BorderLayout());
        nombreLabel = new JLabel();
        prioridadLabel = new JLabel();
        add(nombreLabel, BorderLayout.CENTER);
        add(prioridadLabel, BorderLayout.EAST);
    }

  

	@Override
	public Component getListCellRendererComponent(JList<? extends Tarea> list, Tarea value, int index,
			boolean isSelected, boolean cellHasFocus) {
		 nombreLabel.setText(value.getNombre());
	        
	  
	        switch (value.getPrioridad()) {
	            case "alta":
	                prioridadLabel.setIcon(new ImageIcon("Lib/alta.jpg"));
	                break;
	            case "media":
	                prioridadLabel.setIcon(new ImageIcon("Lib/medio.jpg"));
	                break;
	            case "baja":
	                prioridadLabel.setIcon(new ImageIcon("Lib/bajo.jpg"));
	                break;
	        }

	 
	        if (value.isCompletada()) {
	            setBackground(Color.LIGHT_GRAY);
	        } else {
	            setBackground(Color.WHITE);
	        }

	        return this;
	}

	
}
