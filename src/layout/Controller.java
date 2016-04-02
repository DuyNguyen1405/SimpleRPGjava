package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import character.player;
public class Controller {
	Object nextValue = new Object();

	
	public void press(JButton button,JTable table)  {
    	
       	Layout layout = new Layout();
       	player player = new player();
       	
    	button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
               	int x = layout.getX();
               	int y = layout.getY();
               	
            	if(x<1) {
            		System.out.println("Khong the di chuyen");
            		return;
            	}
               	//player.makeChar(x-1, y, table);
               	Object next = table.getValueAt(x-1, y);
               	table.setValueAt("o", x-1, y);
            	layout.setX(x-1);
            	table.setValueAt(layout.getOldPos(), x, y);
            	layout.setOldPos(next);
            	
            }
        });  
    }
	
//	public void press(JButton button,JTable table, Object oldPos)  {
//    	
//       	Layout layout = new Layout();
//       	player player = new player();
//
//    	button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e)  {
//               	int x = layout.getX();
//               	int y = layout.getY();
//            	player.makeChar(x-1, y, table);
//               	table.setValueAt("o", x-1, y);
//            	layout.setX(x-1);
//            	table.setValueAt(player.getOldValue(), x, y);
//            	
//            }
//        });  
//    }
 
 
}
