
import java.util.Scanner;
public class TestMil {
	// adding questions
	 private static String[] questions = {
		        "Question 1: What is the capital of France?",
		        "Question 2: Who wrote 'To Kill a Mockingbird'?",
		        "Question 3: What is the largest planet in our solar system?",
		        "Question 4: Who painted the Mona Lisa?",
		        "Question 5: What is the chemical symbol for water?"
		    };
	 		// adding options
		    private static String[][] options = {
		        {"A. London", "B. Berlin", "C. Paris", "D. Madrid"},
		        {"A. Mark Twain", "B. Harper Lee", "C. J.K. Rowling", "D. F. Scott Fitzgerald"},
		        {"A. Earth", "B. Jupiter", "C. Mars", "D. Venus"},
		        {"A. Vincent van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Claude Monet"},
		        {"A. H2O", "B. CO2", "C. O2", "D. NaCl"}
		    };
		    // adding answer
		    private static char[] answers = {'C', 'B', 'B', 'C', 'A'};
		    // declaring prize money = 0
		    private static int prizeMoney = 0;

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        
		        System.out.println("Welcome to Who Wants to Be a Millionaire!");
		        System.out.println("Answer the questions correctly to win prize money. Good luck!\n");
		        
		        // this will run the for loop
		        for (int i = 0; i < questions.length; i++) {
		            System.out.println(questions[i]);
		            for (String option : options[i]) {
		                System.out.println(option);
		            }
		            
		            System.out.print("\nEnter your answer (A, B, C, or D): ");
		            // convert the scanner to uppercase and charat so wont get a string
		            char answer = scanner.next().toUpperCase().charAt(0);

		            if (answer == answers[i]) {
		                prizeMoney += (i + 1) * 10000;
		                System.out.println("Correct! You have won $" + prizeMoney + "\n");
		            } else {
		                System.out.println("Incorrect. The correct answer was " + answers[i] + ". You leave with $" + prizeMoney);
		                break;
		            }

		            
		            if (i == questions.length - 1) {
		                System.out.println("Congratulations! You've answered all questions correctly and won $" + prizeMoney + "!");
		            }
		        }

		        System.out.println("Thank you for playing Who Wants to Be a Millionaire!");
		        scanner.close();
		    }

}
