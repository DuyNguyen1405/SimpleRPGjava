package Character.Skill;

import Character.Monster;
import Layout.Resource;

import java.util.ArrayList;

public class FrozenTimeSkill extends Skill{

    public FrozenTimeSkill(String name, int cost, int attack, int defence) {
        super(name, cost, attack, defence);
    }

    @Override
    public void affect() throws Exception{
        ArrayList monsters = (ArrayList) Resource.get("monsters");
        int i;

        System.out.println("+++ Frozen Time activated: all monsters will be frozen in ---> 2s");
        for (i = 0; i < monsters.size(); i++){
            Monster monster = (Monster) monsters.get(i);
            monster.getThread().interrupt();
        }
    }
}
