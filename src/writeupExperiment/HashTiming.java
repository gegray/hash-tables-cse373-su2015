package writeupExperiment;

import providedCode.*;
import shake_n_bacon.*;

public class HashTiming {
	public static void main(String[] args) {
		System.out.println("n = 100 time = " + getAverageRuntime(args, 100, 1));
		System.out.println("n = 1000 time = " + getAverageRuntime(args, 1000, 10));
		System.out.println("n = 10000 time = " + getAverageRuntime(args, 10000, 100));
		System.out.println("n = 100000 time = " + getAverageRuntime(args, 100000, 1000));
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
