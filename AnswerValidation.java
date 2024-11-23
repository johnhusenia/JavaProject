
public class AnswerValidation {
		
	public Boolean abcdl(String answer) {
		String[] options = {"A", "B", "C", "D","L"};
		Boolean answer1 = false;
		answer = answer.toUpperCase();
		for (String option : options) {
			if (option.equals(answer)) {
				answer1 = true;
				break;
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answer from the choices:");
		}
		return answer1;
		
	}
	public Boolean abcd(String answer) {
		String[] options = {"A", "B", "C", "D"};
		Boolean answer1 = false;
		answer = answer.toUpperCase();
		for (String option : options) {
			if (option.equals(answer)) {
				answer1 = true;
				break;
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answer from the choices:");
		}
		return answer1;
	}
	
	public Boolean name(String answer) {
	    Boolean answer1 = false;

	    
	    if (answer.trim().isEmpty()) {
	        System.out.println("You cannot use space/blank as a name!!!");
	        System.out.print("Please enter a valid name:");
	    } else {
	        
	        for (char ch : answer.toCharArray()) {
	        	// This is if will deny any non letters and will not deny space between your names
	            if (!Character.isLetter(ch)&& ch != ' ') { 
	            	System.out.println("You cannot use non-letter characters in a name!");
	                System.out.println("Please enter a valid name: ");
	                return false;  
	            }
	        }
	       
	        answer1 = true;
	    }

	    return answer1;
	}
	
	
	public Boolean number1(Integer answer) {
		Integer[] options = {1, 2, 3};
		Boolean answer1 = false;
		for (Integer option : options) {
			if (option.equals(answer)) {
				answer1 = true;
				break;
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
		}
		return answer1;
		
	}
	
	public Boolean number2(String answer) {
		String[] options = {"1", "2"};
		Boolean answer1 = false;
		for (String option : options) {
			if (option.equals(answer)) {
				answer1 = true;
				break;
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
		}
		return answer1;
		
	}
	public Boolean fifty(String answer, String[] fopt) {
		Boolean answer1 = false;
		for (String option : fopt) {
			if (option.charAt(0) == answer.charAt(0)) {
				answer1 = true;
				break;
			}
        }
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
		}
		return answer1;
		
	}
	
	public Boolean lifeop(Integer answer, Integer lifecount) {
		Integer[] options = {1, 2, 3};
		Boolean answer1 = false;
		if(answer>lifecount) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
			return answer1;
		}
		for (Integer option : options) {
			
			if (option.equals(answer)) {
				answer1 = true;
				break;
			}
			
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
		}
		return answer1;
		
	}
	
	
	

}
