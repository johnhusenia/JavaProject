import java.util.ArrayList;


public class Fifty_Fifty extends LifeLine{
	
	public Fifty_Fifty(String name) {
		super(name);
	}

	@Override
	public void executeLifeLine(Question q) {
		ArrayList<Option> possibleOpt = new ArrayList<>();
		ArrayList<Option> wrongOpt = new ArrayList<>();
		ArrayList<Option> sortedOpt = new ArrayList<>();
		
		int i = 0;
		int b = 0;
		for(Option opt: q.getOptions()) {
			if(opt.isCorrect) {
				possibleOpt.add(opt); //100% probability of answer in the result
				b = i;
			}else {
				wrongOpt.add(opt);
			}
			i++;
		}
		int index = random.nextInt(wrongOpt.size());
		possibleOpt.add(wrongOpt.get(index));
		
		if(b>index) {	//just sort the options
			sortedOpt.add(possibleOpt.get(1));
			sortedOpt.add(possibleOpt.get(0));
		}else {
			sortedOpt.add(possibleOpt.get(0));
			sortedOpt.add(possibleOpt.get(1));
		}
		q.setOptions(sortedOpt);
	}
	
}


