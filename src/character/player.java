package character;

import javax.swing.*;

import layout.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class player extends Character{
	public player(Controller controller){
		super(controller);
		this.symbol = "0";
		remote();
	}

	void remote(){
		this.getController().getLayout().addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent keyEvent) {

			}

			public void keyPressed(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				switch (keyCode){
					case KeyEvent.VK_UP:
					try {
						move(Moving.up);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//character.move(Moving.up);
						break;
					case KeyEvent.VK_DOWN:
					try {
						move(Moving.down);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//character.move(Moving.down);
						break;
					case KeyEvent.VK_LEFT:
					try {
						move(Moving.left);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//character.move(Moving.left);
						break;
					case KeyEvent.VK_RIGHT :
					try {
						move(Moving.right);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//character.move(Moving.right);
						break;
				}
			}

			public void keyReleased(KeyEvent keyEvent) {}
		});
		this.getController().getLayout().setFocusable(true);
	}

}
