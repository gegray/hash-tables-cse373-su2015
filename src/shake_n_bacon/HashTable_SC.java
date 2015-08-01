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
 *        1. You may implement HashTable with separate chaining discussed in
 *        class; the only restriction is that it should not restrict the size of
 *        the input domain (i.e., it must accept any key) or the number of
 *        inputs (i.e., it must grow as necessary).
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
public class HashTable_SC extends DataCounter {
	private int size;
	private Comparator<String> comp;
	private Hasher hashr;
	private int[] primesList;
	private int listPos;
	private Node[] arrayHash;
	
	private class Node {
		public DataCount data;
		public Node next;
		
		public Node(DataCount data) {
			this(data, null);
		}
		
		public Node(DataCount data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public HashTable_SC(Comparator<String> c, Hasher h) {
		comp = c;
		hashr = h;
		
		primesList = new int[]{11, 23, 47, 97, 199, 401, 809, 1607, 3019, 6043,
   				12097, 24203, 48409, 97001, 200003};
		
		arrayHash = new Node[primesList[0]];
		listPos = 1;
	}

	@Override
	public void incCount(String data) {
		if((size/arrayHash.length) == 1){
			sizeUp();
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getCount(String data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SimpleIterator getIterator() {
		return null;
	}
	
	private void sizeUp() {
		
	}

}