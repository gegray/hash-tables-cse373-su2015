package writeupExperiment;
// Testing for StringComparator

public class TestStringComparator {
   public static void main (String[] args) {
      // Hello, Hello
      System.out.println("compareTo: 'Hello' and 'Hello'");
      String s1 = "Hello";
      System.out.println(s1.compareTo("Hello"));
      System.out.println("compare('Hello', 'Hello'): ");
      System.out.println(compare("Hello", "Hello"));
      
      // Hella, Hello
      System.out.println("compareTo: 'Hella' and 'Hello'");
      String s2 = "Hella";
      System.out.println(s2.compareTo("Hello"));
      System.out.println("compare('Hella', 'Hello'): ");
      System.out.println(compare("Hella", "Hello"));
      
      // Hell, Hello
      System.out.println("compareTo: 'Hell' and 'Hello'");
      String s3 = "Hell";
      System.out.println(s3.compareTo("Hello"));
      System.out.println("compare('Hell', 'Hello'): ");
      System.out.println(compare("Hell", "Hello"));
      
      // art, ar
      System.out.println("compareTo: 'art' and 'ar'");
      String s4 = "art";
      System.out.println(s4.compareTo("ar"));
      System.out.println("compare('art', 'ar'): ");
      System.out.println(compare("art", "ar"));
      
      // <empty>
      System.out.println("compareTo: '' and ''");
      String s5 = "";
      System.out.println(s5.compareTo(""));
      System.out.println("compare('', ''): ");
      System.out.println(compare("", ""));
      
      // <empty>, Hello
      System.out.println("compareTo: '' and 'Hello'");
      String s6 = "";
      System.out.println(s6.compareTo(""));
      System.out.println("compare('', 'Hello'): ");
      System.out.println(compare("", "Hello"));
      
      // Hello, <empty>
      System.out.println("compareTo: 'Hello' and ''");
      String s7 = "Hello";
      System.out.println(s7.compareTo(""));
      System.out.println("compare('Hello', ''): ");
      System.out.println(compare("Hello", ""));
   }
   
   public static int compare(String s1, String s2) {
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