import java.util.Scanner;

public class WWTBM {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int option = 0;
		while (option != 3) {
			System.out.println("********** Welcome to Who Wants To Be a Millionaire **********");
			System.out.print(
					"Please select one of the following options:\n"
					+"1) Start Game\n"
					+"2) View Rules\n"
					+"3) Exit\n"
					+"Your option: "
			);
			option = sc1.nextInt();
			switch(option) {
			case 1:
				System.out.println("************************* Start Game *************************");
				Scanner sc = new Scanner(System.in);
				System.out.print("Please write your first name and last name: ");
				String username = sc.nextLine();
				System.out.print(
						"Please choose a category: \n"
						+"1) Easy\n"
						+"2) Hard\n"
						+"Your category: "
				);
				String category = sc.nextLine();
				Game game = new Game(username, category);
				game.gameOn();
				sc.close();
				exitGame(sc1);
				break;
			case 2:
				System.out.println("************************* View Rules *************************");
				printRules();
				break;
			case 3:
				System.out.println("**************************** Exit ****************************");
				exitGame(sc1);
				break;
			}
		}

	}
	
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
	
	public static void exitGame(Scanner sc) {
		sc.close();
		System.exit(0);
	}

}
