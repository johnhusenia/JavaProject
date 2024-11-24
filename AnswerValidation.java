
public class AnswerValidation {

	public Boolean abcdl(String answer) { // allows the user to choose an option. L is for life line.
		String[] options = { "A", "B", "C", "D", "L" }; // Array of strings with options.
		Boolean answer1 = false; // This variable will be used to track whether the user's input is valid or not.
		answer = answer.toUpperCase();
		for (String option : options) { // for-each loop: For each iteration, the current option from the array is
										// assigned to the variable option.
			if (option.equals(answer)) { // This checks if the current option in the array is equal to the user's
											// answer.
				answer1 = true; // If the user's answer matches the current option, answer1 is set to true,
								// indicating that the user's input is valid.
				break; // The break statement exits the loop as soon as a match is found.
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answer from the choices:");
		}
		return answer1; // This returns the value of answer1 (either true or false) to the caller of the
						// method.

	}

	public Boolean abcd(String answer) { // When the life line is no longer available
		String[] options = { "A", "B", "C", "D" };
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

	public Boolean name(String answer) { // Making sure user have not used numbers and symbols for name
		Boolean answer1 = false; // The variable will be used to store whether the input is valid (true) or
									// invalid (false).

		if (answer.trim().isEmpty()) {
			/*
			 * his checks if the answer string is empty or consists only of whitespace
			 * characters. The method trim() removes any leading and trailing spaces, and
			 * isEmpty() checks if the resulting string has no characters.
			 */
			System.out.println("You cannot use space/blank as a name!!!");
			System.out.print("Please enter a valid name:");
		} else {

			for (char ch : answer.toCharArray()) {
				/*This is a for-each loop that iterates through each character (ch) in the answer string.
                The toCharArray() method converts the string into an array of characters so that each character can be checked individually.*/
				// This is if will deny any non letters and will not deny space between user input name
				if (!Character.isLetter(ch) && ch != ' ') {
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
		Integer[] options = { 1, 2, 3 };
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
		String[] options = { "1", "2" };
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

	public Boolean fifty(String answer, String[] fopt) { 	// Handling 50/50 situation, answer is a String representing the user's input
															//The String [] fopt is the available options
		Boolean answer1 = false;
		for (String option : fopt) {	//for-each loop that iterates through each string (option) in the fopt array.
			                            //Each option in the array is checked to see if it matches the user's answer.
			if (option.charAt(0) == answer.charAt(0)) {// checks if the first character of the option (option.charAt(0)) 
				                        //is the same as the first character of the answer (answer.charAt(0)).
				answer1 = true;			//charAt(0) returns the first character of the string. 
										//If the first character of option matches the first character of answer, then answer1 is set to true, 
										//indicating that the user's input is valid.
				break;
			}
		}
		if (answer1 == false) {
			System.out.print("Your input is invalid. Please choose your answers from the choices: ");
		}
		return answer1;

	}

	public Boolean lifeop(Integer answer, Integer lifecount) {
		Integer[] options = { 1, 2, 3 };
		Boolean answer1 = false;
		if (answer > lifecount) {
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
