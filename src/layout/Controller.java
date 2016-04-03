package layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTable;

import character.player;
public class Controller {
	Object nextValue = new Object();
	
	public void checkEnd(Layout layout, Object next, JTable table){
		String check = (String) next;
		if(check.equals("End")){
			System.out.println("Tro choi ket thuc");
			return;
		}
	}
	public void checkNextMap(Layout layout, Object next, JTable table) throws IOException{
		String check = (String) next;
		Map map= new Map();
		player player = new player();
		if(check.substring(0,1).equals("M")){
			check = check + ".txt";
	        map.createMap(check);
	        String[][] test = map.getWords();
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                table.setValueAt(test[i][j], i, j);
	            }
	        }
	    layout.setOldPos(table.getValueAt(4, 0));
	    
	    table.setValueAt("o", 4, 0);
	    layout.setX(4);
	    layout.setY(0);
		}
	}
	public void press(final Layout layout){
       	player player = new player();
       	final JTable table = layout.getTable();
    	layout.getUp().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
               	int x = layout.getX();
               	int y = layout.getY();
               	
				if (x < 1){
					System.out.println("Khong the di chuyen");
					return;
				}
            	
               	Object next = table.getValueAt(x-1, y);
               	table.setValueAt("o", x-1, y);
            	layout.setX(x-1);
            	table.setValueAt(layout.getOldPos(), x, y);
            	layout.setOldPos(next);
            	try {
            		checkEnd(layout, next,table);
					checkNextMap(layout, next,table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });

    	layout.getDown().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int x = layout.getX();
				int y = layout.getY();

				if (x > 3){
					System.out.println("Khong the di chuyen");
					return;
				}
				Object next = table.getValueAt(x + 1, y);
				table.setValueAt("o", x + 1, y);
				layout.setX(x + 1);
				table.setValueAt(layout.getOldPos(), x, y);
				layout.setOldPos(next);
				try {
					checkEnd(layout, next,table);
					checkNextMap(layout, next,table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

    	layout.getLeft().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int x = layout.getX();
				int y = layout.getY();

				if (y < 1){
					System.out.println("Khong the di chuyen");
					return;
				}
				Object next = table.getValueAt(x, y - 1);
				table.setValueAt("o", x, y - 1);
				layout.setY(y - 1);
				table.setValueAt(layout.getOldPos(), x, y);
				layout.setOldPos(next);
				try {
					checkEnd(layout, next,table);
					checkNextMap(layout, next,table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

    	layout.getRight().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int x = layout.getX();
				int y = layout.getY();

				if (y > 3){
					System.out.println("Khong the di chuyen");
					return;
				}
				Object next = table.getValueAt(x, y + 1);
				table.setValueAt("o", x, y + 1);
				layout.setY(y + 1);
				table.setValueAt(layout.getOldPos(), x, y);
				layout.setOldPos(next);
				try {
					checkEnd(layout, next,table);
					checkNextMap(layout, next,table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
 
 
}
