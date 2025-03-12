import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoorMap {
	private Tile[][][] map;
	private int x;
	private int y; 
	private int z;
	
	public CoorMap(String map) {
		File file = new File(map);
		try {
			Scanner scan = new Scanner(file);
			// get dimensions
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int levels = scan.nextInt();
			
			
			
			this.map = new Tile[levels][rows][cols];
			System.out.println( rows + cols + levels);
			//fill map
			
			
			while(scan.hasNextLine()) {
				char location = scan.next().charAt(0);
				int row = scan.nextInt();
				int col = scan.nextInt();
				int level = scan.nextInt();
				Tile x =  new Tile(row, col, location);
				this.map[level][row][col] = x;
				if(location == 'W') {
					this.x = row;
					y = col;
					z = level;
				}
				scan.nextLine();
			}
			
			for(int i = 0; i<this.map.length; i++) {
				for(int j = 0; j<this.map[i].length; j++) {
					for(int k = 0; k<this.map[i][j].length; k++) {
						if(this.map[i][j][k] == null) { 
							this.map[i][j][k] = new Tile(j, k, '.');
						}
					}
				}
			}
			
			scan.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public String toString() {
		String res = "";
		for(int i = 0; i<map.length;i++) {
			for(int j = 0; j<map[0].length; j++) {
				for(int k = 0; k<map[0][0].length; k++) {
					res += map[i][j][k].getLocation() + " ";
				}
				res += "\n";
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoorMap room1 = new CoorMap("src/coordinateTest1");
		System.out.println(room1.toString());
	}
}
