public enum FeedbackCategory {

	POSITIVE(7, 10, "Positive", true, false), 
	NEUTRAL (4, 6, "Neutral", false, false), 
	NEGATIVE (0, 3, "Negative", false, true);
	
	private int min, max;
	private String description;
	private boolean good, bad;
	
	private FeedbackCategory(int min, int max, String description, boolean good, boolean bad) {
		this.min = min;
		this.max = max;
		this.description = description;
		this.good = good;
		this.bad = bad;
	}
	
	public static FeedbackCategory getCategory(int score) {
		FeedbackCategory[] categoryArray = FeedbackCategory.values();
		for(FeedbackCategory category : categoryArray) {
			if(category.min <= score && score <= category.max) {
				return category;
			}
		}
		throw new IllegalArgumentException("Invalid score.");
	}
	public String toString() {
		return description;
	}
	public boolean isGood() {
		return good;
	}
	public boolean isBad() {
		return bad;
	}
	
	
	
	
	
}
