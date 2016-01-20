/* 
 * Clock.java 
 * 
 * Version: 
 *     $Id: Clock.java,v 1.1 2013/04/03 22:51:31 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: Clock.java,v $
 *     Revision 1.1  2013/04/03 22:51:31  vxd9797
 *     Initial Version
 *
 */

import java.util.ArrayList;

public class Clock implements Puzzle {
	
	private int hours, start, goal;
	
	/**	
	 * Clock constructor
	 */
	public Clock(int hours, int start, int goal) {
		this.hours = hours;
		this.start = start;
		this.goal = goal;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public int getGoal() {
		return goal;
	}

	/**	
	 * Generate the neighbors of the config and add them to the ArrayList.
	 */
	@Override
	public ArrayList<Integer> getNeighbors(int config) {
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		int next = config + 1;
		int previous = config - 1;
		
		if (next > hours) {
			next = 1;
		}
		
		if (previous < 1) {
			previous = hours;
		}
		result.add(previous);
		result.add(next);
		return result;
	}

	/**
	 * The main method for the Clock. It reads in variable hours, start and goal
	 * from command line.  It will use the Solver class to solve the puzzle.
	 *
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java Clock hours start goal");
			return;
		}
		
		int hours = Integer.parseInt(args[0]);
		int start = Integer.parseInt(args[1]);
		int goal = Integer.parseInt(args[2]);
		
		Clock clock = new Clock(hours, start, goal);
		Solver solver = new Solver();
		
		solver.solvePuzzle(clock);
	}

}
