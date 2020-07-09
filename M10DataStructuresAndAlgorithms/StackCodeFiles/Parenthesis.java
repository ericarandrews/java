
public class Parenthesis {
	
	private String parenthesis, match;
	private boolean open;
	
	private final static String OPEN_PARENS =  "({[";
	private final static String CLOSE_PARENS = ")}]";

	public static boolean isParenthesis(char parenChar) {
		return OPEN_PARENS.indexOf(parenChar) >= 0 || CLOSE_PARENS.indexOf(parenChar) >= 0;
	}
	
	public Parenthesis(char parenChar) {
		this.parenthesis = Character.toString(parenChar);
		
		int openIndex = OPEN_PARENS.indexOf(parenChar);
		int closeIndex = CLOSE_PARENS.indexOf(parenChar);
		
		if(!Parenthesis.isParenthesis(parenChar)) {
			throw new IllegalArgumentException("Invalid parenthesis character.");
		} else if(openIndex>=0) {
			match = CLOSE_PARENS.substring(openIndex, openIndex+1);
			this.open = true;
		} else { // closeIndex>=0
			match = OPEN_PARENS.substring(closeIndex, closeIndex+1);
			this.open = false;
		}
	}
	
	public String getParenthesis() {
		return parenthesis;
	}
	public String getMatch() {
		return match;
	}
	public boolean isOpen() {
		return open;
	}
	public boolean isClose() {
		return !open;
	}
	public boolean isMatch(String possibleMatch) {
		return possibleMatch.equalsIgnoreCase(match);
	}
	public boolean isMatch(Parenthesis possibleMatch) {
		return possibleMatch.getParenthesis().equalsIgnoreCase(match);
	}
	
	@Override
	public String toString() {
		return parenthesis + " " + (open ? "open" : "closed") + " match: " + match;
	}

	
	

}
