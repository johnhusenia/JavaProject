import java.util.ArrayList;

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
	
	public void printQuestion(int qCounter) {
		System.out.print(
				"**************************************************************\n"
				+"Price: $"+price+"\n"
				+"Question "+(qCounter+1)+": "
				+message+"\n"
				+showOptions()
		);
	}
	
	public void printCorrectAns() {
		System.out.println(
				"Sorry, the correct answer is "+getAnswer()
				+"Good luck next time"
		);
	}
	
	public String showOptions() {
		String lines = "";
		for(Option opt: options) {
			lines = lines+opt.getMessage()+"\n";
		}
		return lines;
	}

	public Boolean isCorrect(String ans) {
		Boolean value = false;
		for (Option opt: options) {
			String optAns = (opt.getMessage().split("\\) "))[0];
			if (optAns.equals(ans.toUpperCase())) {
				value = opt.isCorrect;
				isCorrect = value;
			}
		}
		return value;
	}
	
	public String getAnswer() {
		String answer = "";
		for (Option opt: options) {
			if(opt.isCorrect) {
				answer = opt.message;
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
