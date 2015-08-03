package shake_n_bacon;

import providedCode.*;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 * 
 * The StringComparator class compares strings in order to find their relative 
 * alphabetical ordering.
 */
public class StringComparator implements Comparator<String> {
	/**
	 * Compares two input strings for alphabetic order (case-insensitive). 
    * Equal strings ("cat" and "cat" or "cat" and "CAT") return 0. 
    * Strings alphabetically prior others return a negative integer. 
    * Strings alphabetically after others return a positive integer.
	 */
	@Override
	public int compare(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		String s1lc = s1.toLowerCase();
		String s2lc = s2.toLowerCase();
		int minLen = Math.min(len1, len2);
		int i = 0;
		while (i < minLen) {
			int charCompare = s1lc.charAt(i) - s2lc.charAt(i);
			if (charCompare == 0) {
				i++;
			} else {
				return charCompare;
			}
		}
		if (len1 != len2) {
			return len1 - len2;
		}
		return 0;
	}
   
}