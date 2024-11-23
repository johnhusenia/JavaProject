public class PhoneFriend extends LifeLine{

	public PhoneFriend(String name) {
		super(name);
	}

	@Override
	public void executeLifeLine(Question q) {
        int randomNumber = random.nextInt(4);
        for(int i=0; i<q.getOptions().size()-1; i++) {
        	if(randomNumber==i) {
        		Option opt = q.getOptions().get(i);
        		opt.setMessage(opt.getMessage()+" "+"(This what your friend picked!)");
        	}
        }
	}
}
