
// AskAudience subclass of LifeLine, it has the parent properties and methods
public class AskAudience extends LifeLine{

	public AskAudience(String name) {
		super(name);
	}

	@Override
	// in this case executeLifeLine follow the logic of the AskAudience lifeline
	public void executeLifeLine(Question q) {
        int[] probab = {0,0,0,0};
        
        // update the values in the list of probab  
        for(int i = 0; i<50; i++) {
	        int randomNumber = random.nextInt(4);
	        switch(randomNumber) {
		        case 0:
		        	probab[0] += 1;
		        	break;
		        case 1:
		        	probab[1] += 1;
		        	break;
		        case 2:
		        	probab[2] += 1;
		        	break;
		        case 3:
		        	probab[3] += 1;
		        	break;
	        }
        }
        
        // iterate the list of Options in the Question and add the percentage to the Option message
        int i = 0;
        for(Option opt: q.getOptions()) {
        	opt.setMessage(opt.getMessage()+" "+probab[i]*2+"%");
        	i++;
        }
	}
}
