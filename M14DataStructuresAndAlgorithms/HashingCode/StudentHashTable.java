public class StudentHashTable {
	
	private Student[] hashTable;
	
	private static final Student AVAILABLE = new Student(-1, "");

	public StudentHashTable(int size) {
		hashTable = new Student[size];
	}
	
	private boolean canAddAtIndex(int index) {
		return hashTable[index] == null || hashTable[index] == AVAILABLE;
	}
	
	public boolean addStudent(Student student) {
		System.out.println("Adding " + student.getName());
		int hashCode = getHashCode(student);
		int location = hashCode;
		int locationsChecked = 0;
		boolean checkedAllLocations = false;
		
		while(!canAddAtIndex(location) && !checkedAllLocations) {
			System.out.print("\tCollision at position " + location);
			location++;
			location = location % hashTable.length;
			System.out.println("...\tTrying position " + location);
			locationsChecked++;
			if(locationsChecked >= hashTable.length) {
				checkedAllLocations = true;
			}
		}
		if(!checkedAllLocations) {
			hashTable[location] = student;
			System.out.println("\tAdded at position " + location);
			printTable();
			return true;
		} else {
			System.out.println("\tCannot add: table full.");
			printTable();
			return false;
		}
		
		
		
	}
	
	// gets the numeric hash code, which is the position in the hash table
	// for this example, I am hashing students by their id
	private int getHashCode(Student student) {
		return getHashCode(student.getID());
	}
	private int getHashCode(int studentID) {
		return studentID % hashTable.length; 
	}
	
	private int findIndexOfStudent(int studentID) {
		System.out.println("Looking for student with ID " + studentID + "...");
		int location = getHashCode(studentID);
		int locationsChecked = 0;
		boolean checkedAllLocations = false;
		
		while(hashTable[location] != null && !checkedAllLocations) {
			Student currentStudent = hashTable[location];
			if(currentStudent.getID()==studentID) {
				System.out.println("\tStudent found at position " + location);
				return location;
			} else {
				System.out.println("\tStudent at position " + location + " is not a match. Trying next position...");
				location++;
				location = location % hashTable.length;
				locationsChecked++;
				if(locationsChecked >= hashTable.length) {
					checkedAllLocations = true;	
				}
			}
		}
		return -1;
	}
	
	public Student getStudent(int studentID) {
		int studentIndex = findIndexOfStudent(studentID);
		if(studentIndex >= 0) {
			return hashTable[studentIndex];
		} else {
			System.out.println("\tStudent not found.");
			return null; // the student is not in the table
		}
		
	}
	
	public boolean removeStudent(int studentID) {
		int studentIndex = findIndexOfStudent(studentID);
		if(studentIndex >= 0) {
			hashTable[studentIndex] = AVAILABLE;
			System.out.println("\tStudent removed.");
			printTable();
			return true;
		} else {
			System.out.println("\tCould not remove- student not in the table.");
			printTable();
			return false;
		}
	}
	
	public boolean removeStudent(Student s) {
		return removeStudent(s.getID());
	}
	
	private void printTable() {
		System.out.println();
		for(int i=0; i<hashTable.length; i++) {
			System.out.println("\t" + i + "\t\t" + hashTable[i]);
		}
		System.out.println();
	}
}
