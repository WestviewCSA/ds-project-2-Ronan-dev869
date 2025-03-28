import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Map {
	private Tile[][][] map;
	private ArrayList<Wolverine> player;
	private int x;
	private int y;
	private int z;
	public Map(String map) {
		File file = new File(map);
		player = new ArrayList<Wolverine>();
		try {
			Scanner scan = new Scanner(file);
			// get dimensions
			int[] dimensions = new int[3];
			for(int i = 0; i<3;i++) {
				if(scan.hasNextInt() == false) {
					throw new FileNotFoundException();
				}
//				s
				dimensions[i] = scan.nextInt();
			}
			
			System.out.println(dimensions.toString());
			
			
			this.map = new Tile[dimensions[2]][dimensions[0]][dimensions[1]];
			System.out.println(dimensions[2] + " " + dimensions[0] + " " + dimensions[1]);
			//fill map
			String line = scan.next();
			
				for(int i = 0; i<dimensions[2]; i++) {
					for(int j = 0; j<dimensions[0]; j++) {
						for(int k = 0; k<dimensions[1]; k++) {
							if(checkChar(line.charAt(k)) == false) {
								throw new FileNotFoundException();
							}
							this.map[i][j][k] = new Tile(j,k, line.charAt(k));
							
							if(line.charAt(k) == 'W') {
							//	System.out.println(j + " " + k);
								Wolverine wol = new Wolverine(j,k,i);
								player.add(wol);
							}
						}
						if(scan.hasNext()) {
							line = scan.next();
						//	System.out.println(line);
						}
					}	
				}
				
				if(checkMap()) {
					throw new FileNotFoundException();
				}
			
			scan.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("invalid");
		}
		
	}
	public boolean checkMap() {
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[i].length; j++) {
				for(int k = 0; k<map[i][j].length; k++) {
					if(map[i][j][k] == null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean checkChar(char loc) {
		char[] valid = new char[5];;
		valid[0] = '$';
		valid[1] = 'W';
		valid[2] = '.';
		valid[3] = '@';
		valid[4] = '|';
		for(int i = 0; i<valid.length; i++) {
			if(loc == valid[i]) {
				return true;
			}
		}
		return false;
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

	public Tile[][][] getMap(){
		return map;
	}
	
	
	public ArrayList<Wolverine> getPlayer() {
		return player;
	}
	
	public void setTile(int x, int y, int z, char type) {
		map[z][x][y] = new Tile(x,y,type);
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Map room1 = new Map("src/test1");
//		System.out.println(room1.toString());
//	}
}
