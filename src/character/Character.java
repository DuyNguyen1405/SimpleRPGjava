package character;

import character.move.Coordinate;
import character.move.Position;
import exception.AttackException;
import layout.Layout;
import layout.Game;

import java.io.IOException;
/**
 * Created by j on 03/04/2016.
 */
public abstract class Character implements Runnable{
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected Controller controller;
    protected Boolean isAlive;

    public Character(String name, int hp, int mp, Position position){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.controller = new Controller(position);
        this.isAlive = true;

        Thread controlThread = new Thread(this);
        this.controller.setThread(controlThread);
    }

    public abstract void run();

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        this.isAlive = false;
        controller.getThread().interrupt();
        controller.reDraw();
        System.out.println(this.getName() + " die!");
    }

    public Controller getController() {
        return controller;
    }

    public int move(Coordinate coordinate) throws IOException, AttackException {
        return this.controller.move(coordinate, this.symbol);
    }

    public void draw(){
        this.controller.draw(this.symbol);
    }

    public Thread getThread(){
        return this.controller.getThread();
    }

    public void activate(){
        this.controller.setLayout((Layout) Game.get("layout"));
        draw();
        this.controller.getThread().start();
    }
}
