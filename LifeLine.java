import java.util.Random;

// LifeLine is a parent class that contains name and random and excecuteLifeLine method.
// We can't create a instance of LifeLine object but an instance of its subclasses
public abstract class LifeLine {
	// the constructor and properties are the same for the subclasses
	String name;
	Random random;

	public LifeLine(String name) {
		super();
		this.name = name;
		this.random = new Random();
	}

	// each subclass has to implement the executeLifeLine method but with the corresponding logic
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
