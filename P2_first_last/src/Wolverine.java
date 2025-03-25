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
	public void Stack(Tile[][][] board, int z, ArrayList<Wolverine> wol ){
		Stack path = new Stack();
		Stack moves = new Stack();
		Wolverine wolverine = wol.get(z);
		path.add(board, z, wolverine.getX(), wolverine.getY());
		
	
		while(path.size() > 0) {
			Tile move = path.pop();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				moves.push(move);
				break;
			}		
			moves.push(move);		
			path.add(board, z, move.getRow(), move.getCol());			
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
			Stack(board,z+1,wol);
		}
		while(path.size() > 0 ) {
			path.pop().setLocation('.');
		}
		
	}
}
