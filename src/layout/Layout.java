package layout;

import character.Character;
import character.Monster;
import character.Player;
import character.move.Coordinate;
import character.move.Position;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Layout extends JFrame {
	private Container controls;
	private Player player;
	private Map map;
	private JLabel hpLabel;
	private JLabel mpLabel;
	private JLabel pLabel;
	
	public JLabel getHpLabel() {
		return hpLabel;
	}

	public JLabel getMpLabel() {
		return mpLabel;
	}

	public JLabel getpLabel() {
		return pLabel;
	}

	public Layout() throws IOException {
		this.controls = new Container();
		this.map = new Map("M1.txt"); //khoi tao map
		this.player = new Player("Kien", 1000, 500, new Position(4, 4));
		hpLabel = new JLabel("HP: " +this.getPlayer().getHp());
		mpLabel = new JLabel("MP: " +this.getPlayer().getMp());
		pLabel = new JLabel("Point: " +this.getPlayer().getPoint());
	}

	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player){
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

	public void addComponentsToPane(final Container pane, Layout layout) throws IOException, InterruptedException {

		JButton b = new JButton("zxczxczxczxc");
		Dimension buttonSize = b.getPreferredSize();
		controls.setPreferredSize(new Dimension((int)(buttonSize.getWidth())+350,(int)(buttonSize.getHeight())+150));
		JLabel label1 = new JLabel("Bam a de xem huong dan");


		controls.add(label1);
		controls.add(hpLabel);
		controls.add(mpLabel);
		controls.add(pLabel);

		label1.setBounds(50, 120, 20, 20);
		label1.setSize(150, 20);
		
		hpLabel.setBounds(250,120, 20, 20);
		hpLabel.setSize(70, 20);
		mpLabel.setBounds(250,140, 20, 20);
		mpLabel.setSize(70, 20);
		pLabel.setBounds(330, 120,20, 20);
		pLabel.setSize(70, 20);
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


