package character.skill;

import character.Monster;
import character.Player;
import character.move.Coordinate;
import exception.NotEnoughMP;
import layout.Game;

import java.util.ArrayList;

/**
 * Created by j on 13/05/2016.
 */
public class Fire extends Skill{
    private Coordinate direction;

    public Fire(String name, int cost, int damage, Coordinate coo) {
        super(name, cost, damage);
        this.direction = coo;
    }

    @Override
    public void affect() throws NotEnoughMP {
        preAffect();

        Player player = (Player) Game.get("Player");
        ArrayList monsters = (ArrayList) Game.get("monsters");

        for (int i = 0; i < monsters.size(); i++){
            Monster monster = (Monster) monsters.get(i);
            if (player.getController().onSameRow(monster.getController().getPosition(), direction)){
                monster.gotHit(player, this.getDamage());
            }
        }
    }
}
