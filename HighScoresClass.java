public class HighScoresClass {

private String name;
private int score;

	public HighScoresClass(String n, int s)
	{
		this.name = n;
		this.score = s;
	}

	public void setName(String n)
	{
		name = n;
	}

	public String getName()
	{
		return this.name;
	}

	public void setScore(int s)
	{
		score = s;
	}

	public int getScore()
	{
		return this.score;
	}
}
