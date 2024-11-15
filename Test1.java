import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	
	static class Question {
        String question;
        String[] options;
        char answer;

        Question(String question, String[] options, char answer) {
            this.question = question;
            this.options = options;
            this.answer = answer;
        }
    }


    // Function to load and shuffle questions from the text file
    public static List<Question> loadQuestions(String filePath) throws IOException {
        List<Question> questions = new ArrayList<>();

        List<String> lines = Files.readAllLines(new File(filePath).toPath());
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) continue; // Skip blank lines

            // Read question and options
            String questionText = lines.get(i++);
            String[] options = new String[4];
            for (int j = 0; j < 4; j++) {
                options[j] = lines.get(i++);
            }
            char correctAnswer = lines.get(i).trim().charAt(0); // Read correct answer
            i++; // Skip the blank line between questions

            // Create a Question object and add it to the list
            questions.add(new Question(questionText, options, correctAnswer));
        }

        // Shuffle the questions list
        Collections.shuffle(questions);
        return questions;
    }
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String[] lifeline = {"lifeline 1: E", "lifeline 2: F", "lifeline 3: G"};
    	try {
    	List<Question> questions = loadQuestions("C:\\Users\\clahu\\Desktop\\JAVA\\GProject\\src\\project1\\questions.txt");
    	 for(int i=0; i<5; i++) {
    	System.out.println("Question "+ (i+1) +": " + questions.get(i).question);
    	 for (String option : questions.get(i).options) {
             System.out.print(option+" ");
         }
    	 
    	 System.out.println("Call a life line");
    	 for (String life : lifeline) {
             System.out.print(life + "| ");
         }
    	 
    	 System.out.print("\nEnter your answer (A, B, C, D, or CALL A LIFELINE): ");
    	 
         char answer = scanner.next().toUpperCase().charAt(0);
         
         
         if (answer == questions.get(i).answer) {
             System.out.println("Correct! ");
         }
         else {
             System.out.println("Incorrect. The correct answer was " + questions.get(i).answer);
             break;
         }
         }
         
    	        } catch (IOException e) {
    	            System.out.println("Failed to load questions: " + e.getMessage());
    	        } finally {
    	            scanner.close();
    	        }
    	
    	}
    

    
}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            // Load and shuffle questions
//            List<Question> questions = loadQuestions("C:\\Users\\clahu\\Desktop\\JAVA\\GProject\\src\\project1\\questions.txt");
//
//            System.out.println("Welcome to Who Wants to Be a Millionaire!");
//            System.out.println("Answer the questions correctly to win prize money. Good luck!\n");
//
//            int questionCount = 1;
//
//            for (Question question : questions) {
//                // Display the question and options
//                System.out.println("Question " + questionCount + ": " + question.question);
//                for (String option : question.options) {
//                    System.out.println(option);
//                }
//
//                System.out.print("\nEnter your answer (A, B, C, or D): ");
//                char answer = scanner.next().toUpperCase().charAt(0);
//
//                if (answer == question.answer) {
//                    prizeMoney += questionCount * 1000; // Increase prize as questions progress
//                    System.out.println("Correct! You have won $" + prizeMoney + "\n");
//                } else {
//                    System.out.println("Incorrect. The correct answer was " + question.answer + ". You leave with $" + prizeMoney);
//                    break;
//                }
//
//                // Check if the user has reached the final question
//                if (questionCount == questions.size()) {
//                    System.out.println("Congratulations! You've answered all questions correctly and won $" + prizeMoney + "!");
//                }
//
//                questionCount++;
//            }
//
//            System.out.println("Thank you for playing Who Wants to Be a Millionaire!");
//        } catch (IOException e) {
//            System.out.println("Failed to load questions: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }
//    }


