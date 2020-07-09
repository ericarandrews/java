public class Intern extends Employee implements HRProcessor, CollegeProcessor {
	
	public Intern(String name, String id) {
		super(name, id);
	}

    @Override
    public void awardCredit() {
        System.out.println("Awarding Credit");
    }

    // if Employee does NOT override review, then Intern has a conflict- compiler error
    // if Employee DOES override review, the superclass version (Employee review method)
    // wins out over the interface default versions and is used
    
    
	@Override
	public void review() {
	    //System.out.println("Review of interns is conducted by college, not HR.");
	    CollegeProcessor.super.review();
	    //HRProcessor.super.review();
	}
	
}
