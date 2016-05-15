package character;

import character.move.Moving;
import character.move.Position;
import character.skill.Fire;
import character.skill.FrozenTimeSkill;
import character.skill.Skill;
import exception.AttackException;
import exception.NotEnoughMP;
import layout.Game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Character{
	private Skill[] skills;
	private int point;

	public Player(String name, int hp, int mp, Position position){
		super(name, hp, mp, position);
		this.symbol = "O";
		this.skills = new Skill[3];
		skills[0] = new FrozenTimeSkill("FrozenTime", 200);
		skills[1] = new Fire("Lazer Fire", 50, 500, Moving.left);
		skills[2] = new Fire("Lazer Fire", 50, 500, Moving.right);
	}

	public int getPoint() {
		return point;
	}

	public void incPoint(int point){
		this.point += point;
	}

	private void update(){
		JLabel hpLabel = (JLabel) Game.get("hplabel");
		hpLabel.setText("HP: " + String.valueOf(this.hp));

		JLabel mpLabel = (JLabel) Game.get("mplabel");
		mpLabel.setText(String.valueOf(this.mp));

		JLabel pLabel = (JLabel) Game.get("plabel");
		pLabel.setText(String.valueOf(this.point));
	}

	private void updateInterval(){
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				update();
			}
		};

		timer.schedule(timerTask, 0, 100);
	}

	private void doSkill(Skill skill){
		try {
			skill.affect();
		} catch (NotEnoughMP e){
			System.out.println("-- Not enough mana!");
		}
	}



	public void run(){
		KeyListener playerCommand = new KeyListener() {
			public void keyTyped(KeyEvent keyEvent) {}

			public void keyPressed(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				int point = 0;
				try {
					switch (keyCode){
						case KeyEvent.VK_UP:
							try {
								point = move(Moving.up);
								if (point >  0){
									incPoint(point);
									System.out.println("Got a point");
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_DOWN:
							try {
								point = move(Moving.down);
								if (point >  0){
									incPoint(point);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_LEFT:
							try {
								point = move(Moving.left);
								if (point >  0){
									incPoint(point);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_RIGHT :
							try {
								point = move(Moving.right);
								if (point >  0){
									incPoint(point);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_SPACE :
							try {
								doSkill(skills[0]);
							} catch (Exception e){

							}
							break;
						case KeyEvent.VK_Z :
							try {
								Player.this.getController().draw("<");
								doSkill(skills[1]);
							} catch (Exception e){

							}
							break;
						case KeyEvent.VK_X :
							try {
								Player.this.getController().draw(">");
								doSkill(skills[2]);
							} catch (Exception e){

							}
							break;
						case KeyEvent.VK_S :
							JOptionPane.showMessageDialog (null, "Thong tin nhan vat:"
											+ "\nHP:" + getHp()
											+ "\nMP:" + getMp()
											+ "\nThong tin ve ki nang:"
											+ "\nSpace: Dung thoi gian - Quai vat dung im trong 2s"
											+ "\nZ, X: Ban phep - Gay sat thuong len quai vat"
									,"Huong Dan", JOptionPane.INFORMATION_MESSAGE);
							break;
						case KeyEvent.VK_A :
							JOptionPane.showMessageDialog (null, "Nut bam:\n+ Bam ^, v, <, > de di chuyen."
											+ "\n+ Bam z, x, space de dung ki nang."
											+ "\n+ Bam s de xem thong tin nhan vat."
											+ "\n\nCach choi:"
											+ "\n+ De ve dich phai di chuyen den o End"
											+ "\n+ Va cham voi quai vat se mat mau. Neu mau ve 0 tro choi se ket thuc."
											+ "\n+ Vao nhung o M1, M2 se doi sang map moi."

									,"Huong Dan", JOptionPane.INFORMATION_MESSAGE);

							break;
					}
				} catch (AttackException e){
					Player.this.gotHit(e.getEnemy(), e.getDamage());
				}
			}

			public void keyReleased(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				switch (keyCode){
					case KeyEvent.VK_SPACE :
						break;
					case KeyEvent.VK_Z :
						try {
							Player.this.getController().draw("O");
						} catch (Exception e){

						}
						break;
					case KeyEvent.VK_X :
						try {
							Player.this.getController().draw("O");
						} catch (Exception e){

						}
						break;
				}
			}
		};

		this.getController().getLayout().addKeyListener(playerCommand);
		this.getController().getLayout().setFocusable(true);

		if (isAlive){
			updateInterval();
		}

		if (! isAlive){
			System.out.println("Player die");
			this.getController().getLayout().removeKeyListener(playerCommand);
			Game.end();
		}
	}
}
