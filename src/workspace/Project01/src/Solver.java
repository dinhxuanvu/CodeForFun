/* 
 * Solver.java 
 * 
 * Version: 
 *     $Id: Solver.java,v 1.1 2013/04/03 22:51:31 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: Solver.java,v $
 *     Revision 1.1  2013/04/03 22:51:31  vxd9797
 *     Initial Version
 *
 */

import java.util.List;
import java.util.ArrayList;

public class Solver {
	
	private List<List<Integer>> queue;
	
	/**	
	 * Solver constructor
	 */
	public Solver() {
		this.queue = new ArrayList<List<Integer>>();
	}
	
	/**	
	 * The solver takes the variable from Clock main function.
	 * Then the solver solves the clock puzzle using Breadth-first search.
	 * When the solution is found, solver will print out the step solution.
	 * 
	 */
	public void solvePuzzle (Puzzle p) {
		List<Integer> current = new ArrayList<Integer>(1);
		current.add(p.getStart());
		queue.add(current);
		boolean found = false;
		List<Integer> neighbor = new ArrayList<Integer>();
		int next;
		
		while (!queue.isEmpty() && !found) {
			current = queue.remove(0);
			neighbor = p.getNeighbors(current.get(current.size()-1));
			for (int i = 0; i < neighbor.size() && !found; ++i) {
				List<Integer> nextConfig = new ArrayList<Integer>(current);
				next = neighbor.get(i);
				nextConfig.add(next);
				if (next == p.getGoal()) {
					current = nextConfig;
					found = true;
				}
				else
					queue.add(nextConfig);
			}
		}
		if (found) {
			for (int i = 0; i < current.size(); ++i) {
				System.out.println("Step " + i + ": " + current.get(i));
			}
		}
		else
			System.out.println("There is not solutions.");
	}
}
