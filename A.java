import java.util.Scanner;

public class A{

	public static void main(String[] args){

	int room_capacity = 0;
	int num_of_attendees = 0;

	Scanner keyboard = new Scanner(System.in);

	System.out.print("Enter the room capacity for the meeting: ");
	room_capacity = keyboard.nextInt();
	System.out.print("Enter the number of attendees in the meeting: ");
	num_of_attendees = keyboard.nextInt();

	if(num_of_attendees < room_capacity){
		System.out.print("\nThe meeting is legally not in violation of fire laws. ");
		System.out.println("\nThe number of additional people that may be added = " + (room_capacity - num_of_attendees));
	}
	else if(num_of_attendees == room_capacity){
		System.out.print("\nThe meeting is legally not in violation of fire laws. ");
		System.out.println("\nThe number of attendees equals the rooms capacity.");
	}
	else{
		System.out.print("\nThe meeting is legally in violation of fire laws. ");
		System.out.println("\nThe number of excess people that need to be removed = " + (num_of_attendees - room_capacity));
	};

	}
}
