import java.io.*;


public class StudentSerializeTester {

	public static void main(String[] args) throws IOException {
		writeStudent();
		System.out.println("\nWrite Complete. Now reading...\n");
		readStudent();
	}
	
	public static void writeStudent() {
		Student student = new Student("Ed Example", "E123", 500, new PhoneNumber("8675309"));
		System.out.println("In writeStudent method:");
		System.out.println(student);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
			out.writeObject(student);
			out.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void readStudent() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
			Student s = (Student) in.readObject();
			System.out.println("In readStudent method:");
			System.out.println(s);
			in.close();
		} catch(ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
}
