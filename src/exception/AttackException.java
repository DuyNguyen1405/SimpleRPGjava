package exception;

import character.Character;

/**
 * Created by j on 11/05/2016.
 */
public class AttackException extends Exception{
    private Character enemy;
    private final int damage = 100;

    public AttackException(Character enemy) {
        super("Attack");
        this.enemy = enemy;
    }

    public Character getEnemy() {
        return enemy;
    }
    public int getDamage(){return damage;}
}
