
// Option contains a message with the option and isCorrect  to know if the Option is the correct answer 
public class Option {
	private String message;
	private Boolean isCorrect;
	
	public Option(String message, Boolean isCorrect) {
		this.message = message;
		this.isCorrect = isCorrect;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
}
