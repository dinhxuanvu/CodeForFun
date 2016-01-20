/* 
 * Puzzle.java 
 * 
 * Version: 
 *     $Id: Puzzle.java,v 1.1 2013/04/03 22:51:31 vxd9797 Exp $ 
 * 
 * Revisions: 
 *     $Log: Puzzle.java,v $
 *     Revision 1.1  2013/04/03 22:51:31  vxd9797
 *     Initial Version
 *
 */

import java.util.ArrayList;

/**
 * Puzzle Interface
 * 
 * @author Vu Dinh (vxd9797)	
 *
 */

public interface Puzzle {
	
	public int getStart();
	public int getGoal();
	public ArrayList<Integer> getNeighbors(int config);
}
