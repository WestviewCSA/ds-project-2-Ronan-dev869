import java.util.ArrayList;

public class Wolverine {
	public int x;
	public int y;
	public int z;
	private ArrayList<String> res;
	public Wolverine(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		res = new ArrayList<String>();
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
	public void stack(Tile[][][] board, int z, ArrayList<Wolverine> wol){
		Stack path = new Stack();
		Stack moves = new Stack();
		Wolverine wolverine = wol.get(z);
		path.push(board, z, wolverine.getX(), wolverine.getY());
		
		boolean exist = false;
		while(path.size() > 0) { // find all possible moves
			Tile move = path.peek();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				exist = true;
				moves.push(move);
				break; // end loop once the wolverine buck is found
			}
			path.pop();
			moves.push(move);	//add the moves to a possible moves stack	
			path.push(board, z, move.getRow(), move.getCol());			
		}
		if(!exist) { // no wolverine buck terminates 
			System.out.println("Wolverine Store is Closed");
			System.exit(-1);
		}
		char sym  = '+'; // what to set the possible moves to
		boolean found = false; // found W (needed if W can go multiple ways)
		ArrayList<String> res = new ArrayList<String>(); // store coor output for later
		while(moves.size() > 1) {
			Tile move = moves.pop();
			if(findW(board,z,move.getRow(),move.getCol())) { // if found W end and set the respective tile to being a correct move
				
				move.setLocation('+');
				res.add("+ " + move.getRow() + " " + move.getCol() + " " +  z + " "+ "\n"); // add move to coor out
				sym='.'; // everything should be turned back to the walkway
				break;
			}
			//if move isn't immeditely adjacent to W remove and set to '.' as it can't be reached
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0 || Math.abs(move.getCol()-moves.peek().getCol())>1|| Math.abs(move.getRow()-moves.peek().getRow())>1 ) {
				if(found) { // if W is found will set other paths to '.' prevents multiple adjacent + to W
					moves.pop().setLocation('.');
					break;
				}
				if(findW(board,z,moves.peek().getRow(),moves.peek().getCol())) { // break out of loop once W is found (if found in the next tile)
					
					sym = '.';
					found = true;
					break;
				}
				moves.pop().setLocation('.');;
				
			}
			move.setLocation(sym);
			if(sym == '+') {
				res.add("+ " + move.getRow() + " " + move.getCol() + " " + z + "\n");
			}

		}
		
		while(moves.size()>0) { // if moves still has stuff empty completely and set to sym
			Tile move = moves.pop();
			move.setLocation(sym);
			if(sym == '+') {
				res.add("+ " + move.getRow() + " " + move.getCol() + " " + z + "\n");
			}
		}
		
		
		Tile end = path.pop(); // be $ or | for the end
		
		while(path.size() > 0 ) { // empty path into walkables
			Tile temp = path.pop();
			if(temp.getLocation() != '+') {
				temp.setLocation('.');
			}
			
		}
		this.res.addAll(res); // add the rooms moves to the overall coor output
		if(end.getLocation() == '|') {
			stack(board,z+1,wol); // move up if it was a door
		}
		
		
	}
	public void queue(Tile[][][] board, int z, ArrayList<Wolverine> wol){
		Queue path = new Queue();
		Queue moves = new Queue();
		Wolverine wolverine = wol.get(z);
		path.enqueue(board, z, wolverine.getX(), wolverine.getY());
		
		boolean exist = false;
		while(path.size() > 0) { // same function as the stack
			Tile move = path.peek();
			if(path.findS(board,z,move.getRow(),move.getCol())) {
				exist = true;
				moves.enqueue(move);
				break;
			}	
			path.dequeue();
			moves.enqueue(move);		
			path.enqueue(board, z, move.getRow(), move.getCol());	
			
		}
		if(!exist) {
			System.out.println("Wolverine Store is Closed");
			System.exit(-1);
		}
		
		moves = moves.reverse(); // due to how a queue works in order to backtrack reverse the queue
		
		char sym  = '+';
		boolean found = false;
		
		ArrayList<String> res = new ArrayList<String>();
		
		while(moves.size() > 1) { // same as the stack
			Tile move = moves.dequeue();
			
			if(findW(board,z,move.getRow(),move.getCol())) {
				
				move.setLocation('+');
				res.add("+ " + move.getRow() + " " + move.getCol()  + " " + z + "\n");
				sym='.';
				break;
			}
			while(Math.abs(move.getRow()-moves.peek().getRow()) >0 && Math.abs(move.getCol()-moves.peek().getCol()) > 0  || Math.abs(move.getCol()-moves.peek().getCol())>1 || Math.abs(move.getRow()-moves.peek().getRow())>1) {
				
				if(found) {
					moves.dequeue().setLocation('.');
					break;
				}
				if(findW(board, z, move.getRow(), move.getCol())) {

					sym = '.';
					found = true;
					
				
					break;
				}
				moves.dequeue().setLocation('.');
			}
			
			move.setLocation(sym);
			if(sym == '+') {
				res.add("+ " + move.getRow() + " " + move.getCol() + " " + z + "\n");
				
			}
			
		} 
		
		while(moves.size()>0) {
			Tile move = moves.dequeue();
			
				move.setLocation(sym);
			if(sym == '+') {
				res.add("+ " + move.getRow() + " " + move.getCol() + " " + z + "\n");
			}
		}
		
		
		path = path.reverse(); // reverse to see what the end item was
		Tile end = path.dequeue();
		while(path.size() > 1 ) {
			path.dequeue().setLocation('.');
		}
		this.res.addAll(res);
		if(end.getLocation() == '|') {
			queue(board,z+1,wol);
		}
		
}
	
	public void optimize(Tile[][][] board, int z, ArrayList<Wolverine> wol) { // stack is usually faster than queue or marginally slower
		stack(board,z,wol);
	}
	
	public ArrayList<String> reverse(ArrayList<String> unFlip){ //reverse room (needed for coor output)
		ArrayList<String> end = new ArrayList<String>();
		for(int i = unFlip.size()-1; i>=0; i--) {
			end.add(unFlip.get(i));
		}
		return end;
	}
	public boolean findW(Tile[][][] board, int z, int x, int y) { // check adjacent tiles for W
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
	public void getRes(int z, int start, int roomCount) { // coordinate output
		
		if(z>roomCount-1) {
			
			return;
		}
		else {
			ArrayList<String> room = new ArrayList<String>();
			int end = 0;
			
			for(int i = start; i<res.size()-1; i++) {
				int move = Integer.parseInt(res.get(i).substring(res.get(i).length()-2,res.get(i).length()-1)); // check room # of respective and next line
				
				int move2 = Integer.parseInt(res.get(i+1).substring(res.get(i+1).length()-2,res.get(i+1).length()-1));
				if(move!=move2) {
					//break if room change is detected, add respective move to room
					room.add(res.get(i));
					end = i;
					break;
				}
				room.add(res.get(i));
				end = i;
			}
			
			
			if(Math.abs(end-res.size()) == 2) { // as the end add last move to room
				room.add(res.get(res.size()-1));
			}
			room = reverse(room); // reverse room moves so that it goes W to $ instead of $ to W
			for(int i = 0; i<room.size();i++) {
				System.out.print(room.get(i)); // print
			}
			getRes(z+1,end+1,roomCount); // continue until out of rooms
		}
		
	}
}
