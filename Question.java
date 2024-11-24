import java.util.ArrayList;

// Question most important fields are message to display, list of options including the correct Option, price for each question
// and isCorrect to know if the question was answered correctly
public class Question {
	String difficulty;
	String message;
	ArrayList<Option> options;
	int price;
	Boolean isCorrect;
	
	public Question(String difficulty, String message) {
		this.difficulty = difficulty;
		this.message = message;
		this.options = new ArrayList<>();
		this.price = 0;
		this.isCorrect = false;
	}
	
	// printQuestion only print the current question and its Options
	public void printQuestion(int qCounter) {
		System.out.print(
				"**************************************************************\n"
				+"Price: $"+price+"\n"
				+"Question "+(qCounter+1)+": "
				+message+"\n"
				+showOptions()
		);
	}
	
	// printCorrectAns print the correct answer in case the user choose the wrong one. This means the user lost the game
	public void printCorrectAns(String username) {
		System.out.println(
				"Sorry "+ username +", the correct answer is "+getAnswer()
				+"Good luck next time"
		);
	}
	
	// showOptions return a string with the options currently available in the question to be printed with the question
	// considering that the content or number of options can change if a lifeline is executed 
	public String showOptions() {
		String lines = "";
		for(Option opt: options) {
			lines = lines+opt.getMessage()+"\n";
		}
		return lines;
	}

	// isCorrect check the user answer with each option and only if is the correct answer the question is set true and 
	// return true, otherwise is set false, the return value is false and that means the user lost the game
	public Boolean isCorrect(String ans) {
		Boolean value = false;
		for (Option opt: options) {
			String optAns = (opt.getMessage().split("\\) "))[0];
			if (optAns.equals(ans.toUpperCase())) {
				value = opt.getIsCorrect();
				isCorrect = value;
			}
		}
		return value;
	}
	
	// getAnswer return a string with the correct answer to be printed when the user choose an incorrect option
	public String getAnswer() {
		String answer = "";
		for (Option opt: options) {
			if(opt.getIsCorrect()) {
				answer = opt.getMessage();
			}
		}
		return answer+"\n";
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
