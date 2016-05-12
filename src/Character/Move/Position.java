package Character.Move;

/**
 * Created by j on 14/03/2016.
 */
public class Position {
    private int x;
    private int y;
    private String symbol;

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

    public int up(int value) {
        this.x += 1;
        return 0;
    }

    public int down(int value) {
        this.x -= 1;
        return 0;
    }

    public int left(int value) {
        this.y -= 1;
        return 0;
    }

    public int right(int value) {
        this.y += 1;
        return 0;
    }

}
