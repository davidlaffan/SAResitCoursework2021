import java.util.Scanner;

public class main {
static BinarySearchTree pets = new BinarySearchTree();
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		//TODO new pet
	    String petName;
	    System.out.println("Enter pet type"); 
	    petName = myObj.nextLine();   
	    newPet(petName);
	    System.out.println("Enter pet type"); 
	    petName = myObj.nextLine();   
	    newPet(petName);
	    showAll();
		//TODO new product for pet
		//TODO search for pet AND see if any products exist
		//TODO list all pets
		//
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
	
	public static void removePet() {
		
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
