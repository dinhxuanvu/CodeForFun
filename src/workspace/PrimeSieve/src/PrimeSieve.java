import java.util.Scanner;

/**
 * PrimeSieve.java
 * 
 * File:
 * 		$Id: PrimeSieve.java,v 1.1 2013/03/13 15:47:32 vxd9797 Exp $
 * 
 * Revisions:
 * 		$Log: PrimeSieve.java,v $
 * 		Revision 1.1  2013/03/13 15:47:32  vxd9797
 * 		Second Version
 *
 * 
 */

/**
 * The program generates the list of prime numbers
 * 
 * @author Vu Dinh
 *
 */
public class PrimeSieve {

	public static void main(String[] args) {
		
		while(true) {
		int n = 0;
		// Accept the input for n from
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		n = input.nextInt();
		
		// Call method findPrimes to find all prime number between 2 and n
		PrimeSieve.findPrimes(n);
		}
	}
	// findPrimes function
    public static void findPrimes(int n) {
    	
        boolean[] numPrime = new boolean[n + 1];
        
        System.out.println("Compute prime numbers from 2 to: " + n);
        
        // If n is smaller or equal to 1
        if(n <= 1) {
        	// Print the warning message
        	System.out.println("N must be greater than or equal to 2.");
        }
        else {
        
        // Generate the ArrayList of all number from 2 to n
        for(int i = 2; i <= n; i++) {    
        	// All numbers are prime
            numPrime[i] = true; 
        }                
        
        // Find prime numbers using Sieve of Eratosthenes
        for(int x = 2; x * x <= n; x++) {                                    
           if (numPrime[x]) {                   
                for(int i = x * 2; i <= n; i += x) {
                    numPrime[i] = false; 
                }
           }
        }
        
        // Print the prime numbers in the ArrayList
        for(int i = 2; i <= n; i++) {
        	if(numPrime[i]){
                System.out.print(i + " ");
        	}
        }
        System.out.println();
    }
                 
   }

}
