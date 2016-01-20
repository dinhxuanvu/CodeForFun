/**
 * Snowflake.java
 * 
 * File:
 * 		$Id: Snowflake.java,v 1.1 2013/03/13 15:48:06 vxd9797 Exp $
 * 
 * Revisions:
 * 		$Log: Snowflake.java,v $
 * 		Revision 1.1  2013/03/13 15:48:06  vxd9797
 * 		Second Version
 *
 * 
 */

/**
 * The program draws a snow flake
 * 
 * @author Vu Dinh
 *
 */
import java.util.Scanner;

public class Snowflake {

	private static final int LIMIT = 3;
	// Initialize the graphics
	public static Turtle init(int S) {
		int width = (int) Math.ceil((double)S * LIMIT);
		int height = width;
		Turtle t = new Turtle(width/2, height/2, 0); // Create new object t from class Turtle
		t.setWorldCoordinates(0, 0, width, height);
		return t;
	}
	
	private static void snowflakePart(int S, int N, Turtle t) {
		// If N is greater than 0
		if(N > 0) {
			// Move the turtle forward S units
			t.goForward(S);
			// If N is greater than 1
			if(N > 1) {
				// Turn turtle to left 120
				t.turnLeft(120);
				// Loop 5 times
				for(int i = 0;i<5;i++) {
					// Call snowflakePart
					Snowflake.snowflakePart(S/3, N-1, t);
					// Turn turtle right 60
					t.turnRight(60);
				}
				// Turn turtle right 180
				t.turnRight(180);
			}
			// Turn turtle left 180
			t.turnLeft(180);
			// Turn turtle forward S units
			t.goForward(S);
			// Turn turtle right 180
			t.turnRight(180);
		}
	}
	// Procedure drawSnowflake
	public static void drawSnowflake(int S, int N, Turtle t) {
		// Loop 6 times for the branches of the snow flake
		for(int i = 0;i<6;i++) {
			Snowflake.snowflakePart(S, N, t);
			t.turnLeft(60);
		}
	}
	// Main function
	public static void main(String[] args) {
		// Initialize S and N
		int S = 0, N = 0;
		// Get the inputs for S and N
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter S: ");
		S = input.nextInt();
		
		System.out.printf("Enter N: ");
		N = input.nextInt();
		
		// Call t object from Turtle class
		Turtle t = Snowflake.init(S);
		Snowflake.drawSnowflake(S, N, t);
		// Display the snow flake using StdDraw class
		StdDraw.show();
	}

}
