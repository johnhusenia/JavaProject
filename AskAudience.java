import java.util.ArrayList;
import java.util.Collections;

public class AskAudience extends LifeLine{

	public AskAudience(String name) {
		super(name);
	}

	public void executeLifeLine(Question q) {
		ArrayList<Option> possibleOpt = new ArrayList<>();
		ArrayList<Option> goodOpt = new ArrayList<>();
		ArrayList<Option> wrongOpt = new ArrayList<>();
		for(Option opt: q.getOptions()) {
			if(opt.isCorrect) {
				goodOpt.add(opt);
			}else {
				wrongOpt.add(opt);
			}
		}
		Collections.shuffle(wrongOpt);
		
		int index1 = random.nextInt(2); //50% probability of answer in the result
		if(index1 == 0) {
			possibleOpt.add(goodOpt.get(index1));
		}
		int index2 = random.nextInt(3);
		possibleOpt.add(wrongOpt.get(index2));
		wrongOpt.remove(index2);
		if(possibleOpt.size()<2) {
			int index3 = random.nextInt(2);
			possibleOpt.add(wrongOpt.get(index3));
			wrongOpt.remove(index3);
			
		}
		q.setOptions(possibleOpt);
	}
}
