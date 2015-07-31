package shake_n_bacon;

import providedCode.Hasher;

/**
 * @author Geoff Gray, Austin Meyers
 * @UWNetID gegray, arm38
 * @studentID 1463717, 1228316
 * @email gegray@uw.edu, arm38@uw.edu
 */
public class StringHasher implements Hasher {

	/**
	 * TODO Replace this comment with your own as appropriate.
	 */
	@Override
	public int hash(String str) {
		int hashKey = 0;
		for(int i = 0; i <str.length(); i++){
			hashKey += Math.abs(str.charAt(i) - 'a');
			hashKey *= 7;
			hashKey %= 200003;
		}
		return hashKey;
	}
}
