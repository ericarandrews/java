
public class GradStudent extends Student {

	private String thesisTopic;
	
	private static final String UNDECLARED_THESIS_TOPIC = "Topic Not Yet Declared";
	
	public GradStudent(String firstName, String lastName, int studentID, String thesisTopic) {
		super(firstName, lastName, studentID);
		// invokes the parent constructor; sets up the "parent part" of the object
		
		// now add on any "child part" setup
		this.thesisTopic = thesisTopic;
	}
	public GradStudent(String firstName, String lastName, int studentID) {
		this(firstName, lastName, studentID, UNDECLARED_THESIS_TOPIC);
	}
	
	public String getThesisTopic() {
		return thesisTopic;
	}
	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}
	
	@Override
	public String toString() {
		return super.toString() + // let the parent class create its own text representation
				"\tGrad Student; Thesis Topic: " + thesisTopic; // then modify by adding the additional child part
	}
	
	public boolean isThesisTopicDeclared() {
		return !thesisTopic.equals(UNDECLARED_THESIS_TOPIC);
	}
	
	
	
}
