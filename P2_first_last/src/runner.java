
public class runner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mazes = new Map("src/test1");
		Wolverine wol = new Wolverine(mazes.getX(), mazes.getY(), mazes.getZ());
		//System.out.println(wol.getX() + " " + wol.getY() + " " + wol.getZ());
//		while(moves.size() >0) {
//			Tile move = moves.pop();
//			mazes.setTile(move.getRow(), move.getCol(), 0, move.getLocation());
//		}
		mazes.getMap().toString();
	}

}
