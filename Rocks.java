
public class Rocks implements Measurable {
	
	// weight in grams
	private int weight;
	
	public Rocks(int w) {
		weight = w;
	}

	@Override
	public int getMeasure() {
		return weight;
	}
	
	@Override
	public boolean equals(Object o) {
		// cast o to Rocks 
		Rocks otherRock = (Rocks) o;
		
		// compare this rock's weight to the other rock's that was passed in
		return this.weight == otherRock.weight;	
	}
	
	@Override 
	public String toString() {
		return "Rock weight: " + weight + "g";
	}
}
