import java.util.*;

public class CustomerAgent {
	
	private String name;
	private ArrayList<FeedbackReport> feedbackReportList;
	
	private static final int NUMBER_REPORTS_NEEDED_FOR_BONUS = 100;
	private static final double PERCENTAGE_OF_POSITIVE_REPORTS_NEEDED_FOR_BONUS = 0.75;
	
	public CustomerAgent(String name) {
		this.name = name;
		feedbackReportList = new ArrayList<FeedbackReport>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<FeedbackReport> getFeedbackReportList() {
		return new ArrayList<FeedbackReport>(feedbackReportList); // makes a shallow copy 
		// protects from outside classes modifying the list
		// note that an outside class COULD modify any individual FeedbackReport object 
	}
	// omitting setters
	
	public String toString() {
		String s = name + "\n";
		for(FeedbackReport report : feedbackReportList) {
			s += "\t" + report + "\n";
		}
		return s;
	}
	
	public int getNumberOfFeedbackReports() {
		return feedbackReportList.size();
	}
	
	public boolean addFeedbackReport(FeedbackReport report) {
		return feedbackReportList.add(report);
	}

	public boolean isEligibleForBonus() {
		if(feedbackReportList.size() < NUMBER_REPORTS_NEEDED_FOR_BONUS) {
			return false;
		} else {
			int totalGood = 0;
	
			for(FeedbackReport report : feedbackReportList) {
				if(report.isGood()) {
					totalGood++;
				}
			}
			double percentGood = (totalGood * 1.0) / feedbackReportList.size();
			return percentGood >= PERCENTAGE_OF_POSITIVE_REPORTS_NEEDED_FOR_BONUS;
		}
		
	}

	public void clearReports() {
		// feedbackReportList.clear(); // use this if the bad feedback counter is for all bad reports ever created
		
		// use this if you want the counter to reflect the number of "active" bad reports
		Iterator<FeedbackReport> iterator = feedbackReportList.iterator();
		while(iterator.hasNext()) {
			FeedbackReport report = iterator.next();
			if(report.isBad()) {
				FeedbackReport.decrementActiveBadFeedbackReports();
			}
			iterator.remove();
		}
	}
	
	
}
