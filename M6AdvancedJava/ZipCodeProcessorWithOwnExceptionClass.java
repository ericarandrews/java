import java.util.*;

public class ZipCodeProcessorWithOwnExceptionClass {
	
	public final static int SMALLEST_ZIP = 501;
	public final static String SMALLEST_ZIP_STRING = "00" + SMALLEST_ZIP;
	public final static int LARGEST_ZIP = 99950;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] zipCodes = new int[5];
		int validCodes = 0;
		int invalidCodes = 0;

		while (validCodes < zipCodes.length) {
			try {
				System.out.println("Enter a 5-digit zip code.");

				String zipCodeString = scan.nextLine();

				if (zipCodeString.length() == 5) {
					int zipCodeInteger = Integer.parseInt(zipCodeString);
					
					if(zipCodeInteger < SMALLEST_ZIP || zipCodeInteger > LARGEST_ZIP) {
						String message = (zipCodeInteger < SMALLEST_ZIP) ? "Invalid zip. The smallest zip is " + SMALLEST_ZIP_STRING :
							"Invalid zip. The largest zip is " + LARGEST_ZIP;
						throw new InvalidZipCodeException(message);
					}
					zipCodes[validCodes] = zipCodeInteger;
					validCodes++;
				} else {
					throw new IllegalArgumentException("Invalid zip code length.");
				}
			} catch (NumberFormatException ex) {
				System.out.println("Zip codes must only contain digits.");
				invalidCodes++;
			} catch (IllegalArgumentException | InvalidZipCodeException ex) {
				System.out.println(ex.getMessage());
				invalidCodes++;
			} finally {
				System.out.println("You entered " + validCodes + " valid codes and " + invalidCodes + " invalid Codes.");
			}
			
				/*
			} catch (NumberFormatException | IllegalArgumentException ex) {
				System.out.println("Invalid code entered.");
				invalidCodes++;
			} 
*/
		}


		System.out.println(Arrays.toString(zipCodes));

	}

}
