package providedCode;

/**
 * Simple class to hold a piece of data and its count. See also the return type
 * of the getIterator method of DataCounter.
 */
public class DataCount {
	/**
	 * The data element whose count we are recording.
	 */
	public String data;

	/**
	 * The count for the data element.
	 */
	public int count;

	/**
	 * Create a new data count.
	 * 
	 * @param data
	 *            the data element whose count we are recording.
	 * @param count
	 *            the count for the data element.
	 */
	public DataCount(String data, int count) {
		this.data = data;
		this.count = count;
	}
}
