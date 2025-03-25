import java.util.ArrayList;

public class runner{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoorMap mazes = new CoorMap("src/coordinateTest1");
		ArrayList<Wolverine> wol = mazes.getPlayer();
		long start = System.nanoTime();
		wol.get(0).stack(mazes.getMap(), 0, wol);
		long end = System.nanoTime();
		System.out.println(end-start);
//		if(moves.peek().getLocation() == '|') {
//			wol = mazes.getPlayer(wol.getZ()+1);
//		}
		
		System.out.println(mazes.toString());
	}

}
