package shake_n_bacon;

import java.io.IOException;

import providedCode.*;

/**
 * @author <name>
 * @UWNetID <uw net id>
 * @studentID <id number>
 * @email <email address>
 * 
 *        TODO: REPLACE this comment with your own as appropriate.
 * 
 *        This should be done using a *SINGLE* iterator. This means only 1
 *        iterator being used in Correlator.java, *NOT* 1 iterator per
 *        DataCounter (You should call dataCounter.getIterator() just once in
 *        Correlator.java). Hint: Take advantage of DataCounter's method.
 * 
 *        Although you can share argument processing code with WordCount, it
 *        will be easier to copy & paste it from WordCount and modify it here -
 *        it is up to you. Since WordCount does not have states, making private
 *        method public to share with Correlator is OK. In general, you are not
 *        forbidden to make private method public, just make sure it does not
 *        violate style guidelines.
 * 
 *        Make sure WordCount and Correlator do not print anything other than
 *        what they are supposed to print (e.g. do not print timing info, input
 *        size). To avoid this, copy these files into package writeupExperiment
 *        and change it there as needed for your write-up experiments.
 */
public class Correlator {

	public static void main(String[] args) {
		// TODO: Compute this variance
		double variance = 0.0;
		// IMPORTANT: Do not change printing format. Just print the double.
		System.out.println(variance);
	}
}
