
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
		add(board, z, x, y);
		Stack<Tile> moves = new Stack<Tile>();
		while(path.peek().getLocation() != '$') {
			Tile move = path.pop();
			System.out.println(move.getRow() + " " + move.getCol());
			moves.push(move);
			add(board,z,move.getRow(),move.getCol());
		}
		System.out.println(path.peek().getLocation());
//		if(temp.getLocation() == '|') {	
//			
//			getPath(board,z,x,y);
//		}
//		System.out.println(moves.size());	
//		int size = moves.size();
//		for(int i = 0; i<size; i++) {	
//			Tile temp = moves.pop();
//			System.out.println(temp.getRow() + " " + temp.getCol());
//		}
//		
		
		return path;
	}
	
	public void add(Tile[][][] board, int z, int x, int y) {
		
		if(x-1>0 && nullMove(board,z,x-1,y)) {
			Tile north = board[z][x-1][y];
			north.setLocation('P');
			path.push(north);
		}
		if(x+1<board[0].length &&nullMove(board,z,x+1,y)) {
			Tile south = board[z][x+1][y];
			//south.setLocation('P');
			path.push(south);
		}
		if(y+1<board[0][0].length && nullMove(board,z,x,y+1)) {
			Tile east = board[z][x][y+1];
			east.setLocation('P');
			path.push(east);
		}
		if(y-1>0 && nullMove(board,z,x,y-1)) {
			Tile west = board[z][x][y-1];
			west.setLocation('P');
			path.push(west);
		}
	}
	
	public boolean nullMove(Tile[][][] board, int z, int x, int y) {

		noMove[0] = '@';
		noMove[1] = 'P';
		noMove[2] = 'W';
	
		if(board[z][x][y].getLocation() == '$' || board[z][x][y].getLocation() == '|') {
			path.push(board[z][x][y]);
			return false;
		}
		for(int i = 0; i<noMove.length; i++) {
			
			if(board[z][x][y].getLocation() == noMove[i]) {
				return false;
			}
		}
		return true;
	}
}
