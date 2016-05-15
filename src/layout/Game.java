package layout;

import character.Player;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by j on 12/05/2016.
 */
public final class Game {
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
            case "Player":
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
        layout.setPlayer(null);

        Player player = (Player) Game.get("player");
        Object[] options = { "Choi lai", "Thoat" };
        int iLuaChon = JOptionPane.showOptionDialog(null, "So diem cua ban: " + player.getPoint()

                        + "\nHay chon 1 trong 2 lua chon sau", null, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (iLuaChon == 0) {
//	    	  this.position.setY(0);
//	    	  loadNewMap("M1.txt");
//	    	  this.position.setX(this.layout.getMap().getMaxX()-1);
//	    	  this.layout.getPlayer().setHp(1000);
//	    	  this.layout.getPlayer().setMp(400);
//	    	  this.layout.getMap().getTable().setValueAt("0", this.position.getX(), 0);
//	    	  this.layout.getHpLabel().setText("HP: " + 1000);
//	    	  this.layout.getMpLabel().setText("MP: " + 400);
            Game.init();
            Game.start();
        }
        else layout.dispose();
    }
}
