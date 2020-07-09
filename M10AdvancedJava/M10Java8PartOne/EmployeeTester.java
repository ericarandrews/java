import java.util.*;

public class EmployeeTester {

	public static void main(String[] args) {
	    
	    List<Person> personList = new ArrayList<>();
	    personList.add(new Employee("Wally Worker", "W123"));
	    personList.add(new Employee("Erin Earner", "E567"));
	    personList.add(new Employee("Sal Slacker", "S899"));
	    personList.add(new Intern("Ida Intern", "I123"));
	    personList.add(new Consultant("Cal Consultant"));
		
		for(Person p : personList) {
			p.pay();
			p.benefits();
			
			if(p instanceof Intern) {
			    ( (Intern) p).awardCredit();
			}
			
			p.review();
		}
		
		List<Integer> numberList = new ArrayList<>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		
		//List<Integer> numberListJava9 = List.of(1, 2, 3);
	}

}
