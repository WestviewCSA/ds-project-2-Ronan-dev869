
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
	
	public Stack<Tile> getPath(Tile[][][] board) {
		
		if(board[z][x-1][y].getLocation() == '@') {
			 east(x, y,board);
		}
		
		System.out.println(path);
		return path;
	}
	
	public Stack<Tile> north(int x, Tile[][][] board){
		System.out.println(x);
		if(board[z][x][y].getLocation() == '$') {
			return path;
		}
		if(board[z][x-1][y].getLocation() == '@' || x<0) {
			deNorth(x, board);
			return path;
		}
		else {
			path.push(new Tile(x-1,y,'+'));
			north(x-1,board);
			
			return path;
		}
	}
	
	public void deNorth(int x, Tile[][][] board){
		if(board[z][x][y+1].getLocation() == '.' && y+1<board[0][0].length) {
			east(x, y+1,board);
			return;
		}
		if(board[z][x][y-1].getLocation() == '.' && y>0) {
			return;
		}
		else {
			path.pop();
			deNorth(x+1,board);
		}
	}
	
	public Stack<Tile> east(int x, int y, Tile[][][] board){
		if(board[z][x][y+1].getLocation() == '$') {
			return path;
		}
		if(board[z][x][y+1].getLocation() == '@' || y>board[0][0].length) {
			deEast(x, y, board);
			return path;
		}
		else {
			System.out.println("yes");
			path.push(new Tile(x,y+1,'+'));
			east(x,y+1, board);
			return path;
		}
	}
	public void deEast(int x, int y, Tile[][][] board){
		if(board[z][x][y].getLocation() == '+') {
			deNorth(x,board);
			return;
		}
		if(board[z][x-1][y].getLocation() == '.' && x>0) {
			north(x-1,board);
			return;
		}
		if(board[z][x+1][y].getLocation() == '.' && x<board[0].length) {
			south(x+1, y, board);
			return;
		}
		else {
			path.pop();
			
			return;
		}
	}
	public Stack<Tile> south(int x, int y, Tile[][][] board){
		if(board[z][x][y].getLocation() == '$') {
			return path;
		}
		if(board[z][x][y].getLocation() == '@' || x>board[0].length) {
			deSouth(x, y, board);
			return path;
		}
		else {
			
			path.push(new Tile(x+1,y,'+'));
			south(x+1, y, board);
			return path;
		}
	}
	public void deSouth(int x, int y, Tile[][][] board){
		if(board[z][x][y].getLocation() == '+') {
			deNorth(x,board);
			return;
		}
		if(board[z][x][y+1].getLocation() == '.' && y+1<board[0][0].length) {
			east(x, y+1,board);
			return;
		}
		if(board[z][x][y-1].getLocation() == '.' && y>0) {
			return;
		}
		else {
			path.pop();
			deSouth(x-1, y, board);
			return;
		}
	}
}
