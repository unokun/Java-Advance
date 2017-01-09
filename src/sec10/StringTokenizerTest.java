package sec10;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		
		
		
		String message = "a b c";
		for (String s : message.split(" ")) {
			System.out.println(s);
		}
		StringTokenizer tokenizer = new StringTokenizer(message, " ");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
	}

}
