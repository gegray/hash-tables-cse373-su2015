package writeupExperiment;

import providedCode.*;
import shake_n_bacon.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
 * Debugging and testing both HashTable_SC and HashTable_OA.
 */
public class HashTableTest {
   public static final String[] words = {"blank", "one", "two", "three", 
                                         "four", "five"};

   public static void main(String[] args) {
      StringComparator c = new StringComparator();
      StringHasher h = new StringHasher();
      DataCounter sc = new HashTable_SC(c, h);
   	DataCounter oa = new HashTable_OA(c, h);
      
      System.out.println("Testing HashTable_SC: ");
      testDataCounter(sc);
      System.out.println("END Testing HashTable_SC");
      System.out.println();
      
      System.out.println("Testing HashTable_OA: ");
      testDataCounter(oa);
      System.out.println("END Testing HashTable_OA");
      System.out.println();
      
   }
   
   public static void testDataCounter(DataCounter dc) {
      // int numTests = 5;
      int countUnique = 0;
      int countAll = 0;
      for (int i = 1; i <= 5; i++) {
         for (int j = 1; j <= i; j++) {
            System.out.println("incCounting: " + words[i]);
            dc.incCount(words[i]);
            countAll++;
         }
         countUnique++;
      }
      System.out.println("Total unique words: " + countUnique);
      System.out.println("getSize method returns : " + dc.getSize());
      

      for (int i = 1; i <= 5; i++) {
         String word = words[i];
         System.out.println("Getting count of: '" + word + "'");
         System.out.println("Correct count is: " + i);
         System.out.println("getCount returns: " + dc.getCount(word));
      } 
      
      SimpleIterator itr = dc.getIterator();
      int itr8s = 0;
      while (itr.hasNext()) {
         DataCount curr = itr.next();
         itr8s++;
      }
      System.out.println("Total incCounts: " + countAll);
      System.out.println("Iterator found : " + itr8s);
   }
}