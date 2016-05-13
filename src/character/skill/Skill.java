package character.skill;

/**
 * Created by j on 12/05/2016.
 */
public abstract class Skill {
    private String name;
    private int cost;
    private int attack;
    private int defence;

    public Skill (String name, int cost, int attack, int defence){
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public abstract void affect() throws Exception;
}

