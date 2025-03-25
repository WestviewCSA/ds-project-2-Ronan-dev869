import java.util.ArrayList;

public class runner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mazes = new Map("src/test1");
		ArrayList<Wolverine> wol = mazes.getPlayer();
		System.out.println( wol.get(0).getX() + " " +  wol.get(0).getY());
		wol.get(0).Stack(mazes.getMap(), 0, wol);
//		if(moves.peek().getLocation() == '|') {
//			wol = mazes.getPlayer(wol.getZ()+1);
//		}
		
		System.out.println(mazes.toString());
	}

}
