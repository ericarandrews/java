
public class HomeworkM1Driver {

	public static void main(String[] args) {
		String s1 = "janeeyre@email.com";
		String s2 = "markdarcy@gmail.abc";
		String s3 = "dr.frankenstein@monster.com";
		String s4 = "!@abc.xyz";
		String s5 = "@abc.xyz";
		String s6 = "abc.com";
		String s7 = "j@com";
		String s8 = "jm@gmail.comm";
		String s9 = "jm@gmail.hi";
		String s10 = "jm@gmail.z";
		String s11 = "abcdef";
		String[] tests = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11};
		boolean[] results = {true, true, true, true, false, false, false, false, false, false, false};
		for(int i=0; i<tests.length; i++) {
			System.out.println(isValidEmail(tests[i]) +
					" : " + results[i] + " for " + tests[i]
					);
		}

	}
	
	public static boolean isValidEmail(String email) {
		// YOUR CODE HERE
		return false;
	}

}
