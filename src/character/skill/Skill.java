package character.skill;

/**
 * Created by j on 12/05/2016.
 */
public abstract class Skill {
    private String name;
    private int cost;
    private int damage;

    public Skill (String name, int cost, int damage){
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public abstract void affect() throws Exception;
}

