import java.util.Random;

public abstract class LifeLine {
	String name;
	Random random;

	public LifeLine(String name) {
		super();
		this.name = name;
		this.random = new Random();
	}

	public void executeLifeLine(Question q) {};
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	

}
