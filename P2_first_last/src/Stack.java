import java.util.ArrayList;

public class Stack {
	
	private ArrayList<Tile> data;
	
	public Stack() {
		data = new ArrayList<Tile>();
	}
	
	
	
	public void push(Tile el) {
		data.add(el);
	}
	
	public void push(Tile[][][] board, int z, int x, int y) {
		if(findS(board,z,x,y)) {
			return;
		}
		if(x-1>=0 && nullMove(board,z,x-1,y)) {
			Tile north = board[z][x-1][y];
			north.setLocation('P');
			data.add(north);
		}
		if(x+1<board[0].length &&nullMove(board,z,x+1,y)) {
			Tile south = board[z][x+1][y];
			south.setLocation('P');
			data.add(south);
		}
		if(y+1<board[0][0].length && nullMove(board,z,x,y+1)) {
			Tile east = board[z][x][y+1];
			east.setLocation('P');
			data.add(east);
		}
		if(y-1>=0 &&nullMove(board,z,x,y-1)) {
			Tile west = board[z][x][y-1];
			west.setLocation('P');
			data.add(west);
		}
	}
	
	public boolean nullMove(Tile[][][] board, int z, int x, int y) {
		char[] noMove = new char[4];
		noMove[0] = '@';
		noMove[1] = 'P';
		noMove[2] = 'W';
		noMove[3] = '$';
		
		for(int i = 0; i<noMove.length; i++) {
			if(board[z][x][y].getLocation() == noMove[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean findS(Tile[][][] board, int z, int x, int y) {
		if(x-1>=0 && (board[z][x-1][y].getLocation() == '$' ||board[z][x-1][y].getLocation() == '|')) {
			data.add(board[z][x-1][y]);
			return true;
		}
		if(x+1<board[0].length && (board[z][x+1][y].getLocation() == '$'||board[z][x+1][y].getLocation() == '|')) {
			data.add(board[z][x+1][y]);
			return true;
		}
		if(y-1>=0 && (board[z][x][y-1].getLocation() == '$'|| board[z][x][y-1].getLocation() == '|')) {
			data.add(board[z][x][y-1]);
			return true;
		}
		if(y+1<board[0][0].length && (board[z][x][y+1].getLocation() == '$'||board[z][x][y+1].getLocation() == '|')) {
			data.add(board[z][x][y+1]);
			return true;
		}
		return false;
	}
	public Tile pop() {
		if(data.size() == 0) {
			return null;
		}
		return data.remove(data.size()-1);
	}
	 
	public Tile peek() {
		if(data.size() == 0) {
			return null;
		}
		return data.get(data.size()-1);
	}
	public int size() {
		return data.size();
	}
	
	public String toString() {
		String res = "[";
		for(int i = 0; i<size(); i++) {
			res += data.get(i).getRow() + " " + data.get(i).getCol() + " ";
		}
		res+="]";
		return res;
	}

}
