
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
		
		path.add(board, z, x, y);
		
	
		while(path.size() > 0) {
			Tile move = path.pop();
			if(findW(board,z,move.getRow(),move.getCol())) {
				moves.push(move);
				break;
			}
//			if(path.size()>1) {
//				
//				
//				
//				//moves.add(board,z,move.getRow(),move.getCol());
//				moves.push(move);
//				System.out.println("Size: " + moves.size() + " " + size);
//				System.out.println("Moves: " + move.getRow() + " " + move.getCol());
//				Stack temp = moves;
//
//				while( moves.size()>size) {
//					if(findS(board,z,moves.peek().getRow(),moves.peek().getCol())) {
//						
//						return moves;
//					}
//					
//					move = moves.pop();
//					
//					System.out.println(moves.toString());
//					moves.add(board, z, move.getRow(), move.getCol());
//					
//				}
//				temp = new Stack();
//				System.out.println(temp.toString());
//				path.pop();
//				continue;
//				
//			}
			
			
		
			moves.push(move);
			
			path.add(board, z, move.getRow(), move.getCol());
			
			
			
		
			
		}
		System.out.println(moves);
		Stack finalPath = new Stack();
		finalPath.push(moves.pop());
		while(moves.size() > 1) {
			Tile move = moves.pop();
			Tile nextMove = moves.peek();
			if(nextMove == null) {
				break;
			}
			while(Math.abs(move.getRow()-nextMove.getRow()) >0 || Math.abs(move.getCol()-nextMove.getCol()) > 0 ) {
				moves.pop();
				
			}
			finalPath.push(move);
		}
		
		
		finalPath.push(moves.pop());
		System.out.println(finalPath.toString());
		System.out.println(path);
//		if(temp.getLocation() == '|') {	
//			
//			getPath(board,z,x,y);
//		}
//		System.out.println(moves.size());
		
//		
		
		return finalPath;
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