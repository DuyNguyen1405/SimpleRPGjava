package character;

import character.move.Moving;
import character.move.Position;
import character.skill.Fire;
import character.skill.FrozenTimeSkill;
import character.skill.Skill;
import exception.AttackException;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class player extends Character{
	private Skill[] skills;

	public player(String name, int hp, int mp, Position position){
		super(name, hp, mp, position);
		this.symbol = "O";

		this.skills = new Skill[3];
		skills[0] = new FrozenTimeSkill("FrozenTime", 200);
		skills[1] = new Fire("Lazer Fire", 50, 500, Moving.left);
		skills[2] = new Fire("Lazer Fire", 50, 500, Moving.right);
		//remote();
	}

	public void fight() throws IOException{
		this.setHp(getHp()-500);
		this.getController().getLayout().getHpLabel().setText("HP: " +this.getHp());
		System.out.println(this.getHp());
		if(this.getHp() <= 0) controller.endMap();
	}

	private boolean doSkill(Skill skill){
		System.out.println(skill.getName());
		try {
<<<<<<< Updated upstream
			if((this.getMp()-skill.getCost())<0) {
				JOptionPane.showMessageDialog (null, "Khong du MP","Thong bao", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			this.setMp(this.getMp()-skill.getCost());
			this.getController().getLayout().getMpLabel().setText("MP: " +this.getMp());
=======
			this.setMp(this.getMp()-skill.getCost());
			if(this.getMp()<0) {
				JOptionPane.showMessageDialog (null, "Khong du MP"


						,"Thong bao", JOptionPane.ERROR_MESSAGE);
				return false;
			}

>>>>>>> Stashed changes
			skill.affect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void run(){
		KeyListener playerCommand = new KeyListener() {
			public void keyTyped(KeyEvent keyEvent) {

			}

			public void keyPressed(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				try {
					switch (keyCode){
						case KeyEvent.VK_UP:
							try {
								move(Moving.up);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_DOWN:
							try {
								move(Moving.down);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_LEFT:
							try {
								move(Moving.left);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case KeyEvent.VK_RIGHT :
							try {
								move(Moving.right);
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
								player.this.getController().draw("<");
								doSkill(skills[1]);
							} catch (Exception e){

							}
							break;
						case KeyEvent.VK_X :
							try {
								player.this.getController().draw(">");
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
					try {
						fight();
						//TODO player cham monster, chi attack 1 lan duy nhat !!
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//System.out.println("Attack!");
				}
			}

			public void keyReleased(KeyEvent keyEvent) {
				int keyCode = keyEvent.getKeyCode();
				switch (keyCode){
					case KeyEvent.VK_SPACE :
						try {
						} catch (Exception e){

						}
						break;
					case KeyEvent.VK_Z :
						try {
							player.this.getController().draw("O");
						} catch (Exception e){

						}
						break;
					case KeyEvent.VK_X :
						try {
							player.this.getController().draw("O");
						} catch (Exception e){

						}
						break;
				}
			}
		};

		this.getController().getLayout().addKeyListener(playerCommand);
		this.getController().getLayout().setFocusable(true);

	}
}
