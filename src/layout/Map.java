package layout;
import character.Monster;
import character.Position;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Map {
	private String[][] words = new String[5][5];
	private static BufferedReader reader;
	private JTable table;
	private int maxX; // chi so cot 1 -> maxX
	private int maxY;

	public Map(String name) throws IOException {
		this.maxX = 5;
		this.maxY = 5;

		create(name);
		draw();
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

		int i=0,j=0;
		do{
				for(i=0;i<5;i++){
					String[] arr = line.split(" ");
					for(j=0;j<5;j++){
						words[i][j] = arr[j];
					}
					line = reader.readLine();
				}
		}while(line != null);
		reader.close();
	}

	public void draw() {
		/*
			Load du lieu trong words vao JTable
		 */
		TableModel dataModel = new DefaultTableModel() {
			public int getColumnCount() { return maxX; }
			public int getRowCount() { return maxY;}
			public Object getValueAt(int row, int col) { return words[row][col]; } // Gan du lieu trong words cho table
		};
		this.table = new JTable(maxX, maxY);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				table.setValueAt(words[i][j], i, j);
			}
		}
	}

	public void addMonster(Layout layout){

	}
}
