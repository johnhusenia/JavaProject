import java.util.ArrayList;

// Fifty_Fifty subclass of LifeLine, it has the parent properties and methods
public class Fifty_Fifty extends LifeLine{
	
	public Fifty_Fifty(String name) {
		super(name);
	}

	@Override
	// in this case executeLifeLine follow the logic of the Fifty_Fifty lifeline
	public void executeLifeLine(Question q) {
		ArrayList<Option> possibleOpt = new ArrayList<>();
		ArrayList<Option> wrongOpt = new ArrayList<>();
		ArrayList<Option> sortedOpt = new ArrayList<>();
		
		int i = 0;
		int b = 0;
		for(Option opt: q.getOptions()) {
			if(opt.getIsCorrect()){
				possibleOpt.add(opt); //100% probability of answer in the result
				b = i;
			}else {
				wrongOpt.add(opt);
			}
			i++;
		}
		int index = random.nextInt(wrongOpt.size());
		possibleOpt.add(wrongOpt.get(index));
		
		//this conditional just sort the possibleOpt
		if(b>index) {	
			sortedOpt.add(possibleOpt.get(1));
			sortedOpt.add(possibleOpt.get(0));
		}else {
			sortedOpt.add(possibleOpt.get(0));
			sortedOpt.add(possibleOpt.get(1));
		}
		q.setOptions(sortedOpt); // number of Options for the question now change 
	}
	
}


