import java.util.ArrayList;

public class Game {
	String userFullName;
	String category; //easy or difficult
	ArrayList<Round> rounds; //only 3 rounds of 3 or 5 questions
	int price;
	ArrayList<LifeLine> lifeLines; //only 3
	
	public Game(String userFullName, String category, int price) {
		this.userFullName = userFullName;
		this.category = category;
		this.rounds = new ArrayList<>();
		this.price = price;
		this.lifeLines = new ArrayList<>();
	}
	
	public void createRounds() {}
	
	public void nextRound() {}
	
	public void youWin() {}
	
	public void useLifeLine() {}
}
