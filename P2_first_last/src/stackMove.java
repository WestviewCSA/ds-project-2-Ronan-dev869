
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
	
	public void getPath(Tile[][][] board, int z, int x, int y ){
		Stack moves = new Stack();
		
		path.push(board, z, x, y);
		
	
		while(path.size() > 0) {
			Tile move = path.pop();
			if(findW(board,z,move.getRow(),move.getCol())) {
				moves.push(move);
				break;
			}

			
			
		
			moves.push(move);
			
			path.push(board, z, move.getRow(), move.getCol());
			
			
			
		
			
		}
		
		
		while(moves.size() > 1) {
			Tile move = moves.pop();
			
			System.out.println((move.getRow()-moves.peek().getRow()) + " " + (move.getCol()-moves.peek().getCol()));
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1) {
				System.out.println("Yes");
				moves.pop();
				
			}
			move.setLocation('+');
		}
		moves.peek().setLocation('+');
		
		
	

		
		
	}
	
//	public Stack testBranch(Tile[][][] board, Tile start, int z) {
//		Stack branch = new Stack();
//		Stack tempPath = new Stack();
//	
//		branch.add(board, z, start.getRow(), start.getCol());
//		while(branch.size()>0) {
//			if(findS(board,z,start.getRow(),start.getCol())) {
//				return tempPath;
//			}
//			Tile move = branch.pop();
//			tempPath.push(move);
//			branch.add(board, z, move.getRow(), move.getCol());
//		}
//		branch.push(start);
//		return branch;
//		
//	}
	public boolean findW(Tile[][][] board, int z, int x, int y) {
		if(x-1>0 && (board[z][x-1][y].getLocation() == '$' || board[z][x-1][y].getLocation() == '|' )) {
			return true;
		}
		if(x+1<board[0].length && ( board[z][x+1][y].getLocation() == '$' || board[z][x+1][y].getLocation() == '|')) {
			return true;
		}
		if(y-1>0 && ( board[z][x][y-1].getLocation() == '$' || board[z][x][y-1].getLocation() == '|')) {
			return true;
		}
		if(y+1<board[0][0].length && (  board[z][x][y+1].getLocation() == '$' || board[z][x][y+1].getLocation() == '|')) {
			return true;
		}
		return false;
	}
	
}