/**
 * Created by j on 14/03/2016.
 */
public class Monster extends Character{


    public Monster(String name) {
        super(name);
        this.hp = 20;
        this.mp = 10;
    }

    @Override
    public void die() {
        System.out.println("Die");
    }
}
