import java.util.ArrayList;

public class AnswerValidation {
	
	class Option {
		ArrayList<Option> options;

	    public Option() {
	    	this.options = new ArrayList<>();
	    }
	}

	
	public Boolean ABCDL(String answer) {
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
	public Boolean ABCD(String answer) {
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
	    } else {
	        
	        for (char ch : answer.toCharArray()) {
	            if (Character.isDigit(ch)) {  
	            	 System.out.println("You cannot use number as a name!!!");
	                System.out.println("Please enter a valid name: ");
	                return false;  
	            }
	        }
	       
	        answer1 = true;
	    }
	    if (answer1 == false) {
			System.out.print("Please enter a valid name:");
		}

	    return answer1;
	}
	
	
	public Boolean Number1(Integer answer) {
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
	
	public Boolean Number2(String answer) {
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
	
	
	

}
