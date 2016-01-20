/*
 * Solver.java
 *
 * Version:
 * $Id: Solver.java,v 1.2 2013/04/18 15:32:50 vxd9797 Exp $
 *
 * Revisions:
 * $Log: Solver.java,v $
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
 * This is a naive BFS solver that will be used to solve all three puzzles
 * in the CS project.
 * 
 * @author Giovanni Carvelli grc5969
 * @author Vu Dinh vxd9797
 *
 */
public class Solver <E>{

    /**
     * This is the solver method that solves the given puzzle configuration
     * 
     * @param puzzle The main puzzle that the solver will solve
     * @return map each config mapped to the config it came from
     */
    public HashMap<E,E> solve(Puzzle<E> puzzle) {
        //create a new queue
        ArrayList<E> queue = new ArrayList<E>();
        E current;
        boolean found = false;
        //create a new map (key = config, value = parent)
        HashMap<E,E> map = new HashMap<E,E>();
        //store all the checked configs
        ArrayList<E> checked = new ArrayList<E>();
        //set the first config to the starting position
        current = puzzle.getStart();

        //if the first location is the goal, set found to true
        if(puzzle.isGoal(current)){
            found = true;
            return map;
        }
        //add the first config to the queue
        queue.add(current);
     
        
        /*
         * NOTE: this queue operation checks the neighbors of the current and
         * then adds them to the list. Basically, all elements in the queue
         * have already been checked; it's the neighbors that need checking.
         */
        while(!queue.isEmpty() && !found){
            //catch the first element of queue
            current = queue.get(0);
            //then remove it
            queue.remove(0);
            for(E neighbor:puzzle.getNeighbors(current)){
                //add the neighbor to the map if it's not already there
                if(!map.containsKey(neighbor) && neighbor != puzzle.getStart()){
                    map.put(neighbor, current);
                }
                //if the neighbor is the goal
                if(puzzle.isGoal(neighbor)){
                    found = true;
                    break;
                }
                if(!checked.contains(neighbor)){
                    //otherwise if it hasn't already been checked add the neighbor to the queue
                    queue.add(neighbor);
                }
            }
            checked.add(current);
        }
        /* 
         * No matter what, the map gets returned. If the map is empty, the
         * start and goal locations are the same. If the goal location is not
         * in the map, it cannot be reached.
         */
        return map;
    }
}
