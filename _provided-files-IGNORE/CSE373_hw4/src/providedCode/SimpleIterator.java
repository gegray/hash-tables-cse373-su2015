package providedCode;

/**
 * Interface for a simpler iterator for returning DataCount elements from a
 * DataCounter one at a time. We do not use Java's iterators because we don't
 * want to obey all the rules for correct iterators.
 */
public interface SimpleIterator {
	/**
	 * @return next element in collection
	 * @throws java.util.NoSuchElementException
	 *             if no next element
	 */
	public DataCount next();

	/**
	 * @return whether there are more elements to iterate through
	 */
	public boolean hasNext();
}
