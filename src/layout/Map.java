package layout;

import character.Monster;
import character.Player;
import character.move.Coordinate;
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

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public Map(String name) throws IOException {
		this.table = new JTable();
		create(name);
		draw();
	}
	public void addMonsterToMap(){
		int x, y;
		this.monsters = new ArrayList();
		Monster monster;
		for(int i=0;i<num;i++){
			x = Integer.parseInt(wordsMonster[i][3]);
			y = Integer.parseInt(wordsMonster[i][4]);
			int move = Integer.parseInt(wordsMonster[i][5]);
			Coordinate moving;
			switch (move){
				case 0:
					moving = Moving.up;
					break;
				case 1:
					moving = Moving.down;
					break;
				case 2:
					moving = Moving.left;
					break;
				case 3:
					moving = Moving.right;
					break;
				case 4:
					moving = Moving.chase;
					break;
				default:
					moving = Moving.left;
			}
			monster	= new Monster(wordsMonster[i][0], wordsMonster[i][1], Integer.parseInt(wordsMonster[i][2]), new Position(x, y), moving, Integer.parseInt(wordsMonster[i][6]));
			addMonster(monster);
		}
	}

	public JTable getTable() {
		return table;
	}

	public void setWordAt(String symbol, int x, int y){
		words[x][y] = symbol;
	}

	public void loadNewMap(String name) throws IOException {
		System.out.println();
		System.out.println("New map: " + name);
		removeAllMonster();
		table.setModel(new DefaultTableModel(null, getColumnName()));
		create(name);
		draw();
		Player player = (Player) Game.get("player");
		player.setPosition(maxX - 1, maxY - 1);
		player.draw();
		activateMonster();
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
					try {
						if (arr[j].equals(",")) words[i][j] = "";
						else words[i][j] = arr[j];
					} catch (Exception e){
						System.out.println(i + " " + j);
					}
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
		wordsMonster = new String[num][7];
		line = reader.readLine();
		
		do{
			for(i=0;i<num;i++){
				if(line != null) arr = line.split(" ");
				for(j=0;j<7;j++){
					wordsMonster[i][j] = arr[j];
					//System.out.print(arr[j]);
				}
				line = reader.readLine();
			}
			
	}while(line != null);
		addMonsterToMap();
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
		int n = monsters.size();
		for (int i = 0; i < n; i++){
			Monster monster = (Monster) monsters.get(i);
			monster.activate();
		}
	}
	
	public void removeAllMonster(){
		while (monsters.size() > 0){
			Monster monster = (Monster) monsters.get(0);
			monster.die();
		}
	}
	public Object getValueAt(int x, int y){
		return this.words[x][y];
	}
}
