package layout;

import character.Character;
import character.Monster;
import character.move.Coordinate;
import character.move.Position;
import character.player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Layout extends JFrame {
	private Container controls;
	private player player;
	private Map map;
	private JLabel hpLabel;
	private JLabel mpLabel;
	
	public JLabel getHpLabel() {
		return hpLabel;
	}

	public JLabel getMpLabel() {
		return mpLabel;
	}

	public Layout() throws IOException {
		this.controls = new Container();
		this.map = new Map("M1.txt"); //khoi tao map
		this.player = new player("Kien", 1000, 500, new Position(4, 0));
		hpLabel = new JLabel("HP: " +this.getPlayer().getHp());
		mpLabel = new JLabel("MP: " +this.getPlayer().getMp());
	}

	
	public player getPlayer() {
		return player;
	}

	public void setPlayer(player player){
		this.player = player;
	}

	public Character getCharacterAt(Coordinate coo){
		if ((this.player.getController().getPosition().getX() == coo.getX()) && (this.player.getController().getPosition().getY() == coo.getY())){
			return this.player;
		}

		ArrayList monsters = this.map.getMonsters();
		for (int i = 0; i < monsters.size(); i++){
			Monster monster = (Monster) monsters.get(i);
			if ((monster.getController().getPosition().getX() == coo.getX()) && (monster.getController().getPosition().getY() == coo.getY())){
				return monster;
			}
		}
		return null;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	public void addComponentsToPane(final Container pane, Layout layout) throws IOException, InterruptedException {

		JButton b = new JButton("zxczxczxczxc");
		Dimension buttonSize = b.getPreferredSize();
		controls.setPreferredSize(new Dimension((int)(buttonSize.getWidth())+350,(int)(buttonSize.getHeight())+150));
		JLabel label1 = new JLabel("Bam a de xem huong dan");


		controls.add(label1);
		controls.add(hpLabel);
		controls.add(mpLabel);

		label1.setBounds(50, 80, 30, 30);
		label1.setSize(150, 100);
		
		hpLabel.setBounds(250,80, 30, 30);
		hpLabel.setSize(50, 100);
		mpLabel.setBounds(250,100, 30, 30);
		mpLabel.setSize(50, 100);
		Insets insets = pane.getInsets();

		// Add map vao layout
		pane.add(map.getTable());
		//pane.remove(map.getTable());
		//map.getTable().setSize(150, 80);
		buttonSize = map.getTable().getPreferredSize();
		map.getTable().setBounds(insets.left,insets.bottom, 450, this.getMap().getMaxX()*16);

		//Add controls
		pane.add(controls);
	}

	private static void createAndShowGUI() throws IOException, InterruptedException {
		//Create and set up the window.
		Game.init();
		Game.start();
		Layout frame = (Layout) Game.get("layout");
		frame.setTitle("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane(),frame);
		frame.setSize(1500,700);
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
	}
}


