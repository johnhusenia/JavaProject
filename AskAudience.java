

public class AskAudience extends LifeLine{

	public AskAudience(String name) {
		super(name);
	}

	public void executeLifeLine(Question q) {
        int[] abcd = {0,0,0,0};

        // Generate a random number between 0 (inclusive) and 4 (exclusive)
        for(int i = 0; i<50; i++) {

        int randomNumber = random.nextInt(4);
        
        switch(randomNumber) {
        
        case 0:{
        	abcd[0] += 1;
        break;}
       
        case 1:{
        	abcd[1] += 1;
        break;}
        
        case 2:{
        	abcd[2] += 1;
        break;}
        
        case 3:{
        	abcd[3] += 1;
        break;}
        	

        }
        }
        int i = 0;
        for(Option opt: q.getOptions()) {
        	
        	opt.setMessage(opt.getMessage()+" "+abcd[i]*2+"%");
        	i++;
        	
        }
		
		
		
	}
}
