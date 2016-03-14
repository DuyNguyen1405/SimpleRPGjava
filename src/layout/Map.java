package layout;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Map {
		
		    private static BufferedReader reader;
			public void createMap() throws IOException{
		            
				String[][] words = new String[5][5];
		            FileReader file = new FileReader("M1.txt");
		            reader = new BufferedReader(file);
		            String line = reader.readLine();
		            
		            int i=0,j=0;
		            int count=0;
		            do{
		            	
			            	for(i=0;i<5;i++){
			            		String[] arr = line.split(" ");
			            		for(j=0;j<5;j++){
//				            		if(count==arr.length) break;
			            			words[i][j] = arr[j];
//				            		count++;
			            			System.out.print(words[i][j]);
				            		
			            		}

			            		System.out.println();
			            		line = reader.readLine();
			            	}
			            	
		            	
		            	

		            }while(line != null);
		            
		            reader.close();
		            //System.out.println(words[0][4]);
		    }
			
			}

		 

