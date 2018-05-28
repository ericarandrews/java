import java.util.Scanner;

public class Fat
{
	public static void main(String[] args)
	{

		Scanner keyboard = new Scanner(System.in);

		double num_of_calories = 0;
		double fat_grams = 0;

		System.out.println("Enter the number of calories in food item: ");
		num_of_calories = keyboard.nextDouble();
		System.out.println("Enter the fat grams in food item: ");
		fat_grams = keyboard.nextDouble();

		double caloriesFromFat = fat_grams * 9;

		if(caloriesFromFat > num_of_calories)
		{
			System.out.println("Error message: calories from fat are greater than total.");
		}
		else if(caloriesFromFat <= num_of_calories && caloriesFromFat >= (num_of_calories * (.30)))
		{
			System.out.println("Calories entered: " + num_of_calories + "\nThe percentage of calories from fat: " + caloriesFromFat);
		}
		else if(caloriesFromFat < (num_of_calories * (.30)))
		{
			System.out.println("The food is low in fat.");
		}
	}
}
