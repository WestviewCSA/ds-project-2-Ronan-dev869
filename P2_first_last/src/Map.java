import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
	private Tile[][][] map;
	private int x;
	private int y;
	private int z;
	public Map(String map) {
		File file = new File(map);
		try {
			Scanner scan = new Scanner(file);
			// get dimensions
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			int levels = scan.nextInt();
			
			
			
			this.map = new Tile[levels][rows][cols];
			
			//fill map
			String line = scan.next();
			
				for(int i = 0; i<levels; i++) {
					for(int j = 0; j<rows; j++) {
						for(int k = 0; k<cols; k++) {
							this.map[i][j][k] = new Tile(j,k, line.charAt(k));
							if(line.charAt(k) == 'W') {
								x = j;
								y = k;
								z = i;
							}
						}
						if(scan.hasNext()) {
							line = scan.next();
						}
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
	public Tile[][][] getMap(){
		return map;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	public void setTile(int x, int y, int z, char type) {
		map[z][x][y] = new Tile(x,y,type);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map room1 = new Map("src/test1");
		System.out.println(room1.toString());
	}
}
