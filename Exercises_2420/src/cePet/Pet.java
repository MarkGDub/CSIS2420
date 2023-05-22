package cePet;

// = = = this class should not be modified = = =

/**
 * Class Pet represents a pet object with a name, age, and species.
 * 
 * @author CSIS Starter Code 
 *
 */
public class Pet {
	private String name;
	private int age;
	private String species;
	
	/**
	 * Constructs a new Pet object with the given name, age, and species.
	 * 
	 * @param name 
	 * @param age
	 * @param species
	 */
	public Pet(String name, int age, String species) {
		this.name = name;
		this.age = age;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return species + " " + name + " (" + age + ")";
	}

}
