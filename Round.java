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
	}
	
	public void printRound(int counter) {
		System.out.print(
				"**************************************************************\n"
				+"Congratulations, you completed round#"+(counter+1)+" choose 1 option to continue\n"
				+"1) Next round\n"
				+"2) Walk away\n"
				+"Your option: "
		);
	}
	
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
