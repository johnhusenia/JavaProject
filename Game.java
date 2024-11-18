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
		int counter = 0;
		BankQuestions bq = new BankQuestions();
		Scanner sc = new Scanner(System.in);
		bq.readFile(category);
		createRounds(bq, category);
		for(Round r: rounds) {
			for(Question q: r.getQuestions()) {
				System.out.print(
						"Question "+(counter+1)+": "
						+q.getMessage()+"\n"
						+q.showOptions()+"\n"
						+"Choose your option: "
				);
				String opt = sc.nextLine();
				if(!q.isCorrect(opt)) {
					System.out.println(
							"Sorry, the correct answer is "+q.getAnswer()
							+"Good luck next time"
					);
					sc.close();
					cond = true;
				}
				if(cond) break;
				counter+=1;
			}
			if(cond) break;
			System.out.print(
					"Current price: "+price+"\n"
					+"Congratulations, you completed the round, choose 1 option to continue\n"
					+"1) Next round\n"
					+"2) Walk away\n"
					+"Your option: "
			);
			int opt = sc.nextInt();
			sc.reset();
			if (opt == 2) {
				break;
			}
		}
		Question q = rounds.get(2).getQuestions().getLast();
		if(q.isCorrect) {
			youWin(price);
		}else {
			price = 0;
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
	}
	
	public void nextRound() {}
	
	public void youWin(int price) {
		System.out.println(
				"Congratulations, you are a millionarie!!\n"
				+"Current price: "+price
		);
	}
	
	public void youLost(int price) {
		System.out.println(
				"Sorry, good luchh the next time\n"
				+"Current price: "+price
		);
	}
	
	public void useLifeLine() {}
}
