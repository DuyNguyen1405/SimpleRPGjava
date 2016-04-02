/**
 * Created by j on 14/03/2016.
 */
abstract class Character {
    protected String name;
    protected int hp;
    protected int mp;
    //Position position; //++++++++++++++++++++++

    public Character(String name) {
        this.name = name;
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

    public abstract void die();
}

interface Move {
    public int up(int value);
    public int down(int value);
    public int left(int value);
    public int right(int value);
}