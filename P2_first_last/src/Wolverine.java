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
			Tile move = path.pop();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				moves.push(move);
				break;
			}		
			moves.push(move);		
			path.push(board, z, move.getRow(), move.getCol());			
		}
		//moves.pop();
		while(moves.size() > 1) {
			Tile move = moves.pop();
			
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1|| Math.abs(move.getRow()-moves.peek().getRow())>1) {
				moves.pop().setLocation('.');;
				
			}
			move.setLocation('+');
		}
		moves.pop().setLocation('+');
		Tile end = path.pop();
		if(end.getLocation() == '|') {
			stack(board,z+1,wol);
		}
		while(path.size() > 0 ) {
			path.pop().setLocation('.');
		}
		
	}
	public void queue(Tile[][][] board, int z, ArrayList<Wolverine> wol ){
		Queue path = new Queue();
		Queue moves = new Queue();
		Wolverine wolverine = wol.get(z);
		path.add(board, z, wolverine.getX(), wolverine.getY());
		
	
		while(path.size() > 0) {
			Tile move = path.dequeue();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				moves.enqueue(move);
				break;
			}		
			moves.enqueue(move);		
			path.add(board, z, move.getRow(), move.getCol());			
		}
		//moves.pop();
		moves = moves.reverse();
		String res = "";
		System.out.println(moves.toString());
		while(moves.size() > 1) {
			Tile move = moves.dequeue();
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1 || Math.abs(move.getRow()-moves.peek().getRow())>1) {
				System.out.println(moves.peek().getRow() + " " + moves.peek().getCol());
				if(findW(board, z, moves.peek().getRow(), moves.peek().getCol())) {
					move.setLocation('+');
					res+="+ " + move.getRow() + " " + move.getCol();
					moves.dequeue().setLocation('.');
					break;
				}
				moves.dequeue().setLocation('.');
			}
			move.setLocation('+');
			res+= "+ " + move.getRow() + " " + move.getCol() + " " + z;
			res+="\n";
		}
		//System.out.println(moves.toString());
		if(moves.size()>0) {
			moves.dequeue().setLocation('+');
			//res+="+ " + move.getRow() + " " + move.getCol();
		}
		//System.out.println(path.toString());
		System.out.println(res);
		System.out.println(path.toString());
		while(path.size() > 1 ) {
			path.dequeue().setLocation('.');
		}
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
		Stack path = new Stack();
		Stack moves = new Stack();
		Wolverine wolverine = wol.get(z);
		path.push(board, z, wolverine.getX(), wolverine.getY());
		int size = 0; 
	
		while(path.size() > 0) {
			Tile move = path.peek();
			if(path.size()>1) {
				moves.push(move);
				Stack temp = new Stack();
				temp = moves;
				System.out.println(moves.toString());
				while(moves.size()>size) {
					if(moves.findS(board, z, move.getRow(), move.getCol())) {
						System.out.println(move.getRow() + " " + move.getCol());
						
						break;
					}
					move = moves.pop();
					
					moves.push(board, z, move.getRow(), move.getCol());
					
				}
				System.out.println(moves.toString());
				temp = new Stack();
				path.pop();
				//System.out.println(moves.peek().getLocation());
				
				//continue;
			}
//			if((moves.peek().getLocation() == '$' || moves.peek().getLocation() == '|') && moves.size() != 0) {
//				break;
//			}
			path.pop();
			moves.push(move);
			//System.out.println(moves.toString());
			size++;
			path.push(board, z, move.getRow(), move.getCol());			
		}
		System.out.println(moves.toString());
		while(moves.size()>0) {
			moves.pop().setLocation('+');
		}
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
