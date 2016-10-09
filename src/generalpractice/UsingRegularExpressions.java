package generalpractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsingRegularExpressions {

	public void Run() {
		definingARegex();
		findingInASequence();
		commonRegex();
	}

	// To see all the regular expressions check the javadoc of the Pattern Class
	private void commonRegex() {
		// This way of comparing, internally creates a Pattern, creates a Match and then compare
		// So it should be used when the regular expression is evaluated just once.
		System.out.println("[a-z]*, hello: " + Pattern.matches("[a-z]*", "hello")); // Any combination of lower-case characters
		System.out.println("[a-zA-Z]*, HelloWorld: " + Pattern.matches("[a-zA-Z]*", "HelloWorld")); // Any combination of lower-case and upper-case characters
		System.out.println("[^H][a-z]*, HelloWorld: " + Pattern.matches("[^H][a-z]*", "HelloWorld")); // Any combination of lower-case characters that does not start with H
		System.out.println("[a-d]*, aacabbcacd: " + Pattern.matches("[a-d]*", "aacabbcacd")); // Any combination of the characters a b c d
		System.out.println("[a-z&&[^rop]]*, apacabbcacd: " + Pattern.matches("[a-z&&[^rop]]*", "apacabbcacd")); // Any combination of lower-case characters but r, o, or p
		System.out.println("[abcd]*, aacabbcacd: " + Pattern.matches("[abcd]*", "aacabbcacd")); // Any combination of the characters a b c d
		System.out.println("..., and: " + Pattern.matches("...", "and")); // Any combination of 3 characters
		System.out.println("[aeiou]{3}, aee: " + Pattern.matches("[aeiou]{3}", "aee")); // Any vowels combination of 3 characters
		System.out.println("[aeiou]{2,}, aeeaaiii: " + Pattern.matches("[aeiou]{2,}", "aeeaaiii")); // Any vowels combination of at least 2 characters
	}

	public void definingARegex() {
		String regex = "x*y";
		String sequence = "xxxy";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sequence);

		System.out.println(sequence + " match " + regex + " :" + m.matches());

		sequence = "y";
		System.out.println(sequence + " match " + regex + " :" + p.matcher(sequence).matches());

		sequence = "XXY";
		System.out.println(sequence + " match " + regex + " :" + p.matcher(sequence).matches());

		p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		System.out.println(sequence + " match " + regex + " :" + p.matcher(sequence).matches());

		regex = "(?x) [a-z\\h]* # (?x) allows me to put a comment in the regex, everithing after # is ignored. it also ignore whitespace in the regex";
		sequence = "i want to see if this text does not include numbers or symbols";
		p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		System.out.println(sequence + " match " + regex + " :" + p.matcher(sequence).matches());

		// This expression simulates a comment I can only use words and number but I can use symbols after a comment '//'
		regex = "(?x) [\\w\\h]* | [\\w\\h]* // [\\p{ASCII}]*";
		// (?x) allows me to put spaces in the regex to be more legible
		// \w match with word character: [a-zA-Z_0-9]
		// \h match with horizontal whitespace character
		// | is an or, means that match the first expression or the second one. This is because I want the expression to be accepted if I have no comments
		// \p{ASCII} match with all ASCII

		sequence = "I am testing regular expressions // This is a comment! I can include symbols here...";
		p = Pattern.compile(regex);
		System.out.println(sequence + " match " + regex + " :" + p.matcher(sequence).matches());
	}

	private void findingInASequence() {
		String regex = "x";
		String sequence = "xggxs";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sequence);

		System.out.println("Match: " + m.matches()); // The sequence doesnt match the regex
		System.out.println("Find: " + m.find()); // The sequence contain the regex
		System.out.println("Index: " + m.start()); // The starting point of the regex
		System.out.println("Find again: " + m.find()); // The sequence contain the regex a second time
		System.out.println("Index: " + m.start()); // The starting point of the regex
	}

	public static void main(String[] args) {
		new UsingRegularExpressions().Run();

	}

}
