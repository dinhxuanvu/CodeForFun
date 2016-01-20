/*
 * Clock.java
 *
 * Version:
 * $Id: Clock.java,v 1.2 2013/04/18 15:32:50 vxd9797 Exp $
 *
 * Revisions:
 * $Log: Clock.java,v $
 * Revision 1.2  2013/04/18 15:32:50  vxd9797
 * Final Version - Checked and modified the solver. Finished commenting the water.
 *
 * Revision 1.1  2013/04/17 21:26:50  vxd9797
 * Initial Version
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clock is a Puzzle implementing object that has a number of hours. The solver
 * will find the shortest path from one hour to another, allowing looping
 * from hour N to 1.
 * 
 * @author Giovanni Carvelli grc5969
 * @author Vu Dinh vxd9797
 *
 */
public class Clock implements Puzzle<Integer> {
    
    private int start;
    private int goal;
    private int N;
    
    /**
     * Constructor for a clock object.
     * @param start the start position of the puzzle
     * @param goal the final goal position
     * @param N "length" of the clock; number of positions it has
     */
    public Clock(int N, int start, int goal){
        this.start = start;
        this.goal = goal;
        this.N = N;
    }
    
    /**
     * Compare the goal and the config to determine if the goal is reached.
     * @param true or false depending on the comparison.
     * 
     */
    @Override
    public boolean isGoal(Integer config) {
        return goal == config;
    }
    
    /**
     * Returns the goal location. Used for the check at the end of Clock's main
     * function.
     * @return goal the goal config
     */
    private Integer getGoal(){
        return goal;
    }
    
    /**
     * The method to get the neighbors and add them neighbors into a array list.
     * @return returner - the array list of the neighbors
     */
    @Override
    public ArrayList<Integer> getNeighbors(Integer config) {
        ArrayList<Integer> returner = new ArrayList<Integer>();
        if(config-1 < 1){
            //if the lower bound is out of range, loop it back around
            returner.add(N);
        }
        else{
            //otherwise, just subtract one
            returner.add(config-1);
        }
        if(config+1 > N){
            //if the upper bound is out of range, loop it back around
            returner.add(1);
        }
        else{
            //otherwise, just add one
            returner.add(config+1);
        }
        return returner;
    }

    /**
     * The method to get the starting config for this puzzle.
     * @return start - the starting config.
     */
    @Override
    public Integer getStart() {
        return start;
    }
    /**
     * The main program for a clock. This is what is run when a clock puzzle
     * needs to be solved.
     * 
     * @param args command line arguments that provide the clock size, initial
     * condition and goal
     */
    public static void main(String[]args){
      //make sure that there are exactly 3 arguments, and if not exit the program
        if(args.length != 3){
           System.out.println("Usage: java Clock hours start goal");
           System.exit(1000);
        }
        //make a new clock object based on the command line arguments
        Clock clock = new Clock(Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]),Integer.parseInt(args[2]));
        //make a solver object
        Solver<Integer> solver = new Solver<Integer>();
        
        HashMap<Integer, Integer> map = solver.solve(clock);
                
        if(map.isEmpty()){
            //the map is empty, so the start and goal are the same
            System.out.println("Step 0: " + clock.getGoal());
        }
        else if(!map.containsKey(clock.getGoal())){
            //goal isn't in the map, so there is no solution
            System.out.println("No solution.");
        }
        else{
            //just a normal solution
            
            /*
             * The iteration through the map will be backwards, so I need to
             * add all the steps to an ArrayList and iterate through it backwards
             */
            Integer current = map.get(clock.getGoal());
            ArrayList<Integer> backwards = new ArrayList<Integer>();
            backwards.add(clock.getGoal());
            
            while(current != clock.getStart()){
                backwards.add(current);
                current = map.get(current);
            }
            
            //make sure to add the start to the list, since it's not in the map
            backwards.add(clock.getStart());
            
            //iterate through backwards, well, backwards
            int j = 0;
            for(int i=0; i < backwards.size(); i ++){
                j = (backwards.size()-1) - i;
                System.out.println("Step " + i + ": " + backwards.get(j));
            }
        }
    }
}
