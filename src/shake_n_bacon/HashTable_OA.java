package shake_n_bacon;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
 *        TODO: Replace this comment with your own as appropriate.
 * 
 *        1. You may implement HashTable with open addressing discussed in
 *        class; You can choose one of those three: linear probing, quadratic
 *        probing or double hashing. The only restriction is that it should not
 *        restrict the size of the input domain (i.e., it must accept any key)
 *        or the number of inputs (i.e., it must grow as necessary).
 * 
 *        2. Your HashTable should rehash as appropriate (use load factor as
 *        shown in the class).
 * 
 *        3. To use your HashTable for WordCount, you will need to be able to
 *        hash strings. Implement your own hashing strategy using charAt and
 *        length. Do NOT use Java's hashCode method.
 * 
 *        4. HashTable should be able to grow at least up to 200,000. We are not
 *        going to test input size over 200,000 so you can stop resizing there
 *        (of course, you can make it grow even larger but it is not necessary).
 * 
 *        5. We suggest you to hard code the prime numbers. You can use this
 *        list: http://primes.utm.edu/lists/small/100000.txt NOTE: Make sure you
 *        only hard code the prime numbers that are going to be used. Do NOT
 *        copy the whole list!
 * 
 *        TODO: Develop appropriate tests for your HashTable.
 */
public class HashTable_OA extends DataCounter {
	private Comparator<String> comp; // string comparator
	private Hasher hashr;            // hash function
	private int[] primesList;        // list of primes (~double up to ~200,000)
   private int primesListIndex;     // index of current hash table size
   private DataCount[] hashTable;   // hash table (as array)
   private int size;                // number of entered elements

	public HashTable_OA(Comparator<String> c, Hasher h) {
		// TODO: To-be implemented
      comp = c;
		hashr = h;
		primesList = new int[]{13, 29, 61, 127, 257, 521, 1049, 2099, 4201, 8419,
                             16843, 33703, 67409, 134837, 269683};
      primesListIndex = 0;
      hashTable = new DataCount[primesListIndex];
	}

	@Override
	public void incCount(String data) {
		// TODO Auto-generated method stub
      
	}
   
   /**
    * Returns an integer value for the number of words in the hash table. 
    * Repeated words are only recorded once.
    */
	@Override
	public int getSize() {
		return size;
	}

   /**
    * Returns an integer value for the number of times the word has been recorded
    * in the hash table.
    */
	@Override
	public int getCount(String data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SimpleIterator getIterator() {
		// TODO Auto-generated method stub
      SimpleIterator iteratr = new SimpleIterator() {
         
      };
		return iteratr;
	}
   
   private double getLoadFactor() {
      return (double) size / hashTable.length;
   }
   
   private boolean isHalfLoaded() {
      return getLoadFactor() > 0.5;
   }
   
   private void doubleCapacity() {
      SimpleIterator iteratr = getIterator();
   }

}