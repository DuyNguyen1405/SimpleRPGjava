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
	private String[][] wordsMonster;
	private int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private static Object columnName[];
	private ArrayList monsters;

	public Object[] getColumnName() {
		return columnName;
	}

	public String[][] getWordsMonster() {
		return wordsMonster;
	}

	public void setWordsMonster(String[][] wordsMonster) {
		this.wordsMonster = wordsMonster;
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
		int x, y;
		
		Monster monster;
		for(int i=0;i<num;i++){
			x = Integer.parseInt(wordsMonster[i][2]);
			y = Integer.parseInt(wordsMonster[i][3]);
			monster	= new Monster(wordsMonster[i][0], Integer.parseInt(wordsMonster[i][1]), new Position(x, y), Moving.right, Integer.parseInt(wordsMonster[i][5]));
			addMonster(monster);
		}
		

//		monster = new Monster(wordsMonster[1][0], 500, new Position(2, 2), Moving.down, 1000);
//		addMonster(monster);
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
	
	public void create(String name) throws IOException{
		FileReader file = new FileReader(name);
		reader = new BufferedReader(file);
		String line = reader.readLine();
		String[] arr = null;
		arr = line.split(" ");
		maxX = Integer.parseInt(arr[0]);
		maxY = Integer.parseInt(arr[1]);
		int i=0,j=0;
		words = new String[maxX][maxY];
		line = reader.readLine();
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
		Map.columnName = new Object[maxY];
		for(i = 0; i<maxY;i++) Map.columnName[i] = String.valueOf(i+1);
		createMonster(name.substring(0, 2) +"-monster.txt");
		reader.close();
	}
	
	public void createMonster(String name) throws IOException{
		FileReader file = new FileReader(name);
		reader = new BufferedReader(file);
		String line = reader.readLine();
		String[] arr = null;
		arr = line.split(" ");
		int num = Integer.parseInt(arr[0]);
		setNum(num);
		int i=0,j=0;
		wordsMonster = new String[num][6];
		line = reader.readLine();
		
		do{
			for(i=0;i<num;i++){
				if(line != null) arr = line.split(" ");
				for(j=0;j<6;j++){
					wordsMonster[i][j] = arr[j];
					//System.out.print(arr[j]);
				}
				line = reader.readLine();
			}
			
	}while(line != null);
		//System.out.println(wordsMonster[1][0]);
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
