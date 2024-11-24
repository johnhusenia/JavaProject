import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// BankQuestions has a list of all the questions in the path file 
public class BankQuestions {
	private static Path path = Paths.get("bankOfQuestions.txt");
	private ArrayList<Question> questions;
	
	public BankQuestions() {
		this.questions = new ArrayList<>();
	}

	// read the path file with the questions, options and answers and following the structure of the .txt file create 
	// Questions and Options, setting all Questions false because hasn't been answered yet and all Options false 
	// with the exception of the correct option (answer) that is set true
	public void readFile(String category){
        File file = new File(path.toString());
        if (!file.exists()) {
            System.out.println("File does not exist; We cannot read it!");
            System.exit(0);
        }
        try ( Scanner input = new Scanner(file); ) {
            while (input.hasNext()) {
                String question1 = input.nextLine();
                String option1 = input.nextLine();
                String option2 = input.nextLine();
                String option3 = input.nextLine();
                String option4 = input.nextLine();
                String answer  = input.nextLine();
                input.nextLine(); // in the file between after each answer there is a blank line
                
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(option1, false));
                options.add(new Option(option2, false));
                options.add(new Option(option3, false));
                options.add(new Option(option4, false));
                
                // iterate the Option list to check which one is the answer and change the value to true
                for(Option option: options) { 
                	// the first character is used to check if the option is the answer
                	String letter = option.getMessage().split(": ")[0]; 
                	if (letter.equals(answer)) {
                		option.setIsCorrect(true);
                	}
                }
                
                Question question = new Question(category, question1);
                question.setOptions(options);
                questions.add(question);
            }
            Collections.shuffle(questions);
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	
}
