import java.util.ArrayList;

public class Queue{
	private ArrayList<Tile> data;
	private ArrayList<Tile> res;
	public Queue() {
		data = new ArrayList<Tile>();
		res = new ArrayList<Tile>();
		
	}
	
	/*
	 * add to queue
	 */
	
	public void enqueue(Tile el) {
		data.add(el);
		
		
	}
	
	public Tile dequeue() {
		
		
		Tile t = data.remove(0);
		 
		return t;
	}
public void add(Tile[][][] board, int z, int x, int y) {
		
		if(x-1>0 && nullMove(board,z,x-1,y)) {
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
		if(y-1>0 &&nullMove(board,z,x,y-1)) {
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
		if(x-1>0 && (board[z][x-1][y].getLocation() == '$' ||board[z][x-1][y].getLocation() == '|')) {
			data.add(board[z][x-1][y]);
			return true;
		}
		if(x+1<board[0].length && (board[z][x+1][y].getLocation() == '$'||board[z][x+1][y].getLocation() == '|')) {
			data.add(board[z][x+1][y]);
			return true;
		}
		if(y-1>0 && (board[z][x][y-1].getLocation() == '$'|| board[z][x][y-1].getLocation() == '|')) {
			data.add(board[z][x][y-1]);
			return true;
		}
		if(y+1<board[0][0].length && (board[z][x][y+1].getLocation() == '$'||board[z][x][y+1].getLocation() == '|')) {
			data.add(board[z][x][y+1]);
			return true;
		}
		return false;
	}
	public int size() {
		
		return data.size();
	}
	
	public Queue reverse() {
		Queue temp = new Queue();
		for(int i = data.size()-1; i>=0; i--) {
			temp.enqueue(data.get(i));
		}
		return temp;
	}
	
	public Tile peek() {
		if(size() == 0) {
			return null;
		}
		return data.get(0);
	}
	
	public boolean empty() {
		return size() == 0;
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
