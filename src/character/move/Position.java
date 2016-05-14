package character.move;

/**
 * Created by j on 14/03/2016.
 */
public class Position {
    private Coordinate coordinate;
    private String symbol;

    public Position(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }

    public int getX() {
        return coordinate.getX();
    }

    public void setX(int x) {
        coordinate.setX(x);
    }

    public int getY() {
        return coordinate.getY();
    }

    public void setY(int y) {
        coordinate.setY(y);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
