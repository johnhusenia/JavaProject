import java.util.ArrayList;

// Round contains a list of Questions and each Question contains a list of Options
public class Round {
	private ArrayList<Question> questions;
	
	public Round() {
		this.questions = new ArrayList<>();
	}

	// pickQuestionsBank use the list of questions in the BankQuestions and pick the first 3 or 5 depending on the num
	// the list of questions has a random order so picking the first one is not always the same.
	// after picking a question, this question is removed from the list and  current first question is different
	public void pickQuestionsBank(BankQuestions bq, int num) {
		for(int i=0; i<num; i++) {
			Question question = bq.getQuestions().get(0); // always get the first one
			questions.add(question);
			bq.getQuestions().remove(0); // always remove the first one
		}
	}
	
	// printRound only print the past round and the options for the user at the end of Round1 and Round2 
	public void printRound(int counter) {
		System.out.print(
				"**************************************************************\n"
				+"Congratulations, you completed round#"+(counter+1)+" choose 1 option to continue\n"
				+"1) Next round\n"
				+"2) Walk away\n"
				+"Your option: "
		);
	}
	
	// walkAway return a boolean that will end the game if the option is string 2 (walk away)
	public Boolean walkAway(String option) {
		Boolean cond = false;
		if (option.equals("2")) {
			System.out.println("You did not get to the final but you get a price");
			cond = true;
		}
		return cond;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	};
	
	
}
