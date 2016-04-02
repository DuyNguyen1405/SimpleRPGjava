package character;

import javax.swing.JTable;

import layout.*;

public class player {
	private int x;
	private int y;
	private Object oldValue;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}
	
	public Object storeOldValue(int x, int y,JTable table){
		oldValue = table.getValueAt(x, y);
		return oldValue;
	}
	
	public void makeChar(int x, int y, JTable table){
		oldValue = table.getValueAt(x, y);
		//System.out.println(oldValue);
		table.setValueAt("o", x, y);
		
	}
}
