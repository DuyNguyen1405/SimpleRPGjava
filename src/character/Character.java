package character;

import character.move.Coordinate;
import character.move.Position;
import exception.AttackException;

import java.io.IOException;
/**
 * Created by j on 03/04/2016.
 */
public class Character implements Runnable{
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected Controller controller;

    public Character(){
        this.name = "KiDu";
        this.hp = 1000;
        this.mp = 500;
        this.symbol = "U";
        //this.position = new Position(4, 0);
    }

    public Character(Position position){
        this.name = "KiDu";
        this.hp = 1000;
        this.mp = 500;
        this.symbol = "O";
    }

    public Character(Controller controller){
        this.controller = controller;
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

    public String getSymbol() {
        return symbol;
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
	public void run() {

	}

    public Thread getThread(){
        return this.controller.getThread();
    }

    public void setThread(Thread thread){
        this.controller.setThread(thread);
    }
}
