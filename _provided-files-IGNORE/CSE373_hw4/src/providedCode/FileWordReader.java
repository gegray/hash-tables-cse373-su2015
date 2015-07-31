package providedCode;

import java.io.*;

/**
 * FileWordReader reads words from a file one-by-one, converting to lower case
 * and eliminating punctuation.
 */
public class FileWordReader {
	private StreamTokenizer tok;

	public FileWordReader(String file) throws FileNotFoundException,
			IOException {
		tok = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				new FileInputStream(file))));
		tok.eolIsSignificant(false);
		tok.lowerCaseMode(true);
		tok.wordChars('a', 'z');
		tok.wordChars('A', 'Z');
		String punctuation = "!.;:-[],;!?*+-=\\|/(){}\"><'";
		for (int i = 0; i < punctuation.length(); i++) {
			tok.wordChars(punctuation.charAt(i), punctuation.charAt(i));
		}
	}

	public String nextWord() throws IOException {
		int ttype = tok.nextToken();
		while (ttype != StreamTokenizer.TT_WORD
				&& ttype != StreamTokenizer.TT_EOF) {
			ttype = tok.nextToken();
		}
		if (ttype == StreamTokenizer.TT_EOF) {
			return null;
		}
		// Remove punctuation, e.g., it's becomes its
		// removes everything except English letters (already lower-cased)
		String ans = tok.sval.replaceAll("[^a-z]", "");
		if (ans.length() > 0) {
			return ans;
		}
		return nextWord();
	}
}
