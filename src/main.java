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
	    
		//TODO new product for pet
		//TODO search for pet AND see if any products exist
		//TODO list all pets
		//
	}
	public static void newPet(String n){
		Pet i = new Pet (n);
		pets.addNode(i); //https://gist.github.com/provencher/11357144 ??
	}
	

}
