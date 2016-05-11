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

	public boolean move(Coordinate coordinate, String symbol) throws IOException{
		Coordinate curr = new Coordinate(this.position.getX(), this.position.getY());
		Coordinate newPos = curr.move(coordinate);

		if (checkInMap(newPos)) {
			//Set gia tri cu vao vi tri hien tai cua player

			// Get value tu Table
//			layout.getMap().getTable().setValueAt(this.position.getSymbol(), this.position.getX(), this.position.getY());
			layout.getMap().getTable().setValueAt(this.layout.getMap().getValueAt(this.position.getX(), this.position.getY()), this.position.getX(), this.position.getY());

			//Get value tu Table
//			String currValue = (String) this.layout.getValueAt(newPos);
			String currValue = (String) this.layout.getMap().getValueAt(newPos.getX(), newPos.getY());
			if (currValue.substring(0, 1).equals("M")) {
				loadNewMap(String.format("%s.txt", currValue));
			}
			if (currValue.equals("End")) {
				endMap();
			}

			if (currValue.equals("X")){
				System.out.println("Player attact Monster!!");
			}

			System.out.println(currValue);
			if (currValue.equals("O")){
				System.out.println(currValue);
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
 
}
