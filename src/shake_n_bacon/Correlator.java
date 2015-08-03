package shake_n_bacon;

import java.io.IOException;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
 * The Correlator class calculates word counts for two documents and uses each 
 * document's length to create normalized frequencies, ignoring words whose 
 * normalized frequencies (in either document) are too high or too low to be 
 * useful. Calculates a the difference metric, which corresponds to the square 
 * of the Euclidean distance between two vectors in the space of shared words 
 * in two documents. Note that this ignores any word that does not appear in 
 * both documents, which is probably the biggest weakness of this metric.
 * 
 */
public class Correlator {
   // frequency cutoff value for excluding abnormal values.
   // try changing for testing.
   public static final double LO_FREQ_CUTOFF = 0.0001;
   // frequency cutoff value for excluding abnormal values.
   // try changing for testing.
   public static final double HI_FREQ_CUTOFF = 0.01;

	public static void main(String[] args) {
      double variance = 0.0;
      DataCounter dc1 = null;
      DataCounter dc2 = null;
      StringComparator sc1 = new StringComparator();
      StringComparator sc2 = new StringComparator();
      StringHasher sh1 = new StringHasher();
      StringHasher sh2 = new StringHasher();
      
      if (args[0].equals("-s")) {
         dc1 = new HashTable_SC(sc1, sh1);
         dc2 = new HashTable_SC(sc2, sh2);
      } else if (args[0].equals("-o")) {
         dc1 = new HashTable_OA(sc1, sh1);
         dc2 = new HashTable_OA(sc2, sh2);
      } else {
         System.out.println("Bad args. Try again. ");
      }
      
      int wordCount1 = countWords(args[1], dc1);
      int wordCount2 = countWords(args[2], dc2);
      
      SimpleIterator itr = dc1.getIterator();
      while (itr.hasNext()) {
         DataCount tempdc = itr.next();
         String tempWord = tempdc.data;
         if (dc2.getCount(tempWord) > 0) {
            double freq1 = (double) tempdc.count / wordCount1;
            double freq2 = (double) dc2.getCount(tempWord) / wordCount2;
            if (isNotAnExtreme(freq1) && isNotAnExtreme(freq2)) {
               double freqDif = Math.abs(freq2 - freq1);
               variance += Math.pow(freqDif, 2);
            }
         }
      }
      
		// IMPORTANT: Do not change printing format. Just print the double.
		System.out.println(variance);
	}
   
   /**
    * Reads in a file as a string and counts them with the passed data counter.
    * Returns the total number of words in the file.
    */
   private static int countWords(String file, DataCounter counter) {
      int result = 0;
		try {
			FileWordReader reader = new FileWordReader(file);
			String word = reader.nextWord();
			while (word != null) {
				counter.incCount(word);
				word = reader.nextWord();
            result++;
			}
		} catch (IOException e) {
			System.err.println("Error processing " + file + " " + e);
			System.exit(1);
		}
      return result;
	}   
   /**
    * Returns whether or not either of the given percentages an extreme case
    * (greater than 1% or lesser than 0.01%)
    */
   private static boolean isNotAnExtreme(double d) {
      return (d > LO_FREQ_CUTOFF && d < HI_FREQ_CUTOFF);
   }
}
