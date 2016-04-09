package character;

import javax.swing.*;

import layout.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class player extends Character{
	private Object oldValue;
	//private Controller controller;

	public player(String name, int hp, int mp, String symbol, Position position, Object oldValue) {
		super(name, hp, mp, symbol, position);
		this.oldValue = oldValue;
	}

	public player(){
		super();
	}

	public player(Layout layout) {
		super(layout);
	}

	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}
}
