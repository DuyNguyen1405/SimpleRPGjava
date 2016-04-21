package character;

/**
 * Created by j on 14/03/2016.
 */
public class Position {
    private int x;
    private int y;
    private String symbol;

    public Position(int x, int y, String symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int distance(Position p){
        return (Math.abs(p.x - this.x) + Math.abs(p.y - this.y));
    }

    public int up(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */

        this.x += 1;
        return 0;
    }

    public int down(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.x -= 1;
        return 0;
    }

    public int left(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.y -= 1;
        return 0;
    }

    public int right(int value) {
        /* TODO
        *
        * Kiem tra xem co the di chuyen nhu vay khong?
        * */
        this.y += 1;
        return 0;
    }

}
