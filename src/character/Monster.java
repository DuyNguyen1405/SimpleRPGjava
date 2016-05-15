package character;

import character.move.Coordinate;
import character.move.Moving;
import character.move.Position;
import exception.AttackException;
import exception.EndGameException;
import exception.NewMapException;
import layout.Game;
import layout.Map;

import java.io.IOException;

/**
 * Created by j on 09/04/2016.
 */
public class Monster extends Character{
    private Coordinate coo;
    private int speed;

    public Monster (String name, String symbol, int hp, Position position, Coordinate coo, int speed){
        super(name, symbol, hp, 0, position);
        this.speed = speed;
        this.coo = coo;
    }

    private void turnAround(){
        if (coo == Moving.right) {
            coo = Moving.left;
        } else if (coo == Moving.left) {
            coo = Moving.right;
        } else if (coo == Moving.up){
            coo = Moving.down;
        } else {
            coo = Moving.up;
        }
    }

    @Override
    public void run() {
        while (this.isAlive){
            try {
                Thread.sleep(this.speed);
                if (move(coo) >= 0) {
                    //continue;
                } else {
                    turnAround();
                }
            } catch (InterruptedException e) {
                try {
                    if (isAlive){
                        Thread.sleep(2000);
                        System.out.println();
                        System.out.println("... Frozen Time: " + this.name + " activated");
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            } catch (AttackException e) {
                if (e.getEnemy() instanceof Player){
                    e.getEnemy().gotHit(this, e.getDamage());
                }
                if (e.getEnemy() instanceof Monster){
                    turnAround();
                }
            } catch (NewMapException e){
                turnAround();
            } catch (EndGameException e){
                turnAround();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (! this.isAlive) {
            Map map = (Map) Game.get("map");
            map.removeMonster(this);
        }
    }
}
