import java.util.ArrayList;

public class Wolverine {
	public int x;
	public int y;
	public int z;
	
	public Wolverine(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
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
	public void stack(Tile[][][] board, int z, ArrayList<Wolverine> wol ){
		Stack path = new Stack();
		Stack moves = new Stack();
		Wolverine wolverine = wol.get(z);
		path.push(board, z, wolverine.getX(), wolverine.getY());
		
	
		while(path.size() > 0) {
			Tile move = path.peek();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				//System.out.println("Yes");
				path.push(move);
				moves.push(move);
				break;
			}
			path.pop();
			moves.push(move);		
			path.push(board, z, move.getRow(), move.getCol());			
		}
		//moves.pop();
		//System.out.println(moves.toString());
//		System.out.println(path.toString());
		char sym  = '+';
		boolean found = false;
		while(moves.size() > 1) {
			Tile move = moves.pop();
			if(findW(board,z,move.getRow(),move.getCol())) {
				System.out.println(move.getRow() + " " + move.getCol());
				move.setLocation('+');
				//sym='.';
				break;
			}
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0 || Math.abs(move.getCol()-moves.peek().getCol())>1|| Math.abs(move.getRow()-moves.peek().getRow())>1 ) {
				if(found) {
					moves.pop().setLocation('.');
					break;
				}
				if(findW(board,z,moves.peek().getRow(),moves.peek().getCol())) {
					
					sym = '.';
					found = true;
					break;
				}
				moves.pop().setLocation('.');;
				
			}
			move.setLocation(sym);
//			if(found) {
//				break;
//			}
			//move.setLocation('+');
		}
		while(moves.size()>1) {
			moves.pop().setLocation('.');
		}
		System.out.println(path.toString());
		//System.out.println(moves.peek().getLocation());
		
		
			moves.pop().setLocation('.');
		
		//System.out.println(path.toString());
		Tile end = path.pop();
		//System.out.println(path.toString());
		while(path.size() > 0 ) {
			Tile temp = path.pop();
			if(temp.getLocation() != '+') {
				temp.setLocation('.');
			}
			
		}
		if(end.getLocation() == '|') {
			stack(board,z+1,wol);
		}
		
		
	}
	public void queue(Tile[][][] board, int z, ArrayList<Wolverine> wol ){Queue path = new Queue();
	Queue moves = new Queue();
	Wolverine wolverine = wol.get(z);
	path.enqueue(board, z, wolverine.getX(), wolverine.getY());
	

	while(path.size() > 0) {
		Tile move = path.peek();
		if(path.findS(board,z,move.getRow(),move.getCol())) {
			System.out.println("Yes");
			moves.enqueue(move);
			break;
		}	
		path.dequeue();
		moves.enqueue(move);		
		path.enqueue(board, z, move.getRow(), move.getCol());	
		
	}
	
	//moves.pop();
	moves = moves.reverse();
	String res = "";
	char sym  = '+';
	boolean found = false;
	moves.peek().setLocation('+');
	System.out.println(moves.toString());
	while(moves.size() > 1) {
		Tile move = moves.dequeue();
		//System.out.println(move.getRow() + " " + move.getCol());
		if(findW(board,z,move.getRow(),move.getCol())) {
			//System.out.println(move.getRow() + " " + move.getCol());
			move.setLocation('+');
			//sym='.';
			break;
		}
		while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1 || Math.abs(move.getRow()-moves.peek().getRow())>1) {
			//System.out.println(moves.peek().getRow() + " " + moves.peek().getCol());
			if(found) {
				moves.dequeue().setLocation('.');
				break;
			}
			if(findW(board, z, moves.peek().getRow(), moves.peek().getCol())) {
				System.out.println("Yes");
				//moves.peek().setLocation('+');
				sym = '.';
				found = true;
				res+="+ " + move.getRow() + " " + move.getCol();
				//moves.dequeue().setLocation('.');
				break;
			}
			moves.dequeue().setLocation('.');
		}
		System.out.println(moves.toString());
		move.setLocation(sym);
		res+= "+ " + move.getRow() + " " + move.getCol() + " " + z;
		res+="\n";
		//System.out.println(moves.toString());
	} 
	
	while(moves.size()>1) {
		
		
			moves.dequeue().setLocation(sym);
		
		//res+="+ " + move.getRow() + " " + move.getCol();
	}
	
	//System.out.println(path.toString());
	//System.out.println(res);
	System.out.println(path.toString());
//	while(path.size() > 1 ) {
//		path.dequeue().setLocation('.');
//	}
	path = path.reverse();
	Tile end = path.dequeue();
	if(end.getLocation() == '|') {
		queue(board,z+1,wol);
	}
	while(path.size() > 1 ) {
		path.dequeue().setLocation('.');
	}
	//System.out.println(res);
}
	
	public void optimize(Tile[][][] board, int z, ArrayList<Wolverine> wol) {
		stack(board,z,wol);
	}
	public boolean findStart(Tile[][][] board, int z, int x, int y) {
		boolean west = y-1>=0 && board[z][x][y-1].getLocation() == '+';
		if(west && (x+1<board[0].length && board[z][x+1][y].getLocation() == '+')) {
			return true;
		}
		else if(west && (x-1>=0 && board[z][x-1][y].getLocation() == '+')) {
			return true;
		}
		else if(west && (y+1<board[0][0].length && board[z][x][y-1].getLocation() == '+')) {
			return true;
		}
		return false;
	}
	public boolean findW(Tile[][][] board, int z, int x, int y) {
		if(x-1>0 && (board[z][x-1][y].getLocation() == 'W')) {
			
			return true;
		}
		if(x+1<board[0].length && (board[z][x+1][y].getLocation() == 'W')) {
			
			return true;
		}
		if(y-1>0 && (board[z][x][y-1].getLocation() == 'W')) {
			
			return true;
		}
		if(y+1<board[0][0].length && (board[z][x][y+1].getLocation() == 'W')) {
			
			return true;
		}
		return false;
	}
}
