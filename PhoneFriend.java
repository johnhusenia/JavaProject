import java.util.ArrayList;
import java.util.Collections;

public class PhoneFriend extends LifeLine{

	public PhoneFriend(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
		 
		int index = random.nextInt(4); //75% probability of answer in the result
		if(index==0) {
			possibleOpt.add(wrongOpt.get(index));
		}else {
			System.out.println(index);
			possibleOpt.add(goodOpt.get(0));
		}
		q.setOptions(possibleOpt);
	}
}
