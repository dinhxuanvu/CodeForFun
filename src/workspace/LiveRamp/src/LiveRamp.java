import java.util.ArrayList;
import java.util.Scanner;


public class LiveRamp {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean exit = false;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to my Cover Letter!");
		while (!exit) {
			System.out.println("\nChoices are");
			System.out.println("1. Technical background.");
			System.out.println("2. Working experiences.");
			System.out.println("3. More about me!");
			System.out.print("What would you like to do? ");
			int choice = in.nextInt();
			System.out.println();
			if (choice == 1) {
				System.out.println("Here are the my skills:");
				TechnicalBackground();
			} else if (choice == 2) {
				WorkingExp();
			} else if (choice == 3) {
				
			} else {
				exit = true;
				System.out.println("Thanks for looking at my Cover Letter.");
			}
		}
	}
	
	public static void TechnicalBackground() {
		
		ArrayList<String> tech = new ArrayList<String>();
		tech.add("Programming Languages: MIPS & HCS12 Assembly, VHDL, Verilog, C, C++, C#, Java.");
		tech.add("Software: Visual Studio, Eclipse IDE, Microsoft Office, Google Docs, CodeWarrior, SolidWorks.");
		
		for (int i = 0; i < tech.size(); i++) {
			System.out.println(tech.get(i));
		}
	}
	
	private static void WorkingExp() {
		
		ArrayList<String> exp = new ArrayList<String>();
		exp.add("Currently: Teaching Assistant at Rochester Institute of Technology.");
		exp.add("I'm teaching Assembly Programming Language and Digital Systems Design.");
		exp.add("Recently: Test and Software Engineer Co-op at JADAK Technologies");
		exp.add("I developed test applications to automate test plans on barcode cameras.");
		
		for (int i = 0; i < exp.size(); i++) {
			System.out.println(exp.get(i));
		}
	}
}