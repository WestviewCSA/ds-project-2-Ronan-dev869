
public class Wolverine {
	private int x;
	private int y;
	private int z;
	Stack<Tile> path;
	public Wolverine(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		path = new Stack<Tile>();
	}
	
	public Stack<Tile> getPath(Tile[][][] board) {
		Stack<Tile> moves = new Stack<Tile>();
		
		return moves;
	}
	
	public Stack<Tile> north(int x,int y,int z, Tile[][][] board){
		if(board[z][x-1][y].getLocation() == '@' || x-1>=0) {
			return path;
		}
		else {
			path.push(new Tile(x-1,y,'+'));
//			if(board[z][x-1][y+1].getLocation() != '@') {
//				east(x,y+1,z);
//			}
//			if(board[z][x-1][y-1].getLocation() != '@') {
//				west(x,y-1,z);
//			}
			
				north(x-1,y,z, board);
			
			return path;
		}
	}
//	public Stack<Tile> east(Tile[][][] board){
//		if(board[z][x-1][y].getLocation() == '@' && x-1>=0) {
//			return path;
//		}
//		else {
//			path.push(new Tile(x-1,y,'+'));
//			if(board[z][x-1][y+1].getLocation() != '@') {
//				east(Tile[][][] board);
//			}
//			else if(board[z][x-1][y-1].getLocation() != '@') {
//				west(Tile[][][] board);
//			}
//			else {
//				
//			}
//			return path;
//		}
//	}
//	public Stack<Tile> west(Tile[][][] board){
//		if(board[z][x-1][y].getLocation() != '@' && x-1>=0) {
//			return path;
//		}
//		else {
//			path.push(new Tile(x-1,y,'+'));
//			if(board[z][x-1][y+1].getLocation() != '@') {
//				east(Tile[][][] board);
//			}
//			if(board[z][x-1][y-1].getLocation() != '@') {
//				west(Tile[][][] board);
//			}
//			return path;
//		}
//	}
}
