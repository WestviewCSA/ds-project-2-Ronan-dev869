import java.util.ArrayList;

public class p2{
	private static boolean stack, queue, opt, time, inCoor, outCoor, help;
	private static Map maze;
	public static void setCommands(String arg) {
		if(arg.equals("--Stack")) {
			stack = true;
		}
		if(arg.equals("--Queue")) {
			queue = true;
		}
		if(arg.equals("--Opt")) {
			opt = true;
		}
		if(arg.equals("--Time")) {
			time = true;
		}
		if(arg.equals("--Incoordinate")) {
			inCoor = true;
		}
		if(arg.equals("--Outcoordinate")) {
			outCoor = true;
		}
		if(arg.equals("--Help")) {
			help = true;
		}
	}
	
	public static boolean validCommands() {
		boolean[] type = {stack, queue, opt};
		int c = 0;
		for(int i = 0; i<3; i++) {
			if(type[i]) {
				c++;
			}
		}
		if(c==1) {
			return true;
		}
		if(c!=1) {
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			for(int i = 0; i<args.length; i++) {
				setCommands(args[i]);
			}
			if(!validCommands()) {
				throw new IllegalCommandLineInputsException();
			}
			if(help) {
				String exp = "My program is meant to find the coin for the wolverine than back track, only pathing the moves that the wolverine can make.\n"
						+ "There 3 possible switches to be set for the type of method you want to use, only one can be selected at a time, there are input and output switches\n"
						+ "finally there is one to track time and there is this switch for help.";
				System.out.println(exp);
				System.exit(0);
			}
			if(inCoor) {
				maze = new CoorMap(args[args.length-1]);
			}
			else if( !inCoor){
				maze = new Map(args[args.length-1]);
			}
			ArrayList<Wolverine> wol = maze.getPlayer();
			if(time) {
				if(stack) {
					long start = System.nanoTime();
					wol.get(0).stack(maze.getMap(), 0, wol);
					long end = System.nanoTime();
					double seconds = (end-start) / Math.pow(10, 9);
					System.out.println("Total Runtime: " + seconds + " seconds");
				}
				if(queue) {
					long start = System.nanoTime();
					wol.get(0).queue(maze.getMap(), 0, wol);
					long end = System.nanoTime();
					double seconds = (end-start) / Math.pow(10, 9);
					System.out.println("Total Runtime: " + seconds + " seconds");
				}
				if(opt) {
					long start = System.nanoTime();
					wol.get(0).optimize(maze.getMap(), 0, wol);
					long end = System.nanoTime();
					double seconds = (end-start) / Math.pow(10, 9);
					System.out.println("Total Runtime: " + seconds + " seconds");
				}
			}
			else if(!time) {
				if(stack) {
					
					wol.get(0).stack(maze.getMap(), 0, wol);				}
				if(queue) {
					wol.get(0).queue(maze.getMap(), 0, wol);
				}
				if(opt) {
					wol.get(0).optimize(maze.getMap(), 0, wol);
				}
			}
			if(outCoor) {
				wol.get(0).getRes(0,0,maze.getMap().length);
			}
			
				System.out.println(maze.toString());
			
			
		}
		catch(IllegalCommandLineInputsException e) {
			System.out.println("You have given an invalid input, not setting input/output or more than one method. Please try again.");
			System.exit(-1);		
		}
	}

}
