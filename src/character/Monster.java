package character;

import layout.Controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by j on 09/04/2016.
 */
public class Monster extends Character {
    public Monster (Controller controller){
        super(controller);
        this.symbol = "X";
    }

    public void remote(){
//        try {
//                //1000 milliseconds is one second.
////            Coordinate coo = Moving.right;
////            while (true){
////                Thread.sleep(1000);
////                if (move(coo)){
////                    continue;
////                } else {
////                    if (coo == Moving.right){
////                        coo = Moving.left;
////                    } else {
////                        coo = Moving.right;
////                    }
////                }
////            }
////
////            Thread.sleep(10000);
////            move(Moving.up);
//
//        } catch(InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }

            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            // your code here
                            Coordinate coo = Moving.right;
                            try {
								if (move(coo)) {
								    //continue;
								} else {
								    if (coo == Moving.right) {
								        coo = Moving.left;
								    } else {
								        coo = Moving.right;
								    }
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        }
                    },
                    1000
            );
    }
}
