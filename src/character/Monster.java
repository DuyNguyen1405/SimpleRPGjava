package character;

import layout.Controller;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by j on 09/04/2016.
 */
public class Monster extends Character implements Runnable{
    Toolkit toolkit;
    Timer timer;
    Coordinate coo;

    public Monster (Controller controller){
        super(controller);
        this.symbol = "X";
        coo = Moving.right;
//        toolkit = Toolkit.getDefaultToolkit();
//        timer = new Timer();
//        timer.schedule(new CrunchifyReminder(), 0, 1 * 1000);
        //remote();
    }

//    class CrunchifyReminder extends TimerTask {
//        public void run() {
//            if (true) {
//                toolkit.beep();
//                //System.out.format("Knock Knock..!\n");
//                try {
//                    if (move(coo)) {
//                        //continue;
//                    } else {
//                        if (coo == Moving.right) {
//                            coo = Moving.left;
//                        } else {
//                            coo = Moving.right;
//                        }
//                    }
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//            } else {
//                toolkit.beep();
//                System.out.format("\nThat's it.. Done..!");
//                timer.cancel();
//            }
//        }
//    }


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
							} catch (AttackException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    1000
            );
    }

    @Override
    public void run() {
        while (true){
            try {
                // Thoa man dieu kien -> co the di chuyen
                // Moi buoc di chuyen cach nhau 1s
                if (true){ //TODO
                    // Ko co charactor khac o newPos
                    Thread.sleep(1000);
                    if (move(coo)) {
                        //continue;
                    } else {
                        if (coo == Moving.right) {
                            coo = Moving.left;
                        } else {
                            coo = Moving.right;
                        }
                    }
                } else {
                    // Co charactor khac o newPos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (AttackException e) {
                System.out.println("Attack!");
            }
        }
    }
}
