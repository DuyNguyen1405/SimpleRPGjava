package layout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Map {
			private String[][] words = new String[5][5];
		    private static BufferedReader reader;
		    
			public String[][] getWords() {
				return words;
			}
			
			public void setWords(String[][] words) {
				this.words = words;
			}
			
			public void createMap(String name) throws IOException{
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
			}
