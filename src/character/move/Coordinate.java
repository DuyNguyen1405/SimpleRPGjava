package character.move;

/**
 * Created by j on 05/04/2016.
 */
public class Coordinate {
    protected int x;
    protected int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate move(Coordinate value){
        return new Coordinate(this.x + value.getX(), this.y + value.getY());
    }
}
