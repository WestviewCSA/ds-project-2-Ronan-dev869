
public class runner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mazes = new Map("src/test1");
		Wolverine wol = new Wolverine(mazes.getX(), mazes.getY(), mazes.getZ());
		System.out.println(wol.getX() + " " + wol.getY() + " " + wol.getZ());
		Stack<Tile> moves = new Stack<Tile>();
		moves = wol.getPath(mazes.getMap());
		System.out.println(moves);
		while(moves.size() >0) {
			Tile move = moves.pop();
		mazes.setTile(move.getRow(), move.getCol(), 0, move.getLocation());
		}
		System.out.println(mazes.toString());
	}

}
