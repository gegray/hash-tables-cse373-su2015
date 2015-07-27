package providedCode;

/**
 * Interface for a data structure that allows you to count the number of times
 * you see each piece of data. Although you will be using this interface only
 * with Strings, we have made the code generic and your data structures will
 * follow the "function object" approach. This approach is important when you do
 * HashTable, because you need to implement your own hashcode using a Hasher
 * object.
 */
public abstract class DataCounter {

	/**
	 * Increment the count for a particular data element.
	 * 
	 * @param data
	 *            data element whose count to increment.
	 */
	public abstract void incCount(String data);

	/**
	 * The number of unique data elements in the structure.
	 * 
	 * @return the number of unique data elements in the structure.
	 */
	public abstract int getSize();

	/**
	 * The current count for the data, 0 if it is not in the counter.
	 */
	public abstract int getCount(String data);

	/**
	 * Clients must not increment counts between an iterator's creation and its
	 * final use. Data structures need not check this.
	 * 
	 * @return an iterator for the elements.
	 */
	public abstract SimpleIterator getIterator();

	/**
	 * @return string representation of the DataCounter, as the order returned
	 *         by its iterator
	 */
	public String toString() {
		SimpleIterator itr = getIterator();
		StringBuffer b = new StringBuffer();
		while (itr.hasNext()) {
			b.append("(");
			DataCount next = itr.next();
			b.append(next.data);
			b.append(", ");
			b.append(next.count);
			b.append(")");
		}
		return b.toString();
	}
}
