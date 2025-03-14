
public class stackMove {
	private int x;
	private int y;
	private Stack<Tile> path;

	public stackMove(int x, int y) {
		this.x = x;
		this.y = y;
		path = new Stack<Tile>();
	
	}
	
	public Stack<Tile> getPath(Tile[][][] board, int z, int x, int y){
		path.push(board[z][x][y]);
		if((path.peek().getLocation() == '$' || path.peek().getLocation() == '|')){
			return path;
		}
		else {	
			add(board,z);
			System.out.println(path);
			while(path.size() > 0) {
				Tile move = path.pop();
				board[z][move.getRow()][move.getCol()] = move;
			}
			add(board, z);
			
		}
		
		return path;
	}
	
	public void add(Tile[][][] board, int z) {
		if(x-1>0 && board[z][x-1][y].getLocation() != '@') {
			Tile north = board[z][x-1][y];
			north.setLocation('+');
			path.push(north);
		}
		if(x+1<board[0].length && board[z][x+1][y].getLocation() != '@') {
			Tile south = board[z][x+1][y];
			south.setLocation('+');
			path.push(south);
		}
		if(y+1<board[0][0].length && board[z][x][y+1].getLocation() != '@') {
			Tile east = board[z][x][y+1];
			east.setLocation('+');
			path.push(east);
		}
		if(y-1>0 && board[z][x][y-1].getLocation() != '@') {
			Tile west = board[z][x][y-1];
			west.setLocation('+');
			path.push(west);
		}
	}
	
}
