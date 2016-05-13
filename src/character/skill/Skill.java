package character.skill;

/**
 * Created by j on 12/05/2016.
 */
public abstract class Skill {
    private String name;
    private int cost;

    public Skill (String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public abstract void affect() throws Exception;
}

