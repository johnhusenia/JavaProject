import java.util.ArrayList;

public class Question {
	String difficulty;
	String message;
	ArrayList<Option> options;
	Boolean isCorrect;
	
	public Question(String difficulty, String message) {
		this.difficulty = difficulty;
		this.message = message;
		this.options = new ArrayList<>();
		this.isCorrect = false;
	}
	
	public String showOptions() {
		return 
				options.get(0).getMessage()+"\n"
				+options.get(1).getMessage()+"\n"
				+options.get(2).getMessage()+"\n"
				+options.get(3).getMessage()
		;
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
	
	public void youLost() {}

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
	
	
	
}
