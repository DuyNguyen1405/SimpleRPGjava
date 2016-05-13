package Character.Skill;

import Character.Monster;
import Character.Move.Coordinate;
import Character.Move.Moving;
import Character.player;
import Layout.Resource;

import java.util.ArrayList;

/**
 * Created by j on 13/05/2016.
 */
public class Fire extends Skill{
    private Coordinate direction;

    public Fire(String name, int cost, int attack, int defence, Coordinate coo) {
        super(name, cost, attack, defence);
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
                    monster.adjustHp(this.getAttack());
                    System.out.println("--- Fire: " + monster.getName() + " got fired: lost " + this.getAttack() + " hp.");
                }
            }


        }

        if (direction == Moving.left){
            player.getController().draw("<");
            for (int i = 0; i < monsters.size(); i++){
                Monster monster = (Monster) monsters.get(i);
                if (player.getController().onSameRowLeft(monster.getController().getPosition())){
                    monster.adjustHp(this.getAttack());
                    System.out.println("--- Fire: " + monster.getName() + " got fired: lost " + this.getAttack() + " hp.");
                }
            }
            player.getController().draw("O");
        }
    }
}
