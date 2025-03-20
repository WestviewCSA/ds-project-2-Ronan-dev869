
public class runner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mazes = new Map("src/test1");
		Wolverine wol = new Wolverine(mazes.getX(), mazes.getY(), 0);
		System.out.println(wol.getX() + " " + wol.getY() + " " + wol.getZ());
		stackMove s = new stackMove(wol.x,wol.y);
		Stack<Tile> moves = s.getPath(mazes.getMap(), wol.getZ(), wol.getX(),wol.getY());
//		if(moves.peek().getLocation() == '|') {
//			wol = mazes.getPlayer(wol.getZ()+1);
//		}
		
		
		System.out.println(mazes.toString());
	}

}
