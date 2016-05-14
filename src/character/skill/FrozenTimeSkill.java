package character.skill;

import character.Monster;
import exception.NotEnoughMP;
import layout.Game;

import java.util.ArrayList;

public class FrozenTimeSkill extends Skill{

    public FrozenTimeSkill(String name, int cost) {
        super(name, cost, 0);
    }

    @Override
    public void affect() throws NotEnoughMP{
        preAffect();

        ArrayList monsters = (ArrayList) Game.get("monsters");
        int i;

        System.out.println("+++ Frozen Time activated: all monsters will be frozen in ---> 2s");
        for (i = 0; i < monsters.size(); i++){
            Monster monster = (Monster) monsters.get(i);
            monster.getThread().interrupt();
        }
    }
}
