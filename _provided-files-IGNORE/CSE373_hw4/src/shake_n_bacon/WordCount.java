package shake_n_bacon;

import java.io.IOException;

import providedCode.*;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

	// TODO: Replace this comment with your own as appropriate.
	// Implement a method that returns an array of DataCount objects
	// containing each unique word.
	private static DataCount[] getCountsArray(DataCounter counter) {
		System.err.println("Must implement getCountsArray in WordCount");
		System.exit(1);
		return null;
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

	// IMPORTANT: Used for grading. Do not modify the printing *format*!
	private static void printDataCount(DataCount[] counts) {
		for (DataCount c : counts) {
			System.out.println(c.count + "\t" + c.data);
		}
	}

	/*
	 * Sort the count array in descending order of count. If two elements have
	 * the same count, they should be ordered according to the comparator. This
	 * code uses insertion sort. The code is generic, but in this project we use
	 * it with DataCount and DataCountStringComparator.
	 * 
	 * @param counts array to be sorted.
	 * 
	 * @param comparator for comparing elements.
	 */
	private static <E> void insertionSort(E[] array, Comparator<E> comparator) {
		for (int i = 1; i < array.length; i++) {
			E x = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (comparator.compare(x, array[j]) >= 0) {
					break;
				}
				array[j + 1] = array[j];
			}
			array[j + 1] = x;
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
		insertionSort(counts, new DataCountStringComparator());
		printDataCount(counts);
	}
}
