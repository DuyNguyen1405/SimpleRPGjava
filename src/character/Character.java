package character;

import character.move.Coordinate;
import character.move.Position;
import exception.AttackException;
import layout.Layout;
import layout.Resource;

import java.io.IOException;
/**
 * Created by j on 03/04/2016.
 */
public abstract class Character implements Runnable{
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected int point;
    protected Controller controller;
    protected Boolean isAlive;

    public Character(String name, int hp, int mp, int point, Position position){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.point = point;
        this.controller = new Controller(position);

        Thread controlThread = new Thread(this);
        this.controller.setThread(controlThread);
    }

    public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void adjustHp(int value){
        this.hp += value;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void gotHit(Character enemy, int damage){
        this.hp -= damage;

        System.out.println(enemy.getName() + " hits " + this.name + ": " + damage);
        if (this.hp <= 0){
            die();
        }
    }

    public void die(){

    }

    public Controller getController() {
        return controller;
    }

    public boolean move(Coordinate coordinate) throws IOException, AttackException {
        return this.controller.move(coordinate, this.symbol);
    }

    public void draw(){
        this.controller.draw(this.symbol);
    }
	public abstract void run();

    public Thread getThread(){
        return this.controller.getThread();
    }

    public void setThread(Thread thread){
        this.controller.setThread(thread);
    }

    public void activate(){
        this.controller.setLayout((Layout) Resource.get("layout"));
        draw();
        this.controller.getThread().start();
    }
}
