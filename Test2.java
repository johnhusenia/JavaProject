package project1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test2 {
	
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
    public static List<Question> loadQuestions(String filePath, int range1, int range2) throws IOException {
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
        
    	List<Question> firstTenQuestions = questions.subList(range1, range2);
    	Collections.shuffle(firstTenQuestions);
        return firstTenQuestions;
    }
    
    public static void main(String[] args) {
    	
    	try {
        	List<Question> questions = loadQuestions("C:\\Users\\clahu\\Desktop\\JAVA\\GProject\\src\\project1\\questions.txt",0,5);
        	
        	System.out.println("Question "+ (0) +": " + questions.get(0).question);
        	System.out.println("Question "+ (1) +": " + questions.get(1).question);
        	System.out.println("Question "+ (2) +": " + questions.get(2).question);
        	System.out.println("Question "+ (3) +": " + questions.get(3).question);
        	System.out.println("Question "+ (4) +": " + questions.get(4).question);
    	}catch (IOException e) {
            System.out.println("Failed to load questions: " + e.getMessage());
        }
    }
}
