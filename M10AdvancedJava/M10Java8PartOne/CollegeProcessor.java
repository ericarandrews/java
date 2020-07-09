
public interface CollegeProcessor {

   void awardCredit();
   
   default void review() {
	   System.out.println("Reviewing intern based on college standards");
   }
  
	

}
