package character;

import layout.Controller;
import layout.Layout;
import layout.Map;

import javax.naming.ldap.Control;
import javax.swing.*;

/**
 * Created by j on 03/04/2016.
 */
public class Character {
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected Position position;
    protected Controller controller;
    protected Layout layout;

    public Character(){
        this.name = "KiDu";
        this.hp = 1000;
        this.mp = 500;
        this.symbol = "O";
        this.position = new Position(4, 0);
    }

    public Character(Layout layout){
        this.name = "KiDu";
        this.hp = 1000;
        this.mp = 500;
        this.symbol = "O";
        this.position = new Position(4, 0);
        this.layout = layout;
//        this.controller = new Controller(layout, this.position);
//        this.controller.press();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Coordinate coordinate){

        //Set gia tri cu vao vi tri hien tai cua player
        layout.getMap().getTable().setValueAt(this.position.getSymbol(), this.position.getX(), this.position.getY());

        // Set lai x, y
        this.position.setX(this.position.getX() + coordinate.getX());
        this.position.setY(this.position.getY() + coordinate.getY());

        // Set gia tri moi cua o player de len
        this.position.setSymbol((String) this.layout.getMap().getTable().getValueAt(this.position.getX(), this.position.getY()));

        // Set gia tri moi o table tai vi tri player
        layout.getMap().getTable().setValueAt(this.symbol, this.position.getX(), this.position.getY());
    }

    public void draw(Map map){
        this.position.setSymbol((String) map.getTable().getValueAt(this.position.getX(), this.position.getY()));
        map.getTable().setValueAt(this.symbol, this.position.getX(), this.position.getY());
    }
}
