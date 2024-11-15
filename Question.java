import java.util.ArrayList;

public class Question {
	String difficulty;
	String message;
	ArrayList<Option> options;
	
	public Question(String difficulty, String message) {
		this.difficulty = difficulty;
		this.message = message;
		this.options = new ArrayList<>();
	}
	
	public void loadOptions() {} 
	
	public void showOptions() {}

	public void isCorrect() {}
	
	public void youLost() {}
	
}
