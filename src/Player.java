/**
 * Created by j on 14/03/2016.
 */
public class Player extends Character{
    Position position;

    public Player(String name) {
        super(name);
        this.hp = 100;
        this.mp = 10;
        this.position.setX(0);
        this.position.setY(0);
    }

    @Override
    public void die() {
        //end game
    }
}
