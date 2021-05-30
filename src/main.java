import java.util.Scanner;

public class main {
static BinarySearchTree pets = new BinarySearchTree();
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		/*
		 * Add details of a new pet type; 1
		 * Add details of a new product for a specified pet type; 2
		 * Find if the company stocks products for a particular type of pet; 3
		 * Display all the types of pets that the company provides products for; 4
		 * Display all the products stocked for a specific pet type; 5
		 * Display all the product details for all the pets; 6
		 * Remove a particular product for a specified pet (eg discontinued ítem); 7
		 * Remove a pet type from the system. 8
		 */
		boolean exit = false;
		while (exit != true) {
		System.out.println('\f');
		System.out.println("Please enter your service option");
		System.out.println("1. Add details of a new pet type");
		System.out.println("2. Add details of a new product for a specified pet type");
		System.out.println("3. Find if the company stocks products for a particular type of pet");
		System.out.println("4. Display all the types of pets that the company provides products for");
		System.out.println("5. Display all the products stocked for a specific pet type");
		System.out.println("6. Display all the product details for all the pets");
		System.out.println("7. Remove a particular product for a specified pet");
		System.out.println("8. Exit");
		try {
			int menuOption = Integer.parseInt(myObj.nextLine());
			if (menuOption == 1){//1
		    String petName;
		    System.out.println("Enter pet type"); 
		    petName = myObj.nextLine();  
		    petName = upperCaseFirst(petName);
		    newPet(petName);
			}
			else if (menuOption == 2){//2
		    String find;
		    System.out.println("Enter pet type"); 
		    find = myObj.nextLine();
		    find = upperCaseFirst(find);
		    if (pets.findNode(find) != null) {
		    	Pet pet = pets.findNode(find).key;
		    	String productName;
			    System.out.println("Enter product name"); 
			    productName = myObj.nextLine();//name
			    String qOption; //if it has a quantity or not
			    System.out.println("Do you know the quantity? [enter 'Y' or 'N']"); 
			    qOption = myObj.nextLine();
			    qOption = qOption.toUpperCase();
			    int quantity=0;///only way I can do it
			    if (qOption.equals("Y")) { //if it has a quantity or not
				    System.out.println("Please enter the quantity (digits only)"); 
				    try {
				    quantity = Integer.parseInt(myObj.nextLine());//quantity (optional)
				    }
				    catch (Exception e) { //number was not entered 
				    System.out.println("Number was not entered, returning to main menu");
				    }
			    }
			  //product code (optional)
			    //if it has a code or not
			    System.out.println("Do you know the product code? [enter 'Y' or 'N']"); 
			    qOption = myObj.nextLine();
			    qOption = qOption.toUpperCase();
			    if (qOption.equals("Y")) {
				    System.out.println("Please enter the product code"); 
				    String pCode= myObj.nextLine();//quantity (optional)
				    try {
				    	pet.addProduct(productName, quantity, pCode);
				    }
				    catch (Exception e) {
				    	pet.addProduct(productName, pCode);
				    }
			    }
			    else {
			    	try {
			    		pet.addProduct(productName, quantity, "[UNKNOWN]");
			    	}
			    	catch (Exception e) {
			    		pet.addProduct(productName, "[UNKNOWN]");
			    	}
			    }
			    }
		    else {
		    	System.out.println("Pet not found, returning to menu");//error
		    }
			}
			else if (menuOption == 3){//3
		    String findPet;
		    boolean stocks = false;
		    System.out.println("Enter pet type"); 
		    findPet = myObj.nextLine();
		    findPet = upperCaseFirst(findPet);
		    if (pets.findNode(findPet) != null) {
		    	stocks = pets.findNode(findPet).key.hasProduct();
		    }
		    else {
		    	
		    }
		    if (stocks = true) {
		    	System.out.println("We sell stock for " + findPet);
		    }
		    else {
		    	System.out.println("We don't stock for " + findPet);
		    }
			}
			else if (menuOption == 4){//4
		    showAll();
			}
			else if (menuOption == 5) {//5. Display all the products stocked for a specific pet type
				String findPet;
			    System.out.println("Enter pet type"); 
			    findPet = myObj.nextLine();
			    findPet = upperCaseFirst(findPet);
			    if (pets.findNode(findPet) != null) {
			    	System.out.println(findPet + ";");
			    	System.out.println(pets.findNode(findPet).key.showProducts());
			    }
			    else {
			    	System.out.println("Animal could not be found, returning to main menu");
			    }
			}
			else if (menuOption == 6){//6
				pets.inOrderTraverseTreeProducts(pets.root);
			}
			else if (menuOption == 7) {
				String findPet;
			    System.out.println("Enter pet type"); 
			    findPet = myObj.nextLine();
			    findPet = upperCaseFirst(findPet);
			    Node result = pets.findNode(findPet);
			    if (result != null) {
			    	System.out.println(findPet + ";");
			    	System.out.println(result.key.showProducts());
			    	System.out.println("Please enter the number of the product you wish to delete");
			    	int option;
			    	try {
			    		option = Integer.parseInt(myObj.nextLine());
			    		result.key.removeProduct(option);
			    	}
			    	catch(Exception e) {
			    		System.out.println("Invalid input");
			    	}
			    }
			    else {
			    	System.out.println("Animal could not be found, returning to main menu");
			    }
			}//7
			else if (menuOption == 8){
				System.exit(0);
			}
			else {
				System.out.println("Invalid option, please enter a number between 1 and 9");
			}
		}
		catch (Exception e) {
			System.out.println("Invalid input, returning to menu");
		}
		
		}
	}
	public static void newPet(String n){
		n = upperCaseFirst(n);
		Pet i = new Pet (n);
		pets.addNode(i); //https://gist.github.com/provencher/11357144 ??
	}
	
	public static void findPet(String i) {
		i = upperCaseFirst(i);
		Node r = pets.findNode(i);
		if (r.key == null) {
			System.out.println("Not found");
		}
		else {
			System.out.println(r.key.toString());
		}
	}
	
	public static void showAll() {
		pets.inOrderTraverseTree(pets.root);
	}
	
	public static String upperCaseFirst(String value) {
		value = value.toLowerCase();
        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }//modified from https://www.dotnetperls.com/uppercase-first-letter-java
	
	
}
