
public class FindStartLoopLinkedList {
	
	/*
	 * Solution:
	 * 1. Use tortoise and hare to detect of the linked list contains a loop.
	 * 
	 * 2. When two pointers meet, stop one and use the other one to increment
	 * one step at the time until they meet again. Keep count of number of steps
	 * as it's the length of the loop.
	 * 
	 * 3. Restart both pointers to ths start and then move the first pointers N times
	 * (N is the length of the loop). Then, increment two pointers one by one until
	 * they meet and that's where the loop starts.
	 */

}
