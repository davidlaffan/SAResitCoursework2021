
public class Product {
	public String productCode;
	public int quantity;
	public String productName;
	
	public Product (String p) {
		this.productName = p;
	}
	
	public Product (String pn, int q, String pc) {
		this.productName = pn;
		this.quantity = q;
		this.productCode = pc;
	}
	
	public Product (String pn, String pc) {
		this.productName = pn;
		this.productCode = pc;
	}
	
	public Product (String pn, int q) {
		this.productName = pn;
		this.quantity = q;
	}
	
	public boolean equals(String i) {
		return productName.equals(i);
	}
	
	public String toString() {
		String o = "Name: " + productName + System.lineSeparator();
		//product code removed due to errors
		try { //if int is unassigned it will throw an exception 
			o = o + "Amount in stock: "+ quantity + System.lineSeparator();
		}
		catch (Exception e){
			
		}
		return o;
	}
}
