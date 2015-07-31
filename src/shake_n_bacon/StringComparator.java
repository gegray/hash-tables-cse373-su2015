package shake_n_bacon;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, <fill in>
 * @studentID 1463717, <fill in>
 * @email gegray@uw.edu, <fill in>
 * 
 *        TODO: REPLACE this comment with your own as appropriate.
 * 
 *        1. This comparator is used by the provided code for both data-counters
 *        and sorting. Because of how the output must be sorted in the case of
 *        ties, your implementation should return a negative number when the
 *        first argument to compare comes first alphabetically.
 * 
 *        2. Do NOT use any String comparison provided in Java's standard
 *        library; the only String methods you should use are length and charAt.
 * 
 *        3. You can use ASCII character codes to easily compare characters
 *        http://www.asciitable.com/
 * 
 *        4. When you are unsure about the ordering, you can try
 *        str1.compareTo(str2) to see what happens. Your
 *        stringComparator.compare(str1, str2) should behave the same way as
 *        str1.compareTo(str2). They don't have to return the same value, but
 *        their return values should have the same sign (+,- or 0).
 */
public class StringComparator implements Comparator<String> {

	/**
	 * TODO Replace this comment with your own as appropriate.
	 */
	@Override
	public int compare(String s1, String s2) {
		// TODO: To-be implemented
		return 0;
	}
}

// 80 char line limit, resize window to end at last "0"
// delete before turn-in
//345678901234567890123456789012345678901234567890123456789012345678901234567890