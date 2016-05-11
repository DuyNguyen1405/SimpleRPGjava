package character;

import layout.Controller;
import layout.Layout;
import layout.Map;

import java.io.IOException;

import javax.naming.ldap.Control;
import javax.swing.*;

/**
 * Created by j on 03/04/2016.
 */
public abstract class Character{
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected Controller controller;

    abstract void remote();
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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    //    public void move(Coordinate coordinate){
//
//        //Set gia tri cu vao vi tri hien tai cua player
//        layout.getMap().getTable().setValueAt(this.position.getSymbol(), this.position.getX(), this.position.getY());
//
//        // Set lai x, y
//        this.position.setX(this.position.getX() + coordinate.getX());
//        this.position.setY(this.position.getY() + coordinate.getY());
//
//        // Set gia tri moi cua o player de len
//        this.position.setSymbol((String) this.layout.getMap().getTable().getValueAt(this.position.getX(), this.position.getY()));
//
//        // Set gia tri moi o table tai vi tri player
//        layout.getMap().getTable().setValueAt(this.symbol, this.position.getX(), this.position.getY());
//    }

    public boolean move(Coordinate coordinate) throws IOException{
        return this.controller.move(coordinate, this.symbol);
    }

    public void draw(){
        this.controller.draw(this.symbol);
    }
}
