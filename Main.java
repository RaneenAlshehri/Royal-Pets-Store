
package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
	
	static List<Person> persons = new ArrayList<Person>();

	public static void main(String[] args) {
		System.out.println(printStore());
		System.out.println("Animals List :: "+"\n");
		animalList().forEach(System.out::println);
		
		//Create a Scanner for asking user input
		Scanner in = new Scanner(System.in);
		
		boolean isExit = false;
		
		while(!isExit) {
			
			if(persons.size() > 0) {
				System.out.println("Animal Reserve Status :: ");
				persons.forEach(System.out:: println);
			}
			
			System.out.println("Please choose an animal by id ( -1 to exit )");
			int animalNumber = in.nextInt();
			
			if(checkingAnimalIsExists(animalNumber)) {
				
				// checking if number is -1
				if(animalNumber == -1) {
					break;
				}
				
				in.nextLine();
				
				Animal selectedAnimal = getAnimalById(animalNumber);
				boolean isAlreadyBooked = checkingAnimalIsAlreadyBooked(animalNumber);
				if(!isAlreadyBooked) {
					
					System.out.print("Please enter your name : ");
					String name = in.nextLine();
					
					System.out.print("Please enter your location (city): ");
					String city = in.nextLine();
					
					System.out.print("Please enter your location (street): ");
					String street = in.nextLine();
					
					System.out.print("Please enter your location (zipCode): ");
					int zipCode = in.nextInt();
					
					Person person = new Person(name);
					
					Location location = new Location(city,street,zipCode);
					
					// setting location to a person
					person.setLocation(location);
					// adding animal to a person's animal
					person.getAnimals().add(selectedAnimal);
					
					//animalList().remove(selectedAnimal);
					addPerson(person);
					
					newLine();
					System.out.println("Animals List :: "+"\n");
					animalList().forEach(System.out:: println);
					
				}else {
					System.out.println("Animal was already reserved");
					newLine();
					
					System.out.println("Animals List :: "+"\n");
					animalList().forEach(System.out:: println);
				}
			}else {
				// checking if number is -1
				if(animalNumber == -1) {
					break;
				}
				System.out.println("Animal not found !");
			}
		}
		
		// Closing Scanner...
		in.close();
		
		System.out.println("Animals List :: "+"\n");
		animalList().forEach(System.out:: println);
		newLine();
		
		if(persons.size() > 0) {
			System.out.println("Animal Reserve Status :: ");
			persons.forEach(System.out:: println);
		}
	}

	// Print welcome message 
	public static String printStore() {

		Store store = new Store();
		store.setNumber(1);
		store.setName("Royal Pets");
		store.setLocation("Aaudi Arabia");

		return store.toString();
	}
	
	// List of animal
	public static List<Animal> animalList(){
		List<Animal> animals = Arrays.asList(
                new Animal(1,"monkey", 2),
                new Animal(2,"Cat", 1),
                new Animal(3,"Dogs", 7),
                new Animal(4,"Rabbit", 4),
                new Animal(5,"Parrot", 5)
        );
		
		return animals;
	}
	
	// List of persons
	public static void addPerson(Person person){
		if(null != person.getName()) {
			Optional<Person> optional = lookupPerson(person.getName());
			if(!optional.isPresent()) {
				persons.add(person);
			}
		}
	}
	
	// Lookup person by name
	public static Optional<Person> lookupPerson(String personName) {
	    return persons.stream()
	        .filter(p -> p.getName().equals(personName))
	        .findFirst();
	}
	
	public static boolean checkingAnimalIsAlreadyBooked(int number) {
		return persons.stream().filter(person -> person.getAnimals().stream().filter(animal -> animal.getId() == number).findFirst().isPresent()).findFirst().isPresent();
	}
	
	public static boolean checkingAnimalIsExists(int number) {
		return animalList().stream().filter(animal -> animal.getId() == number).findFirst().isPresent();
	}
	
	public static Animal getAnimalById(int id) {
    	return animalList().stream().filter(animal -> animal.getId() == id).findFirst().orElse(null);
    }
	
	public static void newLine(){
		System.out.println("\n");
	}

}

        
        
        
    
    
