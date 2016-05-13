package character;

import character.move.Moving;
import character.skill.FrozenTimeSkill;
import character.skill.Skill;
import exception.AttackException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class player extends Character{
	private Skill[] skills;

	public player(Controller controller){
		super(controller);
		this.hp = 1000;
		this.symbol = "0";
		this.skills = new Skill[2];
		skills[0] = new FrozenTimeSkill("fireBall", 50);
		remote();
	}

	public void fight() throws IOException{
		this.setHp(getHp()-500);
		System.out.println(this.getHp());
		if(this.getHp() <= 0) controller.endMap();
	}

	void remote(){
		this.getController().getLayout().addKeyListener(new KeyListener() {
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
						case KeyEvent.VK_Z :
							try {
								doSkill(skills[0]);
							} catch (Exception e){

							}
							break;
						case KeyEvent.VK_X :
							try {
								doSkill(skills[1]);
							} catch (Exception e){

							}
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

			public void keyReleased(KeyEvent keyEvent) {}
		});
		this.getController().getLayout().setFocusable(true);
		
    	this.getController().getLayout().getUp().addActionListener(new ActionListener() {
    	      public void actionPerformed(ActionEvent e)  {
    	    	  try {
    				move(Moving.up);
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			} catch (AttackException e1) {
    				e1.printStackTrace();
    			}
    	      }
    	  });
    	this.getController().getLayout().getDown().addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e)  {
  	    	  try {
  				move(Moving.down);

  			} catch (IOException e1) {
  				e1.printStackTrace();
  			} catch (AttackException e1) {
  				e1.printStackTrace();
  			}
  	      }
  	  });
    	this.getController().getLayout().getLeft().addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e)  {
  	    	  try {
  				move(Moving.left);
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			} catch (AttackException e1) {
  				e1.printStackTrace();
  			}
  	      }
  	  });
    	this.getController().getLayout().getRight().addActionListener(new ActionListener() {
  	      public void actionPerformed(ActionEvent e)  {
  	    	  try {
  				move(Moving.right);
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			} catch (AttackException e1) {
  				e1.printStackTrace();
  			}
  	      }
  	  });
    	
    	
	}

	private void doSkill(Skill skill){
		System.out.println(skill.getName());
		try {
			skill.affect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run(){

	}
}
