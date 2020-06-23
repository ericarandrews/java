package m1Review;


public class M1Driver {

	public static void main(String[] args) {

		Parcel a = new Parcel("abcde", 1.00, "myname", "mystreet", "mycity", "mystate", "myzip");
		Parcel b = new Parcel("fghij", "aname", "astreet", "acity", "astate", "azip");
		boolean c = a.meetsCriteria("abcabc", 'a', 'b', 2);
		
		System.out.println("Testing Object a, Parcel: ");
		System.out.println(a);	
		System.out.println("\n");
		
		System.out.println("Testing Object b, Parcel: ");
		System.out.println(b);	
		System.out.println("\n");
		
		System.out.println("Testing child class, overnightParcel: ");
		OvernightParcel d = new OvernightParcel("abcde", 1.00, "myname", "mystreet", "mycity", "mystate", "myzip", "yes");
		System.out.println(d);
		System.out.println("\n");
		
		Parcel x = new Parcel("xxx",1.00,"name","street","city","state","zip");
		System.out.println("Testing the toString method: ");
		System.out.println(x);
		System.out.println("\n");
		
		Parcel y = new Parcel("yyy",2.00,"names","streets","citys","states","zips");
		Parcel z = new Parcel("XXX",2.00,"name","street","city","state","zip");
		System.out.println("Testing the equals method: ");

		System.out.println("Is object x equal to object y? "+x.equals(y));
		System.out.println("Is object x equal to object z? "+x.equals(z));
		System.out.println("\n");	
		
		System.out.println("******************************Testing id Criteria");
		System.out.println("These ids meet the criteria- should print true.");
		System.out.println("\t" + x.meetsCriteria("d4x1m4m2", 'x', 'm', 2) + "\texactly 2 m's after x\n");  
		System.out.println("\t" + x.meetsCriteria("vdev4x1v3v", 'e', 'v', 3) + "\texactly 3 v's after e; also 1 extra v before x- that doesn't affect the criteria\n");
		System.out.println("\t" + x.meetsCriteria("d4g1b4gb5", 'g', 'b', 2) + "\texactly 2 b's after the first g; also a second g- that doesn't affect the criteria\n");

		System.out.println("\nThese ids do NOT meet the criteria- should print false.");
		System.out.println("\t" + x.meetsCriteria("ad6c4z1a43sh", 'z', 'a', 2) + "\t only 1 a after the z- the other a comes before the z\n");
		System.out.println("\t" + x.meetsCriteria("ddc4f1q4qq", 'f', 'q', 2) + "\t 3 q's after the f\n");
		System.out.println("\t" + x.meetsCriteria("kdc2m1m4rv", 'k', 'm', 1) + "\t no k\n");
		System.out.println("\t" + x.meetsCriteria("sbbbf41n", 'b', 'b', 3) + "\t the first b is the firstChar; there are then only *2* other b's *after* that\n");

		System.out.println("\n\n******************************Testing e-Mail Validator");
		// valid
		String s1 = "janeeyre@email.com";
		String s2 = "markdarcy@gmail.abc";
		String s3 = "dr.frankenstein@monster.com";
		String s4 = "!@abc.xyz";
		
		// invalid
		String s5 = "@abc.xyz"; // no characters before @
		String s6 = "abc.com"; // no @
		String s7 = "j@com"; // no period
		String s8 = "jm@gmail.comm"; // 4 chars after the prior
		String s9 = "jm@gmail.hi"; // 2 chars after period
		String s10 = "jm@gmail.z"; // 1 chars after period
		String s11 = "abcdef"; // no @ or .
		String[] tests = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11};
		boolean[] results = {true, true, true, true, false, false, false, false, false, false, false};
		for(int i=0; i<tests.length; i++) {
			System.out.println(isValidEmail(tests[i]) +	" : " + results[i] + " for " + tests[i]);
		}

	}
	
	public static boolean isValidEmail(String email) {	
		char a = email.charAt(0);
		String lastThreeCharacters = email.substring(email.length() - 4);
		char periodBeforeLastThreeCharacters=lastThreeCharacters.charAt(0);
		if(email.contains("@") && a!='@' && email.contains(".") && periodBeforeLastThreeCharacters == '.'){return true;}
		return false;
	}

}

