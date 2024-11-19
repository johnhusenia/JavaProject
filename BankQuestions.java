import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BankQuestions {
	static String path = "/Users/edwin/Documents/1S_DatabaseAppDev/javaProgramming/groupProject/project/JavaProject/bankOfQuestions.txt";
	ArrayList<Question> questions;
	
	public BankQuestions() {
		this.questions = new ArrayList<>();
	}

	public void readFile(String category){
        File file = new File(path);
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
                input.nextLine();
                
                ArrayList<Option> options = new ArrayList<>();
                options.add(new Option(option1, false));
                options.add(new Option(option2, false));
                options.add(new Option(option3, false));
                options.add(new Option(option4, false));
                
                for(Option option: options) {
                	String letter = option.getMessage().split(": ")[0];
                	if (letter.equals(answer)) {
                		option.setIsCorrect(true);
                	}
                }
                
                Question question = new Question(category, question1);
                question.setOptions(options);
                questions.add(question);
            }
//            Collections.shuffle(questions);
            
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
