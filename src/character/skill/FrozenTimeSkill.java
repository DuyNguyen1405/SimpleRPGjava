package character.skill;

import character.Monster;
import layout.Resource;

import java.util.ArrayList;

public class FrozenTimeSkill extends Skill{

    public FrozenTimeSkill(String name, int cost) {
        super(name, cost);
    }

    @Override
    public void affect() throws Exception{
        ArrayList monsters = (ArrayList) Resource.get("monsters");
        int i;

        for (i = 0; i < monsters.size(); i++){
            Monster monster = (Monster) monsters.get(i);
            monster.getThread().interrupt();
        }
    }
}
