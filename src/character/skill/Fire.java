package character.skill;

import character.Monster;
import character.move.Coordinate;
import character.move.Moving;
import character.player;
import layout.Resource;

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
    public void affect() throws Exception {
        player player = (player) Resource.get("player");
        ArrayList monsters = (ArrayList) Resource.get("monsters");

        if (direction == Moving.right){
            for (int i = 0; i < monsters.size(); i++){
                Monster monster = (Monster) monsters.get(i);
                if (player.getController().onSameRowRight(monster.getController().getPosition())){
                    monster.gotHit(player, this.getDamage());
                    System.out.println("--- Fire: " + monster.getName() + " got fired: lost " + this.getDamage() + " hp.");
                }
            }


        }

        if (direction == Moving.left){
            player.getController().draw("<");
            for (int i = 0; i < monsters.size(); i++){
                Monster monster = (Monster) monsters.get(i);
                if (player.getController().onSameRowLeft(monster.getController().getPosition())){
                    monster.adjustHp(-this.getDamage());
                    System.out.println("--- Fire: " + monster.getName() + " got fired: lost " + this.getDamage() + " hp.");
                }
            }
            player.getController().draw("O");
        }
    }
}
