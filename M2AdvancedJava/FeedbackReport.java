
public class FeedbackReport {
	
	private int score;
	private FeedbackCategory category;
	private String feedbackText;
	private int id;
	
	private static int totalFeedbackReports = 0;
	private static int activeBadFeedbackReports = 0;
	
	public FeedbackReport(int score, String feedbackText) {
		this.score = score;
		this.feedbackText = feedbackText;
		this.category = FeedbackCategory.getCategory(score);
		
		FeedbackReport.totalFeedbackReports++;
		this.id = FeedbackReport.totalFeedbackReports;
		
		if(category.isBad()) {
			FeedbackReport.activeBadFeedbackReports++;
		}
	}
	public int getScore() {
		return score;
	}
	public String getFeedbackText() {
		return feedbackText;
	}
	public FeedbackCategory getCategory() {
		return category;
	}
	public static int getActiveBadFeedbackReports() {
		return FeedbackReport.activeBadFeedbackReports;
	}
	public static int getTotalFeedbackReports() {
		return FeedbackReport.totalFeedbackReports;
	}
	
	
	// omitting all setters
	
	public static void decrementActiveBadFeedbackReports() {
		FeedbackReport.activeBadFeedbackReports--;
	}
	
	public String toString() {
		String s = "ID: " + id + "\tScore: " + score +  " (" +category +")" +"\tFeedback:" + feedbackText;
		return s;
	}
	public boolean isGood() {
		return category.isGood();
	}
	public boolean isBad() {
		return category.isBad();
	}
	
	
	
	
	
	
	
}
