import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	private Tile[][][] map;
	
	public Map(String map) {
		File file = new File(map);
		try {
			Scanner scan = new Scanner(file);
			// get dimensions
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int levels = scan.nextInt();
			
			
			
			this.map = new Tile[rows][cols][levels];
			
			//fill map
			String line = scan.nextLine();
			for(int i = 1; i<=levels; i++) {
				for(int j = 0; j<rows; j++) {
					for(int k = 0; k<cols; k++) {
						this.map[i][j][k] = new Tile(j,k,line.charAt(k));
					}
					line = scan.nextLine();
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		String res = "";
		for(int i = 1; i<=map.length;i++) {
			for(int j = 0; j<map[0].length; j++) {
				for(int k = 0; k<map[0][0].length; k++) {
					res += map[i][j][k] + " ";
				}
				res += "/n";
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map room1 = new Map("src/test1");
		System.out.println(room1.toString());
	}
}
