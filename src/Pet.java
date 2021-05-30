import java.util.ArrayList;
public class Pet{
	public String type;
	private ArrayList<Product> stock = new ArrayList<Product>();//arraylist of food
	public Pet(String t) {
		this.type = t; //Will have the first letter uppercase and rest lowercase
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
	
	public void addProduct(String n){
		Product i = new Product(n);
		stock.add(i);//new food
	}
	
	public void addProduct(String n, int q){
		Product i = new Product(n);
		stock.add(i);//new food
	}
	
	public void addProduct(String n, int q, String c){
		Product i = new Product(n);
		stock.add(i);//new food
	}
	
	public void addProduct(String n, String c){
		Product i = new Product(n);
		stock.add(i);//new food
	}
	
	public Product findProduct(String i){
		if (stock.indexOf(i) == -1) {
			return null;
		}
		else{
			return stock.get(stock.indexOf(i));
		}//find food
	}
	
	
	public void removeProduct(int i) {
		//TODO implement further
		i--;
		stock.remove(i);
	}
	
	public String showProducts() {
		String o = "";
		int length = stock.size();//get list length
		for (int i = 0; i<length; i++){//for each list element
			o = o + String.valueOf(i+1) + ".";
			o = o + stock.get(i).toString();//get product name, code, and quantity where applicable
			System.lineSeparator();//new line
		}
		return o;
	}
	
	public boolean hasProduct() {
		return !stock.isEmpty(); //returns if the list is empty, opposite of what the user wants
	}
	
}
