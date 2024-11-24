import java.util.Scanner;

// WWTBM contains the main method and this is the main thread, the second thread is the MusicThread, 
// no synchronization needed cause we want both running at the same time
public class WWTBM {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int option = 0;
		AnswerValidation av = new AnswerValidation(); 
		Boolean ans1 = false;
		
		MusicThread music =  new MusicThread(); // MusicThread contains the run method with the background music in a loop
		music.start();
		
		while (option != 3) { // if the user option is 3 the game ends
			System.out.println("********** Welcome to Who Wants To Be a Millionaire **********");
			System.out.print(
					"Please select one of the following options:\n"
					+"1) Start Game\n"
					+"2) View Rules\n"
					+"3) Exit\n"
					+"Your option: "
			);
			do { // validate if the option is a number, if its not repeat the validation
	            try {
	             
	                option = sc1.nextInt();
	                ans1 = av.number1(option); 
	                sc1.nextLine();
	            } catch (Exception e) {
	                System.out.print("Your input is invalid. Please choose your answer from the choices:");
	                sc1.next();
	            }
	        }while (!ans1);
			switch(option) { // execute the user option 1, 2 or 3 after validation
			case 1:
				System.out.println("************************* Start Game *************************");
				Scanner sc = new Scanner(System.in);
				System.out.println("Instruction: You cannot use non-letter characters in a name!");
				System.out.print("Please write your name: ");
				String username = "";
			do { // validate if the name is a not blank string, if its not repeat the validation
				username = sc.nextLine();
				ans1 = av.name(username);
			}while(ans1 == false);
				System.out.print(
						"Please choose a category: \n"
						+"1) Easy\n"
						+"2) Hard\n"
						+"Your category: "
				);
				String category = "";
				do { // validate if the category is a string 1 or 2, if its not repeat the validation
					category = sc.nextLine();
					ans1 = av.number2(category);
				}while(ans1 == false);
				
				// here the game start with the username and category
				Game game = new Game(username, category);
				game.gameOn();
				exitGame(sc);
				break;
			case 2:
				System.out.println("************************* View Rules *************************");
				printRules();
				// reset the option value for the next user input
				option= 00;
				break;
			case 3:
				System.out.println("**************************** Exit ****************************");
				exitGame(sc1);
				break;
			}
		}
		exitGame(sc1);
	}
	
	
	// printRules only print rules and return to the menu loop
	public static void printRules(){
		System.out.println(
				"Game Rules\n\n"
				+ "Question Format:\n"
				+ "Each question has four possible answers (A, B, C, or D).\n"
				+ "Only one answer is correct.\n"
				+ "Questions become progressively harder as the prize money increases.\n\n"
				+ "Lifelines: Contestants are provided with lifelines to assist them:\n"
				+ "- 50:50: Removes two incorrect answers, leaving one correct answer and one wrong.\n"
				+ "- Ask the Audience: Polls the audience for their answer preferences.\n"
				+ "- Phone a Friend: Allows the contestant to call someone for help.\n\n"
				+ "Guaranteed Milestones:\n"
				+ "Certain prize levels (e.g., $1,000 and $32,000) are \"safe levels.\" Reaching these ensures "
				+ "contestants retain that amount even if they answer a subsequent question incorrectly.\n\n"
				+ "Progression:\n"
				+ "Contestants answer one question at a time.\n"
				+ "They can choose to walk away with their current winnings at the end of Round 1 and Round 2.\n"
				+ "An incorrect answer below a milestone results in dropping to the last milestone amount.\n\n"
				+ "Final Prize:\n"
				+ "The contestant must answer all questions correctly to win the top prize (e.g., $1 million).\n"
		);
	}
	
	// exitGame is executed when the option in the first menu is 3 or when the game finish (lose or win)
	public static void exitGame(Scanner sc) {
		sc.close();
		System.exit(0);
	}

}
