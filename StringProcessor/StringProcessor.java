public class StringProcessor 
{
	
	private String input;
	private char character;

	public StringProcessor()
	{
		input = new String();
	}
	public StringProcessor(String s)
	{
		input = s;
	}
	public void setString(String s)
	{
		input = s;
	}
	public String getString()
	{
		return input;
	}

	//The wordCount method determines the number of words a String has
	//@ return whiteSpaces
	public int wordCount()
	{
		char[] array_word = input.toCharArray();
		int whiteSpaces = 0;

		for(int i = 0; i < array_word.length; i++)
		{
			if(Character.isWhitespace(array_word[i]))
			{
				whiteSpaces++;
			}
		}
		return whiteSpaces + 1; 

	//or...if the digits, names starting with digits, symbols, or acronyms within the string are not counted as words:

		// boolean isWord = false;
		// int num_of_words = 0;
		// int lastWord = input.length() - 1;

		// for(int i = 0; i < input.length(); i++)
		// {
		// 	if(Character.isLetter(input.charAt(i)) && i != lastWord)
		// 	{
		// 		isWord = true;
		// 	}
		// 	else if(!Character.isLetter(input.charAt(i)) && isWord)
		// 	{
		// 		num_of_words++;
		// 		isWord = false;
		// 	}
		// 	else if(Character.isLetter(input.charAt(i)) && i == lastWord)
		// 	{
		// 		num_of_words++;
		// 	}
		// 
		// return num_of_words;
	}

	//The uppercaseCount method determines the number of upper case letters
	//@ return upperCase
	public int uppercaseCount()
	{
		char[] array_upperCase = input.toCharArray();
		int upperCase = 0;

		for(int y = 0; y < array_upperCase.length; y++)
		{
			if(Character.isUpperCase(array_upperCase[y]))
			{
				upperCase++;
			}
		}
		return upperCase;
	}

	//The digitCount method determines the number of digit characters ('0','1','2'...,'9')
	//@ return digits
	public int digitCount()
	{
		char[] array_digits = input.toCharArray();
		int digits = 0;

		for(int x = 0; x < array_digits.length; x++)
		{
			if(Character.isDigit(array_digits[x]))
			{
				digits++;
			}
		}
		return digits;
	}

	//The digitWordCount method determines the number of words that are English words 
		//representing the ten digits("zero", "one", "two",...,"nine")
	//@ return count
	public int digitWordCount()
	{
		String lowerCase = input.toLowerCase();
		int index;
		int count = 0;
		
		String[] digitWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		for(int z = 0; z < digitWord.length; z++)
		{
		   index = lowerCase.indexOf(digitWord[z]);
		   while(index != -1)
   	    	{
		      index = lowerCase.indexOf(digitWord[z], index + 1); 	
		      count++;  
	   		}
		}
		   return count;
	}

	//The getNoSpaceString method returns a String with all spaces removed
	//@ param input into StringBuilder 
	//@ return string 
	public String getNoSpaceString()
	{
		StringBuilder str = new StringBuilder(input);
		
		int position = input.indexOf(" ");
		int count = 0;
		int [] array = new int [str.length()];
		
		while (position != -1)
		{
			for(int c = 0; c == count; c++)
			{
				array[c] = position;
			}
			count++;
			position = input.indexOf(" ", position + 1);

			for(int a = 0; a < count; a++)
			{
				array[count] = position - count;
			}
	     }
		
		for(int y = 0; y < count; y++)
		{
			str.deleteCharAt(array[y]);
		}
		
		String string = str.toString();
		return string;

	//or....

		// String string = input.replaceAll("\\s+", "");
		// return string;
	}

	//The getNoVowelString method returns a String with all vowels replaced
		//by the dash character '_'
	//@ return string4 or string5
	public String getNoVowelString()
	{
		String lowercase = input.toLowerCase();		
		String string = lowercase.replace("a", "-");		
		String string1 = string.replace("e","-");
		String string2 = string1.replace("i", "-");
		String string3 = string2.replace("o", "-");
		String string4 = string3.replace("u", "-");
		return string4;

		// and sometimes 'y'...
		// String string5 = string4.replace("y", "-");
		// return string5;

	// or...
		
		// String string = input.replaceAll("[a,A,e,E,i,I,o,O,u,U]", "-");
		// return string;

	}

	//The getNoDigitWordString method returns a String with all English words
		//for digits replace by digit characters
	//@ return String
	public String getNoDigitWordString()
	{

		String lowercase = input.toLowerCase();
		String string = lowercase.replace("zero", "0");
		String string1 = string.replace("one","1");
		String string2 = string1.replace("two", "2");
		String string3 = string2.replace("three", "3");
		String string4 = string3.replace("four", "4");
		String string5 = string4.replace("five", "5");		
		String string6 = string5.replace("six","6");
		String string7 = string6.replace("seven", "7");
		String string8 = string7.replace("eight", "8");
		String string9 = string8.replace("nine", "9");
		return string9;

	// or...

		// String string = input.toLowerCase();
		// string = string.replaceAll("zero", "0");
		// string = string.replaceAll("one", "1");
		// string = string.replaceAll("two", "2");
		// string = string.replaceAll("three", "3");
		// string = string.replaceAll("four", "4");
		// string = string.replaceAll("five", "5");
		// string = string.replaceAll("six", "6");
		// string = string.replaceAll("seven", "7");
		// string = string.replaceAll("eight", "8");
		// string = string.replaceAll("nine", "9");
		// return string;	
	}

}
