package shake_n_bacon;

import providedCode.Hasher;

/**
* @author Geoff Gray, Austin Meyers
* @UWNetID gegray, arm38
* @studentID 1463717, 1228316
* @email gegray@uw.edu, arm38@uw.edu
* 
* Hashes a string by adding the ASCII value of each
* character to its predeseccor, multiplying by a prime,
* and modding the value by the max expected number of
* string values.
**/
public class StringHasher implements Hasher {

	//Method that hashes the value of a passed in string
	//Returns an int representing the hashed key
	@Override
	public int hash(String str) {
		int hashKey = 0;
		for(int i = 0; i <str.length(); i++){
			hashKey += Math.abs(str.charAt(i) - 'a');
			hashKey *= 3;
			hashKey %= 269683;
		}
		return hashKey;
	}
}
