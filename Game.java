import java.util.ArrayList;
import java.util.Scanner;

// Game contains a username, category, list of 3 rounds, prize and list of 3 lifelines 
public class Game {
	private String username;
	private String category; //easy or difficult
	private ArrayList<Round> rounds; //only 3 rounds of 3 or 5 questions
	private int prize;
	private ArrayList<LifeLine> lifeLines; //only 3
	
	public Game(String username, String category) {
		this.username = username;
		this.category = category;
		this.rounds = new ArrayList<>();
		this.prize = 0;
		this.lifeLines = new ArrayList<>();
	}
	
	// gameOn contains the core of the game.
	// cond help us to control the flow of the rounds and questions to end the game in case the user answer 
	// 		a question incorrectly or he decide to walk away at the end of the Round
	// rCounter help us to check the lifelines and print the current Round
	// qCounter help us to print the current question
	public void gameOn() {
		System.out.println("************************* Good luck! *************************");
		Boolean cond = false;
		int rCounter = 0;
		int qCounter = 0;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		AnswerValidation av = new AnswerValidation(); // validations for the user input
		Boolean ans1 = false; // is used for validations
		Boolean fifty = true; // is used for validations of the 50/50 lifeline
		
		// BankQuestions is the class that read a file with the questions and options and create a list with all of them
		BankQuestions bq = new BankQuestions();
		bq.readFile(category);
		
		createRounds(bq, category);
		
		createLifeLines();
		
		// during the game we will present each of the 3 or 5 Questions of each Round
		for(Round r: rounds) {
			for(Question q: r.getQuestions()) {
				q.printQuestion(qCounter); // print the question and options
				ans1 = false; 
				
				// after the question and options were printed we check that the are some lifelines available, 
				// the difficulty of the game and the current Round to show a new option too allow the user 
				// the use of the lifelines. Only print the L) option or not
				if(lifeLines.size()>0) {
					if(q.difficulty.equals("2") && rCounter>0) {
						System.out.println("L) Use LifeLine");
					}else if(q.difficulty.equals("1")) {
						System.out.println("L) Use LifeLine");
					}
				}
				
				System.out.print("Choose your option: ");
				// reset the str1 value for the next user input
				String str = "";
				do { // validate if the user Option is ABCD or ABCDL, if its not repeat the validation
					str = sc.nextLine().toUpperCase();
					// this will decide if we use validations for Options ABCD or ABCDL
					if((lifeLines.size()==0) || ((category.equals("2")&& (rCounter==0)))) { 
						ans1 = av.abcd(str);
					}else {
						ans1 = av.abcdl(str);
					}
				}while (!ans1);
				
				// if the user Option is L the lisfelines in the list are printed and validate the user answer
				if(str.equals("L") && lifeLines.size()>0) {
					for(int i=0; i<lifeLines.size(); i++) {
						System.out.print(
								(i+1)+ ") "+lifeLines.get(i).getName()+"\n"
						);
					}
					System.out.print("Choose your lifeline: ");
					int num = 99;
					 do{ // validate if the option is a correct lifeline number, if its not repeat the validation
			            try {
			            	num = sc1.nextInt();
			            	ans1 = av.lifeop(num, lifeLines.size()); 
			            	num = num-1;
			            }catch (Exception e) {
			            	System.out.println("Your answer is invalid. Please choose your answer from the choices:");
			                ans1 = false; 
			                sc1.next();
			            }
			        }while (!ans1);
					 
					if(num>=0 && num<lifeLines.size()) {
						LifeLine ll = lifeLines.get(num);
						ll.executeLifeLine(q);
						lifeLines.remove(num);
						q.printQuestion(qCounter);
						System.out.print("Choose your option: ");
						
						do  {
							if((num==0) && (fifty == true)) {
								String[] fopt = new String[2];
								int i = 0;
								fifty = false;
								for(Option opt: q.getOptions()) {
									fopt[i] = opt.getMessage().split(": ")[0];
									i++;
								}
							 	str = sc.nextLine().toUpperCase();
							 	ans1 = av.fifty(str,fopt);

							}else {
								 str = sc.nextLine().toUpperCase();
								 ans1 = av.abcd(str);
							}
						}while (!ans1);
					}
				}
				
				// check if the current question was correctly answered, if true the cond don't change an the game 
				// continues, if its false cond change and the Questions loop breaks, then the Rounds loop breaks. Game lost
				if(!q.isCorrect(str)) { 
					q.printCorrectAns(username);
					prize = 0;
					cond = true;
				}
				if(cond) break;
				prize = q.getPrice(); // if the Question is correct the current prize of the game is updated
				qCounter++;
			}// Question iteration ends here
			
			if(cond) break; // if the Question was correctly answer we continue with the game
			if(rCounter < 2) {
				r.printRound(rCounter); // Round is printed
				// reset the str1 value for the next user input
				String str1 = "";
				do  { // validate if the str1 is a number, if its not repeat the validation
					str1 = sc2.nextLine();
					ans1 = av.number2(str1);
				}while (!ans1);
				cond = r.walkAway(str1); //check if the user wants to walk away, get the money and end the game
			}
			// if at the end of the Round1 or Round2 the user decided to walk away the Rounds loop ends. Game ends 
			
			if(cond) break; 
			rCounter++;
		} // Round iteration ends here 
		// we know if the user won if the last Question of the last Round was correctly answer
		Question q = rounds.getLast().getQuestions().getLast();
		if(q.isCorrect) {
			youWin(prize);
		}else {
			youLost(prize);
		}
		sc.close();
		sc1.close();
		sc2.close();
	}
	
	// createRounds create the 3 rounds of the game and add them to the list.
	// The 3 or 5 questions for each round depends on the category
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
		setQuestionPrizes(rounds, category);
	}
	
	// setQuestionPrices has a list of easyPrizes and hardPrizes to set the prizes for each of the 9 or 15 questions
	// depending on the category
	public void setQuestionPrizes(ArrayList<Round> rounds, String category) {
		int counter = 0;
		int[] easyPrizes = {100,500,1000,8000,16000,32000,125000,500000,1000000};
		int[] hardPrizes = {100,200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,250000,500000,1000000};
		
		for(Round r: rounds) {
			for(Question q: r.getQuestions()) {
				if(category.equals("1")) {
					q.setPrice(easyPrizes[counter]);
				}else {
					q.setPrice(hardPrizes[counter]);
				}
				counter++;
			}
		}
	}
	
	// youWin only prints a message if the user win the game
	public void youWin(int price) {
		System.out.println(
				"Congratulations,"+ username +" you are a millionarie!!\n"
				+"Current price: $"+price
		);
	}
	
	// youLost only prints a message if the user lose the game
	public void youLost(int price) {
		System.out.println(
				"Current price: $"+price
		);
	}
	
	// createLifeLines create the 3 lifelines of the game and add them to the list
	public void createLifeLines() {
		LifeLine lifeLine1 = new Fifty_Fifty("50/50");
		LifeLine lifeLine2 = new AskAudience("Ask The Audience");
		LifeLine lifeLine3 = new PhoneFriend("Phone A Friend");
		lifeLines.add(lifeLine1);
		lifeLines.add(lifeLine2);
		lifeLines.add(lifeLine3);
	}
}
