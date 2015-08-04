package writeupExperiment;

import providedCode.*;
import shake_n_bacon.*;

public class HashTiming {
	public static void main(String[] args) {
		System.out.println("Num Tests = 100 Average time = " + getAverageRuntime(args, 100, 10) + " ms");
	}
	
	
	private static double getAverageRuntime(String[] args, int NUM_TESTS, int NUM_WARMUP) {
		 double totalTime = 0;
		 for(int i=0; i<NUM_TESTS; i++) {
			 long startTime = System.currentTimeMillis();
			 WordCountTester.main(args);
			 long endTime = System.currentTimeMillis();
			 if(NUM_WARMUP <= i) { // Throw away first NUM_WARMUP runs to encounter JVM warmup
				 totalTime += (endTime - startTime);
			 }
		 }	 
		 return totalTime / (NUM_TESTS-NUM_WARMUP); // Return average runtime.
	 }
}
