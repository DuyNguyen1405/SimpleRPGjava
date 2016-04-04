package character;

import javax.swing.JTable;

import layout.*;

public class player extends Character{
	private Object oldValue;

	public player(String name, int hp, int mp, String symbol, Position position, Object oldValue) {
		super(name, hp, mp, symbol, position);
		this.oldValue = oldValue;
	}

	public player(){
		super();
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
