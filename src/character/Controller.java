package character;

import character.move.Coordinate;
import character.move.Moving;
import character.move.Position;
import exception.AttackException;
import exception.EndGameException;
import exception.NewMapException;
import layout.Game;
import layout.Layout;
import layout.Map;

import javax.swing.*;
import java.io.IOException;

public class Controller {
	private Position position;
	private Thread thread;

	public Controller(Position position){
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	private Layout getLayout(){return (Layout) Game.get("layout");}

	public int move(Coordinate coordinate, String symbol) throws AttackException, EndGameException, NewMapException, IOException{
		Layout layout = (Layout) Game.get("layout");

		Coordinate curr = new Coordinate(this.position.getX(), this.position.getY());
		Coordinate newPos = curr.move(coordinate);
		int point = 0;

		if (checkInMap(newPos)) {
			if (layout.getCharacterAt(newPos) != null){
				throw new AttackException(layout.getCharacterAt(newPos));
			}
			layout.getMap().getTable().setValueAt(layout.getMap().getValueAt(this.position.getX(), this.position.getY()), this.position.getX(), this.position.getY());
			String currValue = (String) layout.getMap().getValueAt(newPos.getX(), newPos.getY());
			if ((!currValue.isEmpty()) && (currValue.substring(0, 1).equals("M"))) {
				//loadNewMap(String.format("%s.txt", currValue));
				throw new NewMapException(currValue+".txt");
			}
			if ((!currValue.isEmpty()) && (currValue.equals("End"))) {
				//endMap();
				throw new EndGameException();
			}

			if ((!currValue.isEmpty()) && (currValue.equals("*"))) {
				point = 1;
			}

			// Set lai x, y
			this.position.setX(this.position.getX() + coordinate.getX());
			this.position.setY(this.position.getY() + coordinate.getY());

			// Set gia tri moi cua o Player de len
			this.position.setSymbol((String) layout.getMap().getTable().getValueAt(this.position.getX(), this.position.getY()));

			// Set gia tri moi o table tai vi tri Player
			layout.getMap().getTable().setValueAt(symbol, this.position.getX(), this.position.getY());

			return point;
		}
		return -1;
	}

	private boolean checkInMap(Coordinate coo){
		if (coo.getX() < 0) return false;
		if (coo.getY() < 0) return false;

		JTable table = getLayout().getMap().getTable();
		int maxX = table.getRowCount();
		int maxY = table.getColumnCount();

		if (coo.getX() >= maxX) return false;
		if (coo.getY() >= maxY) return false;

		return true;
	}

	public void draw(String symbol){
		getLayout().getMap().getTable().setValueAt(symbol, this.position.getX(), this.position.getY());
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Boolean onSameRow(Position pos, Coordinate direction){
		if (direction == Moving.left)
			return (this.position.getX() == pos.getX()) && (this.position.getY() >= pos.getY());
		if (direction == Moving.right)
			return (this.position.getX() == pos.getX()) && (this.position.getY() <= pos.getY());
		return false;
	}

	public void reDraw(){
		Map map = (Map) Game.get("map");
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		map.getTable().setValueAt(map.getValueAt(x, y), x, y);
	}

	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	public void eatPoint(){
		Map map = (Map) Game.get("map");
		map.setWordAt("", this.position.getX(), this.position.getY());
	}
}
