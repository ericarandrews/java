
public class MoreValuedRecursionExamples {
	
	public static void main(String[] args) {
		
		System.out.println(createReverseString("abcde"));
		System.out.println(createReverseString("g"));
		System.out.println(createReverseString(""));
		System.out.println(createDuplicateString("abcde"));
		System.out.println(createReverseString2("abcde"));
		
		System.out.println("radar? " + isPalindrome("radar"));
		System.out.println("anna? " + isPalindrome("anna"));
		System.out.println("abab? " + isPalindrome("abab"));
		System.out.println("abb? " + isPalindrome("abb"));
		
	}
	
	public static String createReverseString(String text) {
		return createReverseStringHelper(text, text.length()-1);
	}
	private static String createReverseStringHelper(String text, int index) {
		if(index >= 0) {
			String currentCharacter = ""  + text.charAt(index);
			return currentCharacter + createReverseStringHelper(text, index-1);
		} else {
			return "";
		}
		
	}
	public static String createDuplicateString(String text) {
		return createDuplicateStringHelper(text, 0);
	}
	private static String createDuplicateStringHelper(String text, int index) {
		if(index < text.length()) {
			return text.charAt(index) + createDuplicateStringHelper(text, index+1);
		} else {
			return "";
		}
	}
	
	public static String createReverseString2(String text) {
		return createReverseStringHelper2(text, 0);
	}
	private static String createReverseStringHelper2(String text, int index) {
		if(index < text.length()) {
			return createReverseStringHelper2(text, index+1) + text.charAt(index);
		} else {
			return "";
		}
	}
	
	
	public static boolean isPalindrome(String text) {
		return isPalindromeHelper(text.toLowerCase(), 0, text.length()-1);
		
	}
	private static boolean isPalindromeHelper(String text, int first, int last) {
		if(first > last) {
			return true;
		} else if( text.charAt(first) == text.charAt(last)) {
			return isPalindromeHelper(text, first+1, last-1);
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	

}
