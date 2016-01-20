import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class VowelCounter {

	// HashSet to store all vowels
	private HashSet<Character> vowels;

	/**
	 * Constructor for VowelCounter
	 */
	public VowelCounter() {
		// Add vowels to HashSet
		vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
	}

	/**
	 * Main function to test the functionality of VowelCounter class
	 * 
	 * Usage: java [-Doutput=<output_file>] VowelCounter <input_file>
	 * Example: java -Doutput=Output.txt VowelCounter November.txt
	 */
	public static void main(String[] args) {

		// Variables for names of input and output files
		String inputFile = "";
		String outputFile = "";

		// Check if the there are enough arguments for command line
		if (args.length < 1) {
			System.err
					.println("Usage: java VowelCounter <input_file> [-Doutput=<output_file>]");
			System.err
					.println("Example: java VowelCounter November.txt -Doutput=Output.txt");
			System.exit(0);
		} else {
			// Get input file name
			inputFile = args[0].toString();
			// Check for output file name
			outputFile = System.getProperty("output");
		}

		// Create VowelCounter object
		VowelCounter vowelCounter = new VowelCounter();

		// Count vowels from a text file
		try {
			vowelCounter.VowelCount(inputFile, outputFile);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * The VowelCount method will read a text file and count number of vowels in
	 * each line of text. Then, print to console result.
	 * 
	 * This method will print out only lines with at least one vowel if output
	 * argument is entered in command line.
	 * 
	 * @param inputFile
	 *            the name of input text file (include extension .txt)
	 * @param outputFile
	 *            the name of output text file (include extension .txt)
	 */
	public void VowelCount(String inputFile, String outputFile)
			throws IOException {

		try {
			String line;
			int count = 0;
			int total = 0;
			
			// Writer to write the lines to text file
			PrintWriter output = null;
			// Reader to read the input text file
			BufferedReader reader = null;

			// Check if user includes file extension
			if (outputFile != "" && outputFile != null) {
				if (outputFile.contains(".txt")) {
					output = new PrintWriter(outputFile);
				} else
					output = new PrintWriter(outputFile + ".txt");
			}

			if (inputFile.contains(".txt")) {
				reader = new BufferedReader(new FileReader(inputFile));
			} else
				reader = new BufferedReader(new FileReader(inputFile + ".txt"));

			// Read the text file line by line
			while ((line = reader.readLine()) != null) {
				
				// Iterate through each character in line
				for (int i = 0; i < line.length(); i++) {
					// Compare with vowels in HashSet
					if (vowels.contains(line.charAt(i))) {
						// Increment the counter if vowels are detected
						count++;
					}
				}
				// Print the current line
				System.out.println(line);
				// Print the number of vowels in current line
				System.out.println("Number of vowels in line: " + count);
				// Write line with at least one vowel to new file if applicable
				if (count != 0 && output != null) {
					output.println(line);
				}
				// Update the total number of vowels
				total += count;
				// Reset vowel counter
				count = 0;
			}
			// Print the total number of vowels in text file
			System.out.println("Total number of vowels in file: " + total);
			// Close output stream
			if (output != null) {
				output.close();
			}
			// Close reader
			reader.close();
		} catch (IOException e) {
			// Throw IO Exception
			System.err.println(e.getMessage());
		}
	}
}
