package character;

import character.move.Coordinate;
import character.move.Position;
import exception.AttackException;
import layout.Layout;
import layout.Resource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;

public class Controller {
	private Layout layout;
	private Position position;
	private Thread thread;

	public Controller(){

	}

	public Layout getLayout() {
		return (Layout) Resource.get("layout");
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean move(Coordinate coordinate, String symbol) throws AttackException, IOException{
		Coordinate curr = new Coordinate(this.position.getX(), this.position.getY());
		Coordinate newPos = curr.move(coordinate);

		if (checkInMap(newPos)) {
			//Set gia tri cu vao vi tri hien tai cua player
			if (this.layout.getCharacterAt(newPos) != null){
				throw new AttackException(this.getLayout().getCharacterAt(newPos));
			}
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

			if (currValue.equals("O")){
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

	public Coordinate getNewPos(Coordinate coo){
		return coo.move(coo);
	}
	
	public void endMap() throws IOException{
		Object[] options = { "New Game", "Quit Game" };
	      int iLuaChon = JOptionPane.showOptionDialog(null, "Choose", null, JOptionPane.DEFAULT_OPTION, 
	    		  JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	      if (iLuaChon == 0) {
	    	  this.position.setY(0);
	    	  loadNewMap("M1.txt");
	    	  this.position.setX(this.layout.getMap().getMaxX()-1);
	    	  this.layout.getPlayer().setHp(1000);
	    	  this.layout.getPlayer().setMp(400);
	    	  this.layout.getMap().getTable().setValueAt("0", this.position.getX(), 0);
	    	  this.layout.getHpLabel().setText("HP: " + 1000);
	    	  this.layout.getMpLabel().setText("MP: " + 400);
	      }
	      else layout.dispose();
		//Todo khoa ca ban phim khong cho di chuyen
		return;
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Boolean onSameRowRight(Position pos){
		return (this.position.getX() == pos.getX()) && (this.position.getY() <= pos.getY());
	}

	public Boolean onSameRowLeft(Position pos){
		return (this.position.getX() == pos.getX()) && (this.position.getY() >= pos.getY());
	}
}
