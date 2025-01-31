package tema2;

import javax.swing.Icon;

public class ListItem {
	private String text;
	private Icon icon;
	
	public ListItem(String text, Icon icon) {
		this.text= text;
		this.icon=icon;
		
		
	}
	
	public String getText() {
		return text;
	}
	
	public Icon getIcon() {
		return icon;
		
	}
}
