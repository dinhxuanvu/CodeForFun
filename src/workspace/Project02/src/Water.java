/*
 * Water.java
 *
 * Version:
 * $Id: Water.java,v 1.1 2013/04/18 16:31:20 vxd9797 Exp $
 *
 * Revisions:
 * $Log: Water.java,v $
 * Revision 1.1  2013/04/18 16:31:20  vxd9797
 * Final Version.
 *
 *
 */

import java.util.*;

/**
 * Water is a Puzzle implementing object that has a number of jugs. The solver
 * will find the solution to find the desire amount of water.
 * 
 * @author Giovanni Carvelli grc5969
 * @author Vu Dinh vxd9797
 *
 */


public class Water implements Puzzle<ArrayList<Integer>> {
	
	 	private int amount;
	 	private List<Integer> config = new ArrayList<Integer>();
	 	private List<Integer> jug = new ArrayList<Integer>();
	 	
	 	 /**
	     * Constructor for a water object.
	     * @param amount - the desire amount of water
	     * @param jug - the list of maximum amount of jugs
	     * 
	     */
	    public Water(int amount, List<Integer> jug){
	        this.amount = amount;
	        this.jug = new ArrayList<Integer>(jug);
	    }
	    
	    /**
	     * Returns the amount of water.
	     * @return amount - the desire amount of water
	     */
	    private Integer getGoal(){
	        return amount;
	    }
	    
	    /**
	     * Compare the goal and the config to determine if the goal is reached.
	     * @param config - the amount of water from the solver
	     * 
	     */
	    @Override
	    public boolean isGoal(ArrayList<Integer> config) {
	    	for (int i = 0; i < config.size(); i++) {
	    		if (config.get(i).equals(amount)) {
	    			return true;
	    		}
	    	}
			return false;
	    }
	    
	    /**
	     * The method to get the neighbors and add them neighbors into a array list of array list of integer.
	     * @return result - the array list of array list of integer
	     */
	    @Override
	    public ArrayList<ArrayList<Integer>> getNeighbors(ArrayList<Integer> config) {
	    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 	ArrayList<Integer> current;
		 	
		 	for (int i = 0; i < config.size(); i++) {
		 		
		 	// Dumping the water out and save it to result
		 	current = new ArrayList<Integer>(config);
		 	current.set(i, 0);
		 	result.add(current);
			
		 	// Filling up the jugs and save it to result
		 	current = new ArrayList<Integer>(config);
		 	current.set(i, jug.get(i));
		 	result.add(current);
		 	
		 	// Pouring the jug to each other jug
		 	for (int j = 0; j < config.size(); j++) {
		 		if (j != i) {
		 			current = new ArrayList<Integer>(config);
		 			int space;
		 			space = jug.get(j) - config.get(j);
		 			
		 			if (space > config.get(i)) {
		 				current.set(i, 0);
		 				current.set(j, config.get(j) + config.get(i));
		 			}
		 			else {
		 				current.set(j, jug.get(j));
		 				current.set(i, config.get(i) - space);
		 			}
		 			result.add(current);
		 		}
		 	}
		 }
		 	return result;
	  }

	    /**
	     * The method to get the starting array list of empty jugs for this puzzle.
	     * @return empty - the array list of empty jugs.
	     */
	    @Override
	    public ArrayList<Integer> getStart() {
	    	List<Integer> empty = new ArrayList<Integer>();
	        for (int i = 0; i < jug.size(); i++) {
	        	empty.add(0);
	        }
	        return (ArrayList<Integer>) empty;
	    }
	    /**
	     * The main program for a water. This is what is run when a water puzzle
	     * needs to be solved.
	     * 
	     * @param args command line arguments that provide the jug size, initial
	     * condition and goal
	     */
	    public static void main(String[] args){
	    	
	    	if (args.length < 2) {
	    		System.out.println("Usage: java Water amount jug1 jug2 ...");
	    		return;
	    	}
	    	
	    	ArrayList<Integer> jug = new ArrayList<Integer>();
	    	
	    	for (int i = 1; i < args.length; i++) {
	    		jug.add(Integer.parseInt(args[i]));
	    	}
	    	
	        //make a new water object based on the command line arguments
	        Water water = new Water(Integer.parseInt(args[0]), jug);
	        
	        //make a solver object
	        Solver<ArrayList<Integer>> solver = new Solver<ArrayList<Integer>>();
	        
	        //male a map object to solve the water
	        HashMap<ArrayList<Integer>, ArrayList<Integer>> map = solver.solve(water);
	        
	        if(map.isEmpty()){
	            //the map is empty, so the start and goal are the same
	            System.out.println("Step 0: " + water.getGoal());
	        }
	        else{
	            //just a normal solution
	            
	            /*
	             * The iteration through the map will be backwards, so I need to
	             * add all the steps to an ArrayList and iterate through it backwards
	             */
	        	ArrayList<Integer> current = null;
	        	
	        	for (ArrayList<Integer> config : map.keySet()) {
	        		if (water.isGoal(config)) {
	        			current = config;
	        			break;
	        		}
	        		
	        	}
	        	
	        	if (current == null) {
	        		System.out.print("No solution.");
	        	}
	        	else {
	            
	            ArrayList<ArrayList<Integer>> backwards = new ArrayList<ArrayList<Integer>>();
	            
	            while(!current.equals(water.getStart())){
	                backwards.add(current);
	                current = map.get(current);
	            }
	            
	            //make sure to add the start to the list, since it's not in the map
	            backwards.add(water.getStart());

	            //iterate through backwards, well, backwards
	            int j = 0;
	            for(int i=0; i < backwards.size(); i ++){
	                j = (backwards.size()-1) - i;
	                String output = "Step " + i + ":";
	                
	                for (int x = 0; x < jug.size(); x++) {
	                	output += " " + backwards.get(j).get(x);
	                }
	                System.out.println(output);
	            }
	        }
	    }
	 }
}
