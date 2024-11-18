import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	String usarname;
	String category; //easy or difficult
	ArrayList<Round> rounds; //only 3 rounds of 3 or 5 questions
	int price;
	ArrayList<LifeLine> lifeLines; //only 3
	
	public Game(String usarname, String category) {
		this.usarname = usarname;
		this.category = category;
		this.rounds = new ArrayList<>();
		this.price = 0;
		this.lifeLines = new ArrayList<>();
	}
	
	public void gameOn() {
		System.out.println("************************* Good luck! *************************");
		Boolean cond = false;
		int rCounter = 0;
		int qCounter = 0;
		BankQuestions bq = new BankQuestions();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		bq.readFile(category);
		createRounds(bq, category);
		for(Round r: rounds) {
			for(Question q: r.getQuestions()) {
				q.printQuestion(qCounter); 
				String str = sc.nextLine();
				if(!q.isCorrect(str)) { //check if the answer is correct and set the question to correct
					System.out.println(
							"Sorry, the correct answer is "+q.getAnswer()
							+"Good luck next time"
					);
					price = 0;
					cond = true;
				}
				if(cond) break;
				price = q.getPrice();
				qCounter++;
			}
			if(cond) break;
			if(rCounter < 2) {
				r.printRound(rCounter);
				String str = sc1.nextLine();
				cond = r.walkAway(str); //check if the user wants to walk away, get the money and end the game
			}
			if(cond) break;
			rCounter++;
		}
		Question q = rounds.getLast().getQuestions().getLast();
		if(q.isCorrect) {
			youWin(price);
		}else {
			youLost(price);
		}
		sc.close();
	}
	
	public void createRounds(BankQuestions bq, String category) {
		Round round1 = new Round();
		Round round2 = new Round();
		Round round3 = new Round();
		rounds.add(round1);
		rounds.add(round2);
		rounds.add(round3);
		
		for(Round round: rounds) {
			if (category.equals("1")) {
				round.pickQuestionsBank(bq, 3);
			}else {
				round.pickQuestionsBank(bq, 5);
			}
		}
		setQuestionPrices(rounds, category);
	}
	
	public void setQuestionPrices(ArrayList<Round> rounds, String category) {
		int counter = 0;
		int[] easyPrices = {100,500,1000,8000,16000,32000,125000,500000,1000000};
		int[] hardPrices = {100,200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,250000,500000,1000000};
		
		for(Round r: rounds) {
			for(Question q: r.getQuestions()) {
				if(category.equals("1")) {
					q.setPrice(easyPrices[counter]);
				}else {
					q.setPrice(hardPrices[counter]);
				}
				counter++;
			}
		}
	}
		
	public void youWin(int price) {
		System.out.println(
				"Congratulations, you are a millionarie!!\n"
				+"Current price: $"+price
		);
	}
	
	public void youLost(int price) {
		System.out.println(
				"Current price: $"+price
		);
	}
	
	public void useLifeLine() {}
}
