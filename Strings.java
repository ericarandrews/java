import java.util.Scanner;
public class Strings
{
	public static void main(String args[])
	{	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first string: ");
		String string1 = input.nextLine();
		System.out.print("Enter the second string: ");
		String string2 = input.nextLine();
		
		if(string1.compareToIgnoreCase(string2) < 0)
		{
			System.out.println("\nFirst String entered: '" + stringCapitalize(string1) + "' has " + numberconsonants(string1) + " consonants");
			System.out.println("Second String entered: '" + stringCapitalize(string2) + "' has " + numberVowels(string2) + " vowels");	
		}
		
		if(string1.compareToIgnoreCase(string2) > 0)
		{
			System.out.println("\nFirst String entered: '" + stringCapitalize(string2) + "' has " + numberVowels(string2) + " vowels");
			System.out.println("Second String entered: '" +stringCapitalize(string1) + "' has " + numberconsonants(string1) + " consonants");
		}
	}
	
	public static int numberconsonants(String string1)
	{
		int num_of_consonants = 0;
		for(int i = 0; i < string1.length(); i++)
		{
			char find_consonants = string1.charAt(i);
			if((find_consonants == ('b')) || find_consonants == ('B')
				|| find_consonants == ('c') || find_consonants == ('C')
				|| find_consonants == ('d') || find_consonants == ('D')
				|| find_consonants == ('f') || find_consonants == ('F')
				|| find_consonants == ('g') || find_consonants == ('G')
				|| find_consonants == ('h') || find_consonants == ('H')
				|| find_consonants == ('j') || find_consonants == ('J')
				|| find_consonants == ('k') || find_consonants == ('K')
				|| find_consonants == ('l') || find_consonants == ('L')
				|| find_consonants == ('m') || find_consonants == ('M')
				|| find_consonants == ('n') || find_consonants == ('N')
				|| find_consonants == ('p') || find_consonants == ('P')
				|| find_consonants == ('q') || find_consonants == ('Q')
				|| find_consonants == ('r') || find_consonants == ('R')
				|| find_consonants == ('s') || find_consonants == ('S')
				|| find_consonants == ('t') || find_consonants == ('T')
				|| find_consonants == ('v') || find_consonants == ('V')
				|| find_consonants == ('w') || find_consonants == ('W')
				|| find_consonants == ('x') || find_consonants == ('X')
				|| find_consonants == ('z') || find_consonants == ('Z'))
				{
					num_of_consonants++;
				}
			}
			return num_of_consonants;
	}
	
	public static int numberVowels(String string2)
	{
		int num_of_vowels = 0;
		for(int x = 0; x < string2.length(); x++)
		{
			char find_vowels = string2.charAt(x);
			if(find_vowels == ('a') || find_vowels == ('A')
					|| find_vowels == ('e') || find_vowels == ('E')
					|| find_vowels == ('i') || find_vowels == ('I')
					|| find_vowels == ('o') || find_vowels == ('O')
					|| find_vowels == ('u') || find_vowels == ('U')
					|| find_vowels == ('y') || find_vowels == ('Y'))
			{
				num_of_vowels++;
			}
		}
		return num_of_vowels;
	}
	
	public static String stringCapitalize(String string)
	{
		String three;
		three = (string.substring(0,1).toUpperCase()) + (string.substring(1).toLowerCase());
		return three;
	}
	//Enter string 'This is the first string' and 'This is the second string'; Output should be 
		//'First String entered: 'This is the first string' has 15 consonants' and 
		//'Second String entered: 'This is the second string' has 6 vowels' 
}
