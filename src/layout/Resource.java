package layout;

import java.io.IOException;

/**
 * Created by j on 12/05/2016.
 */
public final class Resource {
    private static Layout layout;

    public static void init() {
        try {
            layout = new Layout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        try {
            layout.getPlayer().activate();
            layout.getMap().activateMonster();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Object get(String resourceName){
        switch (resourceName){
            case "layout":
                return layout;
            case "map":
                return layout.getMap();
            case "player":
                return layout.getPlayer();
            case "monsters":
                return layout.getMap().getMonsters();
            default:
                return new Object();
        }
    }
}
