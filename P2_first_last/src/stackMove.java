
public class stackMove {
	private int x;
	private int y;
	private Stack<Tile> path;
	private char[] noMove;
	
	public stackMove(int x, int y) {
		this.x = x;
		this.y = y;
		path = new Stack<Tile>();
		noMove = new char[3];
		
	}
	
	public Stack<Tile> getPath(Tile[][][] board, int z, int x, int y ){
		path.push(board[z][x][y]);
		add(board, z, x, y, 'P');
		Stack<Tile> moves = new Stack<Tile>();
		while(path.peek().getLocation() != '$') {
			Tile move = path.pop();
			System.out.println(move.getRow() + " " + move.getCol());
			moves.push(move);
			add(board,z,move.getRow(),move.getCol(), 'P');
			System.out.println(path);
		}
		
//		if(temp.getLocation() == '|') {	
//			
//			getPath(board,z,x,y);
//		}
//		System.out.println(moves.size());
		System.out.println(path.size());
		Tile temp = path.pop();
		add(board,z,temp.getRow(),temp.getCol(),'+');
		while(path.peek().getLocation() != 'W') {
			temp = path.pop();
			
		}
//		
		
		return path;
	}
	
	
	
	public void add(Tile[][][] board, int z, int x, int y, char type) {
		
		if(x-1>0 && nullMove(board,z,x-1,y, type)) {
			Tile north = board[z][x-1][y];
			north.setLocation(type);
			path.push(north);
		}
		if(x+1<board[0].length &&nullMove(board,z,x+1,y, type)) {
			Tile south = board[z][x+1][y];
			south.setLocation(type);
			path.push(south);
		}
		if(y+1<board[0][0].length && nullMove(board,z,x,y+1, type)) {
			Tile east = board[z][x][y+1];
			east.setLocation(type);
			path.push(east);
		}
		if(y-1>0 &&nullMove(board,z,x,y-1, type)) {
			Tile west = board[z][x][y-1];
			west.setLocation(type);
			path.push(west);
		}
	}
	
	public boolean nullMove(Tile[][][] board, int z, int x, int y, char type) {

		noMove[0] = '@';
		noMove[1] = type;
		noMove[2] = 'W';
	
		if(board[z][x][y].getLocation() == '$' || board[z][x][y].getLocation() == '|') {
			path.push(board[z][x][y]);
			return true;
		}
		for(int i = 0; i<noMove.length; i++) {
			if(board[z][x][y].getLocation() == noMove[i]) {
				return false;
			}
		}
		
		return true;
	}
}
