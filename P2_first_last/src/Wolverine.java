
public class Wolverine {
	private int x;
	private int y;
	private int z;
	Stack<Tile> path;
	Stack<String> moves;
	public Wolverine(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		path = new Stack<Tile>();
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
	
//	public Stack<Tile> getPath(Tile[][][] board) {
//		Stack<Tile> moves = new Stack<Tile>();
//		moves = north(x,y,z,board);
//		return moves;
//	}
//	
//	public Stack<Tile> north(int x, int y, int z, Tile[][][] board){
//		if(board[z][x][y].getLocation() == '$') {
//			return path;
//		}
//		if(board[z][x][y].getLocation() == '@' || x<0) {
//			deNorth(x, board);
//			return path;
//		}
//		else {
//			path.push(new Tile(x-1,y,'+'));
//			north(x-1,y,z,board);
//			return path;
//		}
//	}
//	
//	public void deNorth(int x, Tile[][][] board){
//		if(board[z][x][y+1].getLocation() == '.' && y+1<board[0][0].length) {
//			return;
//		}
//		if(board[z][x][y-1].getLocation() == '.' && y>0) {
//			return;
//		}
//		else {
//			path.pop();
//		}
//	}
}
