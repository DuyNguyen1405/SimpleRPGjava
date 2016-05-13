package layout;;

/**
 * Created by j on 12/05/2016.
 */
public final class Resource {
    private static Layout layout;

    public static void setLayout(Layout layout) {
        Resource.layout = layout;
    }

    public static Object get(String resourceName){
        switch (resourceName){
            case "Layout":
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
