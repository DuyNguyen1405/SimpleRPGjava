package character;

import character.move.Coordinate;
import character.move.Position;
import exception.AttackException;
import exception.EndGameException;
import exception.NewMapException;
import layout.Game;
import layout.Layout;
import layout.Map;

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

    public Character(String name, String symbol, int hp, int mp, Position position){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.symbol = symbol;
        this.controller = new Controller(position);
        this.isAlive = true;

        Thread controlThread = new Thread(this);
        this.controller.setThread(controlThread);
    }

    public abstract void run();

    public void activate(){
        draw();
        this.controller.getThread().start();
    }

    public int move(Coordinate coordinate) throws IOException, AttackException, EndGameException, NewMapException {
        return this.controller.move(coordinate, this.symbol);
    }

    public void draw(){
        this.controller.draw(this.symbol);
    }

    public void gotHit(Character enemy, int damage){
        this.hp -= damage;

        System.out.println();
        System.out.println(enemy.getName() + " hits " + this.name + ": " + damage);
        if (this.hp <= 0){
            die();
        }
    }

    public void die(){
        this.isAlive = false;
        controller.getThread().interrupt();
        controller.reDraw();
        if (this instanceof Monster){
            Map map = (Map) Game.get("map");
            map.removeMonster((Monster) this);
        }
        if (this instanceof Player){
            Layout layout = (Layout) Game.get("layout");
            layout.removeKeyListener(layout.getPlayerCommand());
            if (Game.over){
                Game.end();
            }
        }
        System.out.println();
        System.out.println(this.getName() + " die!");
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getMp() {
        return mp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
    public void setPosition(int x, int y){
        this.controller.setPosition(x, y);
    }
    public Controller getController() {
        return controller;
    }
    public Thread getThread(){
        return this.controller.getThread();
    }
}
