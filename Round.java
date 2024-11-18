import java.util.ArrayList;

public class Round {
	ArrayList<Question> questions;
	
	public Round() {
		this.questions = new ArrayList<>();
	}

	public void pickQuestionsBank(BankQuestions bq, int num) {
		for(int i=0; i<num; i++) {
			Question question = bq.getQuestions().get(0); // always get the first one
			questions.add(question);
			bq.getQuestions().remove(0); // always remove the first one
		}
	}; 
	
	public void nextQuestion() {
		
	};
	
	public Boolean walkAway() {
		return false;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	};
	
	
}
