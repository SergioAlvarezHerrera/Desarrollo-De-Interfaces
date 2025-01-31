package tema2;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ImageTextCellRenderer extends JPanel implements ListCellRenderer<ListItem>{
	private JLabel labelIcon;
	private JLabel labelText;
	
	public ImageTextCellRenderer() {
		setLayout(new BorderLayout(5,5));
		labelIcon = new JLabel();
		labelText = new JLabel();
		
		add(labelIcon, BorderLayout.WEST);
		add(labelIcon, BorderLayout.CENTER);
		
		
	}
	
	public Component getListCellRendererComponent(JList<? extends ListItem> list, ListItem value , int index ,
			boolean isSelected,
			boolean cellHasFocus) {
		labelIcon.setIcon(value.getIcon());
		labelText.setText(value.getText());
		
		if(isSelected) {
			setBackground(list.getSelectionBackground());
			labelText.setForeground(list.getSelectionForeground());
			
		}else {
			setBackground(list.getBackground());
			labelText.setForeground(list.getForeground());
		}

		setOpaque(true);
		return this;
		
		
	}
}
