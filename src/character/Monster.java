package character;

import character.move.Coordinate;
import character.move.Moving;
import character.move.Position;
import exception.AttackException;
import layout.Map;
import layout.Game;

import java.io.IOException;

/**
 * Created by j on 09/04/2016.
 */
public class Monster extends Character{
    private Coordinate coo;

    public Monster (String name, int hp, Position position, Coordinate coo){
        super(name, hp, 0, position);
        this.symbol = "XXX";
        this.coo = coo;
    }

    @Override
    public void run() {
        while (this.isAlive){
            try {
                // Thoa man dieu kien -> co the di chuyen
                // Moi buoc di chuyen cach nhau 1s
                if (true){
                    // Ko co charactor khac o newPos
                    Thread.sleep(1000);
                    if (move(coo)) {
                        //continue;
                    } else {
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
                } else {
                    // Co charactor khac o newPos
                }
            } catch (InterruptedException e) {
                try {
                    if (isAlive){
                        Thread.sleep(2000);
                        System.out.println("... Frozen Time: " + this.name + " activated");
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (AttackException e) {
                if (e.getEnemy() instanceof Player){
                    e.getEnemy().gotHit(this, e.getDamage());
                }
            }
        }

        if (! this.isAlive) {
            Map map = (Map) Game.get("map");
            map.removeMonster(this);
        }
    }
}
