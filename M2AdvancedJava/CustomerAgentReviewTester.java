import java.util.*;

public class CustomerAgentReviewTester {

	public static void main(String[] args) {
		FeedbackReport report1 = new FeedbackReport(1, "terrible!");
		FeedbackReport report2 = new FeedbackReport(4, "okay.");
		FeedbackReport report3 = new FeedbackReport(7, "this agent was awesome!");
		FeedbackReport report4 = new FeedbackReport(8, "best agent ever!");
		FeedbackReport report5 = new FeedbackReport(3, "agent not so good.");
		
		//System.out.println(report1);
		
		CustomerAgent badBetty = new CustomerAgent("Betty");
		badBetty.addFeedbackReport(report1);
		badBetty.addFeedbackReport(report5);
		//System.out.println(badBetty);
		
		CustomerAgent goodGeorge = new CustomerAgent("George");
		goodGeorge.addFeedbackReport(report3);
		goodGeorge.addFeedbackReport(report4);
		//System.out.println(goodGeorge);
		
		Random generator = new Random();
		for(int i=0; i<200; i++) {
			int score = generator.nextInt(5) + 6; // generates scores from 6-10
			FeedbackReport report = new FeedbackReport(score, "empty text");
			goodGeorge.addFeedbackReport(report);
		}
		System.out.println(goodGeorge);
		System.out.println(goodGeorge.isEligibleForBonus());

		for(int i=0; i<200; i++) {
			int score = generator.nextInt(7); // generates scores from 0-6
			FeedbackReport report = new FeedbackReport(score, "empty text");
			badBetty.addFeedbackReport(report);
		}
		System.out.println(badBetty);
		System.out.println(badBetty.isEligibleForBonus());
		
		System.out.println("Total bad reports: " + FeedbackReport.getActiveBadFeedbackReports());
		System.out.println("Total reports: " + FeedbackReport.getTotalFeedbackReports());
		
		badBetty.clearReports();
		System.out.println(badBetty);

		System.out.println("Total bad reports: " + FeedbackReport.getActiveBadFeedbackReports());
		System.out.println("Total reports: " + FeedbackReport.getTotalFeedbackReports());
	}

}
