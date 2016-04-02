/**
 * Created by j on 14/03/2016.
 */
public class Position implements Move{
    private int x;
    private int y;

    public Position(int x, int y) {
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

    public int distance(Position p){
        return (Math.abs(p.x - this.x) + Math.abs(p.y - this.y));
    }

    @Override
    public int up(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */

        this.x += 1;
        return 0;
    }

    @Override
    public int down(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.x -= 1;
        return 0;
    }

    @Override
    public int left(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.y -= 1;
        return 0;
    }

    @Override
    public int right(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.y += 1;
        return 0;
    }
}
