package exception;

import character.skill.Skill;

/**
 * Created by j on 14/05/2016.
 */
public class NotEnoughMP extends Exception{
    private Skill skill;

    public NotEnoughMP (Skill skill){
        super();
        this.skill = skill;
    }
}
