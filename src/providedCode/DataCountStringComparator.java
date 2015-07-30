package providedCode;

import shake_n_bacon.*;

/**
 * A Comparator for DataCount that sorts two data-counts in the order we need
 * for the output of WordCount: Higher frequency comes first and frequency ties
 * are resolved in alphabetical order. Uses StringComparator, which you must
 * implement.
 */
public class DataCountStringComparator implements Comparator<DataCount> {
	private StringComparator alphabetical = new StringComparator();

	public int compare(DataCount c1, DataCount c2) {
		if (c1.count != c2.count) {
			return c2.count - c1.count;
		}
		return alphabetical.compare(c1.data, c2.data);
	}
}
