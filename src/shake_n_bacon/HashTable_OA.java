package shake_n_bacon;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
 * The HashTable_OA class is a hash table with open addressing and linear
 * probing. This class supports up to ~200,000 unique elements, duplicates 
 * are handled by incrementing a count. 
 */
public class HashTable_OA extends DataCounter {
	private Comparator<String> comp; // string comparator
	private Hasher hashr;            // hash function
	private int[] primesList;        // list of primes (~double up to ~200,000)
   private int primesListIndex;     // index of current hash table size
   private DataCount[] hashTable;   // hash table (as array)
   private int size;                // number of entered elements
   
   /**
    * Constructs a new HashTable_OA object.
    */
	public HashTable_OA(Comparator<String> c, Hasher h) {
      comp = c;
		hashr = h;
		primesList = new int[]{13, 29, 61, 127, 257, 521, 1049, 2099, 4201, 8419,
                             16843, 33703, 67409, 134837, 269683};
      primesListIndex = 0;
      hashTable = new DataCount[primesList[primesListIndex]];
      size = 0;
	}

   /**
    * Adds the passed string to the hash table. If the provided string was not 
    * found in the table, a new data count is added. Otherwise, increments the 
    * count of the string in the current hash table. 
    */
	@Override
	public void incCount(String data) { 
      if (isHalfLoaded()) { 
         doubleCapacity();
      }
      int hIndex = hashr.hash(data) % hashTable.length;
      if (hashTable[hIndex] == null) { 
         hashTable[hIndex] = new DataCount(data, 1);
         size++;
      } else {
         boolean found = false;
         int incr = 1;
         while (!found) { 
            if (hashTable[hIndex] == null) { 
               DataCount d = new DataCount(data, 1);
               hashTable[hIndex] = d;
               size++;
               found = true;
            } else if (comp.compare(hashTable[hIndex].data, data) == 0) {
               hashTable[hIndex].count++;
               found = true;
            } else {
               hIndex = (hashr.hash(data) + incr) % hashTable.length; 
               incr++;
            }	
         }
      }
   }
   
   /**
    * Returns an integer value for the number of unique words in the hash table. 
    */
	@Override
	public int getSize() {
		return size;
	}

   /**
    * Returns an integer value for the number of times the word has been recorded
    * in the hash table. Returns 0 if the string was not found.
    */
	@Override
	public int getCount(String data) {
      int hIndex = hashr.hash(data) % hashTable.length;
      int incr = 1;
      boolean found = false;
      if (hashTable[hIndex] != null) {
         String curr = hashTable[hIndex].data;
         while (!found) {
            if (comp.compare(curr, data) == 0) {
               found = true;
               return hashTable[hIndex].count;
            } else {
               hIndex = (hashr.hash(data) + incr) % hashTable.length;
               if (hashTable[hIndex] == null) {
                  found = true;
                  return 0;
               } else {
                  curr = hashTable[hIndex].data;
                  incr++;
               }
            }
         }
      }
		return 0;
	}

   /**
    * Returns a new iterator object for this hash table. next() returns the next 
    * value in the hash table. hasNext() returns whether or not the hash table 
    * has another value after the value currently being referenced. 
    */
	@Override
	public SimpleIterator getIterator() {
      SimpleIterator itr = new SimpleIterator() {
         DataCount[] tempHashTable = hashTable;
         int index = 0;
         int tempSize = size;
         
         @Override
         public DataCount next() {
            if (!hasNext()) {
               return null;
            } else {
               DataCount d = tempHashTable[index];
               while (d == null) {
                  index++;
                  d = tempHashTable[index];
               }
               index++;
               tempSize--;
               return d;
            }
         }
         
         @Override
         public boolean hasNext() {
            return tempSize > 0;
         }
      };
      return itr;
	}
   
   /**
    * Returns whether or not the hash table is, roughly, over half filled.
    */
   private boolean isHalfLoaded() {
      double loadFactor = (double) size / hashTable.length;
      return loadFactor > 0.5;
   }
   
   /**
    * Resizes the hash table to roughly double capacity. Maximum capacity is 
    * ~200,000.
    */
   private void doubleCapacity() {
      SimpleIterator itr = getIterator();
      primesListIndex++;
      hashTable = new DataCount[primesList[primesListIndex]];
      size = 0;
      while (itr.hasNext()) {
         DataCount d = itr.next();
         for (int i = 0; i < d.count; i++) {
            incCount(d.data);
         }
      }
   }

}