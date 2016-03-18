package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import character.player;
public class Controller {
	Object nextValue = new Object();

	
	public void press(JButton button_up, JButton button_down, JButton button_left, JButton button_right, final JTable table)  {
    	
       	final Layout layout = new Layout();
       	player player = new player();

    	button_up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
               	int x = layout.getX();
               	int y = layout.getY();
            	
               	//player.makeChar(x-1, y, table);
               	Object next = table.getValueAt(x-1, y);
               	table.setValueAt("o", x-1, y);
            	layout.setX(x-1);
            	table.setValueAt(layout.getOldPos(), x, y);
            	layout.setOldPos(next);
            	
            }
        });

		button_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int x = layout.getX();
				int y = layout.getY();

				//player.makeChar(x-1, y, table);
				Object next = table.getValueAt(x + 1, y);
				table.setValueAt("o", x + 1, y);
				layout.setX(x + 1);
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
