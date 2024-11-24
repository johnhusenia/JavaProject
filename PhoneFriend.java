
// PhoneFriend subclass of LifeLine, it has the parent properties and methods
public class PhoneFriend extends LifeLine{

	public PhoneFriend(String name) {
		super(name);
	}

	@Override
	// in this case executeLifeLine follow the logic of the PhoneFriend lifeline
	public void executeLifeLine(Question q) {
		// a random number from 0 to 3 is generated to get the Option from the Question list of Options and 
		// update the message of the Option. 
        int randomNumber = random.nextInt(4); // Friend has 25% probability of answer correctly 
        for(int i=0; i<q.getOptions().size()-1; i++) {
        	if(randomNumber==i) {
        		Option opt = q.getOptions().get(i);
        		opt.setMessage(opt.getMessage()+" "+"(This what your friend picked!)");
        	}
        }
	}
}
