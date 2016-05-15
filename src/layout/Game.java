package layout;

import character.Player;
import character.move.Position;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by j on 12/05/2016.
 */
public final class Game {
    private static Layout layout;
    public static boolean over;

    public static void init() {
        try {
            layout = new Layout();
            Game.over = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        try {
            layout.getPlayer().activate();
            layout.getMap().activateMonster();
            layout.updateInterval();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void restart(){
        try {
            layout.getMap().loadNewMap("M1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game.over = false;
        layout.getPlayer().die();
        layout.setPlayer(new Player("Kien", 1000, 500, new Position(layout.getMap().getMaxX() - 1, layout.getMap().getMaxY() - 1)));
        layout.getPlayer().activate();
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
            case "hplabel":
                return layout.getHpLabel();
            case "mplabel":
                return layout.getMpLabel();
            case "plabel":
                return layout.getpLabel();
            default:
                return new Object();
        }
    }

    public static void end(){
        Player player = (Player) Game.get("player");
        Map map = (Map) Game.get("map");
        map.removeAllMonster();

        Object[] options = { "Choi lai", "Thoat" };
        String result;
        if (!Game.over) result = "Chien thang!!!";
        else result = "That bai!!!";
        int iLuaChon = JOptionPane.showOptionDialog(null, result + "\nSo diem cua ban: " + player.getPoint()

                        + "\nHay chon 1 trong 2 lua chon sau", null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (iLuaChon == 0) {
            System.out.println();
            System.out.println("Restart Game");
            restart();
        }
        else layout.dispose();
    }
}
