package exception;

import character.Character;

/**
 * Created by j on 11/05/2016.
 */
public class AttackException extends Exception{
    private Character enemy;
    public AttackException(){
        super("Attack");
    }

    public AttackException(Character enemy) {
        super("Attack");
        this.enemy = enemy;
    }
}
