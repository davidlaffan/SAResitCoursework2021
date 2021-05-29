
public class Pet{
	public String type;
	//arraylist of food
	public Pet(String t) {
		this.type = t;
	}
	public int compareTo(Pet arg0) {
		return type.compareTo(arg0.type);
	}
	
	@Override
	public String toString() {
	String o = "Pet type: " + type + System.lineSeparator();
	//TODO Implement
	return o;
	}
	
	//new food
	//find food
	

}
