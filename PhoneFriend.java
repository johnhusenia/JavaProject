import java.util.ArrayList;
import java.util.Collections;

public class PhoneFriend extends LifeLine{

	public PhoneFriend(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void executeLifeLine(Question q) {
        int i = 0;
        int randomNumber = random.nextInt(4);
        for(Option opt: q.getOptions()) {
        	
        if(randomNumber==i) {
        		opt.setMessage(opt.getMessage()+" "+"(This what your friend picked!)");
        }
        		
        	
        	i++;
        	
        }
	}
}
