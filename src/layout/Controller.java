package layout;

import character.*;
import character.Character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
	private Layout layout;
	private Character character;
	private Position position;

	public Controller(Layout layout){
		this.layout = layout;
	}
	public Controller(Layout layout, Position position){
		this.layout = layout;
		this.position = position;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	//	public Controller(Layout layout, Character character){
//		this.layout = layout;
//		this.character = character;
//		if (character instanceof player){
//			addKeyController();
//		}
//	}

//	private void addKeyController(){
//		this.layout.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent keyEvent) {
//
//			}
//
//			@Override
//			public void keyPressed(KeyEvent keyEvent) {
//				int keyCode = keyEvent.getKeyCode();
//				switch (keyCode){
//					case KeyEvent.VK_UP:
//						move(Moving.up);
//						//character.move(Moving.up);
//						break;
//					case KeyEvent.VK_DOWN:
//						move(Moving.down);
//						//character.move(Moving.down);
//						break;
//					case KeyEvent.VK_LEFT:
//						move(Moving.left);
//						//character.move(Moving.left);
//						break;
//					case KeyEvent.VK_RIGHT :
//						move(Moving.right);
//						//character.move(Moving.right);
//						break;
//				}
//			}
//
//			@Override
//			public void keyReleased(KeyEvent keyEvent) {
//
//			}
//		});
//
//		this.layout.setFocusable(true);
//	}

//	public void move(Coordinate coordinate){
//		// Toa do (x, y) cu
//		Coordinate curr = new Coordinate(character.getPosition().getX(), character.getPosition().getY());
//
//		//Toa do (x, y) moi
//		Coordinate newPos = curr.move(coordinate);
//		if (checkInMap(newPos)){
//			character.move(coordinate);
//			Object currValue = this.layout.getValueAt(newPos);
//
//		}
//	}

	public boolean move(Coordinate coordinate, String symbol) throws IOException{
		Coordinate curr = new Coordinate(this.position.getX(), this.position.getY());
		Coordinate newPos = curr.move(coordinate);

		if (checkInMap(newPos)) {
			//Set gia tri cu vao vi tri hien tai cua player
			layout.getMap().getTable().setValueAt(this.position.getSymbol(), this.position.getX(), this.position.getY());
			String currValue = (String) this.layout.getValueAt(newPos);
			if (currValue.substring(0, 1).equals("M")) {
				loadNewMap(String.format("%s.txt", currValue));
				
			}
			if (currValue.equals("End")) {
				endMap();
			}
			// Set lai x, y
			this.position.setX(this.position.getX() + coordinate.getX());
			this.position.setY(this.position.getY() + coordinate.getY());

			// Set gia tri moi cua o player de len
			this.position.setSymbol((String) this.layout.getMap().getTable().getValueAt(this.position.getX(), this.position.getY()));

			// Set gia tri moi o table tai vi tri player
			layout.getMap().getTable().setValueAt(symbol, this.position.getX(), this.position.getY());
			
			
			return true;
		}
		return false;
	}

	private boolean checkInMap(Coordinate coo){
		if (coo.getX() < 0) return false;
		if (coo.getY() < 0) return false;

		JTable table = this.layout.getMap().getTable();
		int maxX = table.getRowCount();
		int maxY = table.getColumnCount();

		if (coo.getX() >= maxX) return false;
		if (coo.getY() >= maxY) return false;

		return true;
	}

	public void draw(String symbol){
		this.position.setSymbol((String) layout.getMap().getTable().getValueAt(this.position.getX(), this.position.getY()));
		layout.getMap().getTable().setValueAt(symbol, this.position.getX(), this.position.getY());
	}

	private void loadNewMap(String name) throws IOException {
		this.layout.getMap().getTable().setModel(new DefaultTableModel(null, this.layout.getMap().getColumnName()));
		this.layout.getMap().create(name);
		this.layout.getMap().draw();

	}
	
	public void endMap(){
		System.out.println("Tro choi ket thuc");
		this.layout.getUp().setEnabled(false);
		this.layout.getDown().setEnabled(false);
		this.layout.getLeft().setEnabled(false);
		this.layout.getRight().setEnabled(false);
		//Todo khoa ca ban phim khong cho di chuyen
		newGame();
		return;
	}


	public void newGame()
	{
		//Todo: di chuyen duoc bang ban phim sau khi bam nut
		layout.getB2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
            	layout.getUp().setEnabled(true);
            	layout.getDown().setEnabled(true);
            	layout.getLeft().setEnabled(true);
            	layout.getRight().setEnabled(true);
    	        try {
    	    		layout.getMap().getTable().setModel(new DefaultTableModel(null, layout.getMap().getColumnName()));
					layout.getMap().create("M1.txt");
					layout.getMap().draw();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    	        
            }

        });
	}
	

