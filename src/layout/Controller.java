package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import character.player;
public class Controller {
	
    public static void press(JButton button)  {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                System.out.println("You clicked the button");
            }
        });      
    }
 
 
}
