package shake_n_bacon;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
**/

//Creates a hash table that uses separate chaining to implement
//the data structure
public class HashTable_SC extends DataCounter {
	//Declare global fields
	private int size;
	private Comparator<String> comp;
	private Hasher hasher;
	private int[] primesList;
	private int listPos;
	private Node[] arrayHash;
	
	//Private class of nodes for a linked list
	private class Node {
		public DataCount data;
		public Node next;
		
		//Constructor that takes in 1 argument,
		//which is just the data input
		public Node(DataCount data) {
			this(data, null);
		}
		
		//Constructor that takes 2 arguments, the data and a next field
		//Creates a new node to put into the hash table
		public Node(DataCount data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//Constructor that takes 2 arguments,
	//A comparator and a hasher
	//Creates a seperate chained hash table
	public HashTable_SC(Comparator<String> c, Hasher h) {
		//Initialize the hasher and comparator to global scope
		comp = c;
		hasher = h;
		
		//Create a list of primes from resizing and hashing
		primesList = new int[]{13, 29, 61, 127, 257, 521, 1049, 2099, 4201, 8419,
   				16843, 33703, 67409, 134837, 269683};
		
		//Create the hash table and update the list position for the
		//list of primes
		arrayHash = new Node[primesList[0]];
		listPos += 1;
	}

	@Override
	public void incCount(String data) {
		if(size == arrayHash.length){
			sizeUp();
		}
		int index = (hasher.hash(data) % arrayHash.length);
		if (arrayHash[index] == null) {
			arrayHash[index] = new Node(new DataCount(data, 1), null);
			size++;
		} else {
			Node curr = arrayHash[index];
			boolean found = false;
			while (curr != null) {
				if (comp.compare(curr.data.data, data) == 0) {
					found = true;
					curr.data.count++;
				}
				curr = curr.next;
			}
			if (!found) {
				DataCount count = new DataCount(data, 1);
				Node add = new Node(count);
				add.next = arrayHash[index];
				arrayHash[index] = add;
				size++;
			}
		}
	}

	//Return the size of the table as an int
	@Override
	public int getSize() {
		return size;
	}
	
	//Get's the count of the frequency of
	//a word as the passed in argument.
	//Returns the count of the value as an int
	@Override
	public int getCount(String data) {
		int index = hasher.hash(data) % arrayHash.length;
		Node curr = arrayHash[index];
		while (curr != null) {
			if (comp.compare(curr.data.data, data) == 0) {
				return curr.data.count;
			}
			curr = curr.next;
		}
		return 0;
	}

	//Creates an iterator to traverse the hash table
	@Override
	public SimpleIterator getIterator() {
		SimpleIterator iterator = new SimpleIterator() {
			int index = 0;
			int tempSize = size;
			int tempIndex = index;
			Node[] data = arrayHash;
			Node curr = arrayHash[index];
			
			//Method returns the next node in the hash table
			public DataCount next() {					
				while (index < (data.length - 1) && data[index] == null) {							
					index++;	
				}
				if (tempIndex < index) {
					curr = data[index];
					tempIndex = index;
				}
				DataCount val = curr.data;
				curr = curr.next;
				if (curr == null) {
					index++;
				}
				tempSize--;			
				return val;
			}	
			
			//Method that returns true if the node has a child,
			//and false if it does not
			public boolean hasNext() {			
				return tempSize > 0;
			}
		};
		return iterator;
	}
	
	//Doubles the size of the Hash Table 
	//to a near prime, and adds the values into the table
	private void sizeUp() {
		size = 0;
		SimpleIterator tempIt = getIterator();
		arrayHash = new Node[primesList[listPos]];
		listPos++;
		while (tempIt.hasNext()) {
			DataCount val = tempIt.next();
			for (int i = 0; i < val.count; i++) {
				incCount(val.data);
			}
		}
	}

}