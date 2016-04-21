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
			@Override
			public void keyTyped(KeyEvent keyEvent) {

			}

			@Override
			public void keyPressed(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				switch (keyCode){
					case KeyEvent.VK_UP:
						move(Moving.up);
						//character.move(Moving.up);
						break;
					case KeyEvent.VK_DOWN:
						move(Moving.down);
						//character.move(Moving.down);
						break;
					case KeyEvent.VK_LEFT:
						move(Moving.left);
						//character.move(Moving.left);
						break;
					case KeyEvent.VK_RIGHT :
						move(Moving.right);
						//character.move(Moving.right);
						break;
				}
			}

			@Override
			public void keyReleased(KeyEvent keyEvent) {}
		});
		this.getController().getLayout().setFocusable(true);
	}

}