//	public void newGame()
//	{
//		layout.getB2().addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e)  {
//            	Map map = new Map();
//            	layout.getUp().setEnabled(true);
//    			layout.getDown().setEnabled(true);
//    			layout.getLeft().setEnabled(true);
//    			layout.getRight().setEnabled(true);
//    	        try {
//					map.createMap("M1.txt");
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//    	        String[][] test = map.getWords();
//    	        for (int i = 0; i < 5; i++) {
//    	            for (int j = 0; j < 5; j++) {
//    	                layout.getMap().getTable().setValueAt(test[i][j], i, j);
//    	            }
//    	        }
//    	    layout.setOldPos(layout.getMap().getTable().getValueAt(4, 0));
//
//    	    layout.getMap().getTable().setValueAt(character.getSymbol(), 4, 0);
//    	    character.getPosition().setX(4);
//				character.getPosition().setY(0);
//            }
//        });
//	}
//	public void checkEnd(Object next){
//		String check = (String) next;
//		if(check.equals("End")){
//			System.out.println("Tro choi ket thuc");
//			layout.getUp().setEnabled(false);
//			layout.getDown().setEnabled(false);
//			layout.getLeft().setEnabled(false);
//			layout.getRight().setEnabled(false);
//			newGame();
//			return;
//		}
//	}
//	public void checkNextMap(Object next) throws IOException{
//		String check = (String) next;
//		Map map= new Map();
//		//player player = new player();
//		if(check.substring(0,1).equals("M")){
//			// Sang map khac
//			check = check + ".txt";
//	        map.createMap(check); // recreate map, thay doi du lieu trong mang words
//	        String[][] test = map.getWords();
//
//			// set lai layout.getTable() theo gia tri trong mang map.getWords()
//	        for (int i = 0; i < 5; i++) {
//	            for (int j = 0; j < 5; j++) {
//	                layout.getTable().setValueAt(test[i][j], i, j);
//	            }
//	        }
//	    	layout.setOldPos(layout.getTable().getValueAt(4, 0));
//
//			// dat player o (4, 0)
//	    	layout.getTable().setValueAt(character.getSymbol(), 4, 0);
//	    	character.getPosition().setX(4);
//	    	character.getPosition().setY(0);
//		}
//	}
//	public void press(){
//       	//player player = new player();
//       	//final JTable table = layout.getTable();
//
//    	layout.getUp().addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e)  {
//               	int x = character.getPosition().getX();
//               	int y = character.getPosition().getY();
//
//				if (x < 1){
//					System.out.println("Khong the di chuyen");
//					return;
//				}
//
//               	Object next = layout.getTable().getValueAt(x-1, y);
//               	layout.getTable().setValueAt(character.getSymbol(), x-1, y);
//            	character.getPosition().setX(x - 1);
//            	layout.getTable().setValueAt(layout.getOldPos(), x, y);
//            	layout.setOldPos(next);
//            	try {
//            		checkEnd(next);
//					checkNextMap(next);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
//            }
//        });
//
//    	layout.getDown().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)  {
//				int x = character.getPosition().getX();
//				int y = character.getPosition().getY();
//
//				if (x > 3){
//					System.out.println("Khong the di chuyen");
//					return;
//				}
//				Object next = layout.getTable().getValueAt(x + 1, y);
//				layout.getTable().setValueAt(character.getSymbol(), x + 1, y);
//				character.getPosition().setX(x + 1);
//				layout.getTable().setValueAt(layout.getOldPos(), x, y);
//				layout.setOldPos(next);
//				try {
//					checkEnd(next);
//					checkNextMap( next);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//
//    	layout.getLeft().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)  {
//				int x = character.getPosition().getX();
//				int y = character.getPosition().getY();
//
//				if (y < 1){
//					System.out.println("Khong the di chuyen");
//					return;
//				}
//				Object next = layout.getTable().getValueAt(x, y - 1);
//				layout.getTable().setValueAt(character.getSymbol(), x, y - 1);
//				character.getPosition().setY(y - 1);
//				layout.getTable().setValueAt(layout.getOldPos(), x, y);
//				layout.setOldPos(next);
//				try {
//					checkEnd(next);
//					checkNextMap(next);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//
//    	layout.getRight().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)  {
//				int x = character.getPosition().getX();
//				int y = character.getPosition().getY();
//
//				if (y > 3){
//					System.out.println("Khong the di chuyen");
//					return;
//				}
//				Object next = layout.getTable().getValueAt(x, y + 1);
//				layout.getTable().setValueAt(character.getSymbol(), x, y + 1);
//				character.getPosition().setY(y + 1);
//				layout.getTable().setValueAt(layout.getOldPos(), x, y);
//				layout.setOldPos(next);
//				try {
//					checkEnd(next);
//					checkNextMap(next);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//	}
//
 
}
