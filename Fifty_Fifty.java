import java.util.ArrayList;
import java.util.Collections;

public class Fifty_Fifty extends LifeLine{
	
	public Fifty_Fifty(String name) {
		super(name);
	}

	public void executeLifeLine(Question q) {
		ArrayList<Option> possibleOpt = new ArrayList<>();
		ArrayList<Option> wrongOpt = new ArrayList<>();
		ArrayList<Option> rpossibleOpt = new ArrayList<>();
		
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
		if(b>index) {
			rpossibleOpt.add(possibleOpt.get(1));
			rpossibleOpt.add(possibleOpt.get(0));
		}else {
			rpossibleOpt.add(possibleOpt.get(0));
			rpossibleOpt.add(possibleOpt.get(1));
		}

		q.setOptions(rpossibleOpt);
	}
	
}
