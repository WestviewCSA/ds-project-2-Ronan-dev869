import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CoorMap {
	private Tile[][][] map;
	private ArrayList<Wolverine> player;
	private int x;
	private int y; 
	private int z;
	
	public CoorMap(String map) {
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
			
			
			this.map = new Tile[dimensions[2]][dimensions[0]][dimensions[1]];
			
			//fill map
			
			
			while(scan.hasNextLine()) {
				char location = scan.next().charAt(0);
				for(int i = 0; i<3;i++) {
					if(scan.hasNextInt() == false) {
						throw new FileNotFoundException();
					}
//					s
					dimensions[i] = scan.nextInt();
				}

				Tile x =  new Tile(dimensions[0], dimensions[1], location);
				this.map[dimensions[2]][dimensions[0]][dimensions[1]] = x;
				if(location == 'W') {
					if(location == 'W') {
						
						Wolverine wol = new Wolverine(dimensions[0],dimensions[1],dimensions[2]);
						player.add(wol);
					}
				}
				scan.nextLine();
			}
			
			for(int i = 0; i<this.map.length; i++) {
				for(int j = 0; j<this.map[i].length; j++) {
					for(int k = 0; k<this.map[i][j].length; k++) {
						if(this.map[i][j][k] == null) { 
							this.map[i][j][k] = new Tile(j, k, '.');
						}
						if(checkChar(this.map[i][j][k].getLocation()) == false) {
							throw new FileNotFoundException();
						}
					}
				}
			}
			if(checkMap()) {
				throw new FileNotFoundException();
			}
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
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public ArrayList<Wolverine> getPlayer() {
		return player;
	}
	public Tile[][][] getMap(){
		return map;
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
