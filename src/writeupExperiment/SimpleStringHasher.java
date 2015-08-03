package writeupExperiment;

import providedCode.Hasher;

/**
* @author Geoff Gray, Austin Meyers
* @UWNetID gegray, arm38
* @studentID 1463717, 1228316
* @email gegray@uw.edu, arm38@uw.edu
* 
* Simple hash function for testing purposes. Should not be very good.
**/
public class SimpleStringHasher implements Hasher {

	//Method that hashes the value of a passed in string
	//Returns an int representing the hashed key
	@Override
	public int hash(String str) {
		int hashKey = 0;
		for(int i = 0; i <str.length(); i++){
			hashKey += Math.abs(str.charAt(i) - 'a');
		}
		return hashKey;
	}
}
