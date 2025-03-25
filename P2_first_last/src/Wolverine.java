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
			
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1) {
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
		moves.reverse();
		
		while(moves.size() > 1) {
			Tile move = moves.dequeue();
			
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 || Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1) {
				moves.dequeue().setLocation('.');;
				
			}
			move.setLocation('+');
		}
		System.out.println(moves.toString());
		moves.dequeue().setLocation('+');
		Tile end = path.dequeue();
		if(end.getLocation() == '|') {
			queue(board,z+1,wol);
		}
		while(path.size() > 1 ) {
			path.dequeue().setLocation('.');
		}
		
	}
}
