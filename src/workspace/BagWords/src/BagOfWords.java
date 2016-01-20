/**
 *
 * BagOfWords.java
 * 
 * $Id: BagOfWords.java,v 1.3 2013/11/20 05:31:47 vxd9797 Exp $
 *
 * $Log: BagOfWords.java,v $
 * Revision 1.3  2013/11/20 05:31:47  vxd9797
 * Final Version. Commented and tested.
 *
 * Revision 1.2  2013/11/20 03:28:32  vxd9797
 * Second Version.
 *
 * Revision 1.1  2013/11/20 02:53:12  vxd9797
 * Initial Revision
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * Computes and outputs the contents of a bag of words based on a given text file and file of stop words.
 * 
 * @author vxd9797
 */

public class BagOfWords {
	
	// Set contains all stop words
	HashSet<String> stopWords = new HashSet<String>();
	// Map contains all words in text file
	TreeMap<String,String> textWords = new TreeMap<String,String>();
	// A copy of all words in text file
	List<String> textCopy = new ArrayList<String>();
	
	/**
	 * Constructor loads and stores the stop words from the given file.
	 * @param stopfile - file name of stop words
	 */
	public BagOfWords (String stopfile) throws IOException, BagException {
		
		BagException bagE = new BagException("Bad stop word.");
		String word;
		// Scan the file and read the words one by one and then add them to the HashSet
		try {
			Scanner inStop = new Scanner(new File(stopfile));
			while(inStop.hasNext()) {
				word = inStop.next();
				
				String end = word.substring(word.length() - 1);

				// Check if there are any bad stop words with punctuation in the end.
				if (end.matches("[.,?!:;]"))
				{
					// Throw BafException
					throw bagE;
				}
				// Add to the HashTable stopWords
				stopWords.add(word);
			}
			// Close Scanner
			inStop.close();
		} catch (IOException e) {
			// Throw IO Exception
			throw e;
		}
	}
	
	/**
	 * Creates the sorted bag of words based on the given file.
	 * @param filename - file name of given file
	 */
	public void makeBag(String filename) throws IOException, BagException{
		
		BagException makeE = new BagException("No non stop words given.");
		
		// Scan the file and read the words one by one and then add them to the TreeMap
		try {
			Scanner inText = new Scanner(new File(filename));
			int stopCount = 0;
			while(inText.hasNext()) {
				String word = inText.next();
				word = word.toLowerCase();
				String end = word.substring(word.length() - 1);

				// Check the end of word for punctuation and eliminate the punctuation if needed
				if (end.matches("[.,?!:;]"))
				{
					word = word.substring(0, word.length() - 1);
				}
				
				// Ignore the stop words
				if (stopWords.contains(word))
				{
					stopCount++;
				}
				else
				{
					textWords.put(word, word);
					textCopy.add(word);
				}
			}
			// Throw exception if there is not stop words
			if (stopCount == 0) {
				throw makeE;
			}
			inText.close();
		}
		catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * Prints a representation of the bag to the given output stream. 
	 * Each word in the bag should be printed along with the number of times it appeared in the text file.
	 * @param out - OutputStream
	 */
	public void outputBag(OutputStream out) throws IOException {
		
		int countWord = 0;
		String current;
		
		// Print the words
		try {
			for (Map.Entry<String, String> entry : textWords.entrySet())
			{
				current = entry.getValue();

				// Check how many times the word has been repeated
				for(String check : textCopy) {
					if (current.equals(check))
						countWord++;
				}

				// Print out the word with repeat time
				String newStrLine = current + ": " + Integer.toString(countWord) + "\n"; 
				if (out == null) {
					System.out.print(newStrLine);
					countWord = 0;
				}
				else
				{
					byte[] byteStr = newStrLine.getBytes("UTF-8");
					out.write(byteStr);
					countWord = 0;
				}
			}
		}
		// Throw IO Exception when needed
		catch (IOException e) {
			throw e;
		}
	}

	/**
	 * Main method, creates a bag and fills it based on files named in the command-line arguments. 
	 * Prints to a file if a file name is given as the third command-line argument, otherwise prints to standard output.
	 * args - args[0]: name of file containing stop words, 
	 * args[1]: name of file containing text to parse, 
	 * args[2] (optional): name of file to print bag contents to.
	 */
	public static void main(String[] args) {

		// Check if the there are enough arguments for command line
		if (args.length < 2) {
			System.err.println("Usage: java BagOfWords STOP_WORD_FILE INPUT_TEXT [OUTPUT_FILE]");
			System.exit(0);
		}

		// Create a bag, read stop words, read text file and print the words to appreciate output (file or standard output)
		try {
			String fileStop = args[0].toString();
			String fileText = args[1].toString();
			OutputStream out = null;
			if (args.length > 2)
				out = new FileOutputStream(new File(args[2]));

			// Create bag of words
			BagOfWords newBag = new BagOfWords(fileStop);

			// Fill bag with words from text file
			newBag.makeBag(fileText);
				
			// Print out the words in bag
			newBag.outputBag(out);
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		// Throw exceptions if needed
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
