
public class stackMove {
	private int x;
	private int y;
	private Stack path;
	private char[] noMove;
	
	public stackMove(int x, int y) {
		this.x = x;
		this.y = y;
		path = new Stack();
		noMove = new char[3];
		
	}
	
	public Stack getPath(Tile[][][] board, int z, int x, int y ){
		Stack moves = new Stack();
		Tile prev = new Tile();
		path.add(board, z, x, y);
		int size = 0;
	
		while(path.size() > 0) {
			Tile move = path.peek();
			
			if(path.size()>1&& size>1) {
				
				moves.add(board, z, move.getRow(), move.getCol());
				System.out.println(size);
				while(moves.size()>size) {
					if(findS(board,z,moves.peek().getRow(),moves.peek().getCol())) {
						return moves;
					}
					
					move = moves.pop();
					moves.add(board, z, move.getRow(), move.getCol());
				}
				
				path.pop();
				continue;
			}
			path.pop();
			size++;
			moves.push(move);
			System.out.println(moves.toString());
			path.add(board, z, move.getRow(), move.getCol());
			
			
		
			
		}
		

		System.out.println(path);
//		if(temp.getLocation() == '|') {	
//			
//			getPath(board,z,x,y);
//		}
//		System.out.println(moves.size());
		while(moves.size()>0) {
			moves.pop().setLocation('+');
		}
//		
		
		return path;
	}
	
	public Stack testBranch(Tile[][][] board, Tile start, int z) {
		Stack branch = new Stack();
		Stack tempPath = new Stack();
	
		branch.add(board, z, start.getRow(), start.getCol());
		while(branch.size()>0) {
			if(findS(board,z,start.getRow(),start.getCol())) {
				return tempPath;
			}
			Tile move = branch.pop();
			tempPath.push(move);
			branch.add(board, z, move.getRow(), move.getCol());
		}
		branch.push(start);
		return branch;
		
	}
	public boolean findS(Tile[][][] board, int z, int x, int y) {
		if(x-1>0 && board[z][x-1][y].getLocation() == '$') {
			return true;
		}
		if(x+1<board[0].length && board[z][x+1][y].getLocation() == '$') {
			return true;
		}
		if(y-1>0 && board[z][x][y-1].getLocation() == '$') {
			return true;
		}
		if(y+1<board[0][0].length && board[z][x][y+1].getLocation() == '$') {
			return true;
		}
		return false;
	}
	
}