package writeupExperiment;

import providedCode.*;

import shake_n_bacon.*;

import java.io.IOException;

/**
 * A modified version of WordCount used to test the runtime of hashing 
 * all the strings in a given file
 */
public class WordCountTester {
	
	//Using a simpleIterator to iterate through a datacounter to
	//store an iterable list that can be printed
	private static DataCount[] getCountsArray(DataCounter counter) {
		DataCount[] alt = new DataCount[counter.getSize()];
		SimpleIterator tempIterator = counter.getIterator();
		int index = 0;
		while (tempIterator.hasNext()) {
			alt[index] = tempIterator.next();
			index++;
		}
		return alt;
	}

	// ////////////////////////////////////////////////////////////////////////
	// /////////////// DO NOT MODIFY ALL THE METHODS BELOW ///////////////////
	// ////////////////////////////////////////////////////////////////////////

	private static void countWords(String file, DataCounter counter) {
		try {
			FileWordReader reader = new FileWordReader(file);
			String word = reader.nextWord();
			while (word != null) {
				counter.incCount(word);
				word = reader.nextWord();
			}
		} catch (IOException e) {
			System.err.println("Error processing " + file + " " + e);
			System.exit(1);
		}
	}

	/*
	 * Print error message and exit
	 */
	private static void usage() {
		System.err
				.println("Usage: [-s | -o] <filename of document to analyze>");
		System.err.println("-s for hashtable with separate chaining");
		System.err.println("-o for hashtable with open addressing");
		System.exit(1);
	}

	/**
	 * Entry of the program
	 * 
	 * @param args
	 *            the input arguments of this program
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			usage();
		}

		String firstArg = args[0].toLowerCase();
		DataCounter counter = null;
		if (firstArg.equals("-s")) {
			counter = new HashTable_SC(new StringComparator(),
					new StringHasher());
		} else if (firstArg.equals("-o")) {
			counter = new HashTable_OA(new StringComparator(),
					new StringHasher());
		} else {
			usage();
		}

		countWords(args[1], counter);
		DataCount[] counts = getCountsArray(counter);
	}
}
