import java.util.ArrayList;

public class Fifty_Fifty extends LifeLine{
	
	public Fifty_Fifty(String name) {
		super(name);
	}

	public void executeLifeLine(Question q) {
		ArrayList<Option> possibleOpt = new ArrayList<>();
		ArrayList<Option> wrongOpt = new ArrayList<>();
		for(Option opt: q.getOptions()) {
			if(opt.isCorrect) {
				possibleOpt.add(opt); //100% probability of answer in the result
			}else {
				wrongOpt.add(opt);
			}
		}
		int index = random.nextInt(wrongOpt.size());
		possibleOpt.add(wrongOpt.get(index));
		q.setOptions(possibleOpt);
	}
	
}
