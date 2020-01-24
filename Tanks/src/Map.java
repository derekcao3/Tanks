import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map {
	int mRows = 128;
	int mColumns = 128;
	char array[][	] = new char[mRows][mColumns];
	
	
	void loadMap(String filename) {
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
		    String line = br.readLine();
		    int rows = 0;
		    
		    while (line != null) {
		        for (int col = 0; col < line.length(); col++) {
		            array[rows][col] = line.charAt(col);
				}
		    	rows++;
		        line = br.readLine();
		        
		    }
		    br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	for (int i=0; i < row; i++) {
	    for (int j=0; j < column; j++) {
	        boardArray[i][j] = startConfig.charAt(j);
	    }
	}
	
	BufferedReader br = new BufferedReader(new FileReader(filename));
	try {
	    
	    String line = br.readLine();
	
	    while (line != null) {
	        
	        line = br.readLine();
	    }
} finally {
    br.close();
}
	
	//*/
	
	
}
