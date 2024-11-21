
public class AnswerValidation {
	
	public Boolean abc(String answer) {
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
			System.out.println("Your answer is invalid. Please choose your answer from the choices");
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
			System.out.println("Your answer is invalid. Please choose your answers from the choices");
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
			System.out.println("Your answer is invalid. Please choose your answers from the choices");
		}
		return answer1;
		
	}

}
