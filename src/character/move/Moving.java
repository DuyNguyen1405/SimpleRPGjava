package character.move;

/**
 * Created by j on 05/04/2016.
 */
public interface Moving {
    final Coordinate up = new Coordinate(-1, 0);
    final Coordinate down = new Coordinate(1, 0);
    final Coordinate left = new Coordinate(0, -1);
    final Coordinate right = new Coordinate(0, 1);
    final Coordinate chase = new Coordinate(0, 0);
}
