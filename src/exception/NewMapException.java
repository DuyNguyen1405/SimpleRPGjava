package exception;

/**
 * Created by j on 16/05/2016.
 */
public class NewMapException extends Exception {
    private String mapName;

    public NewMapException(String mapName) {
        super();
        this.mapName = mapName;
    }

    public String getMapName() {
        return mapName;
    }
}
