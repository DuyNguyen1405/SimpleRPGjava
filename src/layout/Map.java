package layout;
import character.Monster;
import character.move.Moving;
import character.move.Position;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
	private JTable table;
	private static BufferedReader reader;
	private static int maxX; // chi so cot 1 -> maxX
	private static int maxY;
	private static boolean isTableExist = false;
	private String[][] words;
	private static Object columnName[];
	private ArrayList monsters;

	public Object[] getColumnName() {
		return columnName;
	}

	public void setColumnName(int i, String s) {
		this.columnName[i] = s;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public static boolean isTableExist() {
		return isTableExist;
	}

	public static void setTableExist(boolean isTableExist) {
		Map.isTableExist = isTableExist;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public Map(String name) throws IOException {
		this.table = new JTable();
		create(name);
		draw();
		this.monsters = new ArrayList();

		Monster monster;
		monster	= new Monster("Voidermort", 500, new Position(3, 0), Moving.right);
		addMonster(monster);

		monster = new Monster("Dracula", 500, new Position(2, 2), Moving.down);
		addMonster(monster);
	}

	public String[][] getWords() {
				return words;
			}
			
	public void setWords(String[][] words) {
				this.words = words;
			}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void calRowCol(String name) throws IOException{
		FileReader file = new FileReader(name);
		reader = new BufferedReader(file);
		int col =0, row =1;
		String[] arr = null;
		String line = reader.readLine();
		arr = line.split(" ");
		col = arr.length;
		while (reader.readLine() != null) row++;
		this.setMaxX(row);
		this.setMaxY(col);
		Map.columnName = new Object[col];
		for(int i = 0; i<col;i++) Map.columnName[i] = String.valueOf(i+1);
		reader.close();
		
	}
	public void create(String name) throws IOException{
		calRowCol(name);
		FileReader file = new FileReader(name);
		reader = new BufferedReader(file);
		String line = reader.readLine();
		String[] arr = null;
		int i=0,j=0;
		words = new String[maxX][maxY];
		do{
			for(i=0;i<maxX;i++){
				arr = line.split(" ");
				for(j=0;j<maxY;j++){
					if (arr[j].equals(",")) words[i][j] = "";
					else words[i][j] = arr[j];
				}
				line = reader.readLine();
			}
	}while(line != null);
		
		reader.close();
	}

	public void draw() {
		  DefaultTableModel model = new DefaultTableModel();
	      model.setDataVector(words, Map.columnName);
		  this.table.setModel(model);
		  this.table.setBounds(0,0, 450, this.getMaxX()*16);
	}

	public ArrayList getMonsters() {
		return monsters;
	}

	public void  addMonster(Monster monster){
		this.monsters.add(monster);
	}

	public void removeMonster(Monster monster) {
		this.monsters.remove(monster);
	}

	public void activateMonster(){
		for (int i = 0; i < monsters.size(); i++){
			Monster monster = (Monster) monsters.get(i);
			monster.activate();
		}
	}

	public Object getValueAt(int x, int y){
		return this.words[x][y];
	}
}
