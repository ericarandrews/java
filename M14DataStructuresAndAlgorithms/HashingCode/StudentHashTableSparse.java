public class StudentHashTableSparse {
	
	private Student[] hashTable;

	public StudentHashTableSparse(int size) {
		hashTable = new Student[size];
	}
	
	public void addStudent(Student student) {
		int hashCode = getHashCode(student);
		hashTable[hashCode] = student;
		System.out.println("Adding " + student.getName() + " at position " + hashCode + " ...");
		printTable();
		
	}
	
	// gets the numeric hash code, which is the position in the hash table
	// for this example, I am hashing students by their id
	private int getHashCode(Student student) {
		return getHashCode(student.getID());
	}
	private int getHashCode(int studentID) {
		return studentID % hashTable.length; 
	}
	
	public Student getStudent(int studentID) {
		int location = getHashCode(studentID);
		return hashTable[location];
		
	}
	
	public void removeStudent(Student s) {
		int location = getHashCode(s);
		hashTable[location] = null;
	}
	
	private void printTable() {
		System.out.println();
		for(int i=0; i<hashTable.length; i++) {
			System.out.println("\t" + i + "\t\t" + hashTable[i]);
		}
		System.out.println();
	}
}
