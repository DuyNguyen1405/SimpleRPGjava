package character;

/**
 * Created by j on 03/04/2016.
 */
public class Character {
    protected String name;
    protected int hp;
    protected int mp;
    protected String symbol;
    protected Position position;

    public Character(){
        this.name = "KiDu";
        this.hp = 1000;
        this.mp = 500;
        this.symbol = "O";
        this.position = new Position(4, 0);
    }

    public Character(String name, int hp, int mp, String symbol, Position position) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.symbol = symbol;
        this.position = position;
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


}
