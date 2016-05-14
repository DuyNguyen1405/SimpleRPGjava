package character.skill;

import character.Player;
import exception.NotEnoughMP;
import layout.Game;

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

    public int getDamage() {
        return damage;
    }

    protected void preAffect() throws NotEnoughMP {
        Player player = (Player) Game.get("Player");
        if (player.getMp() - this.cost < 0){
            throw new NotEnoughMP(this);
        } else {
            player.setMp(player.getMp() - this.cost);
            System.out.println(this.name + " - " + this.cost + " mp");
        }
    }

    public abstract void affect() throws NotEnoughMP;
}

