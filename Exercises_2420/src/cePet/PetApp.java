package cePet;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Application to practice the use of symbol table methods
 * from class BinarySearchST.
 * 
 * @author CSIS Starter Code + Mark GW
 */
public class PetApp {
	
	public static void printValueOfKeys(Integer[] keys, BinarySearchST<Integer, Pet> st) {
		for(Integer key: keys) {
			System.out.println(getKey(key, st));
		}
	}
	
	public static String getKey(Integer key, BinarySearchST<Integer, Pet> st) {
		return "Key " + key + ": " +  (st.contains(key) ? st.get(key) : "Key not found in symbol table");
	}
	
	public static void main(String[] args) {
		BinarySearchST<Integer, Pet> st = new BinarySearchST<>();
		
		st.put(StdRandom.uniformInt(10, 31), new Pet("Buddy", 8, "dog"));
		
		
		Pet[] pets = {
				new Pet("Bobo", 50, "tortoise"),
				new Pet("Hazel", 4, "rat"),
				new Pet("Smokey", 5, "goldfish"),
				new Pet("Bella", 5, "cat"),
				new Pet("Leo", 9, "tortoise"),
				new Pet("Garfield", 6, "cat"),
				new Pet("Maddox", 2, "dog"),
				new Pet("Sylvester", 7, "cat"),
				new Pet("Wolf", 9, "dog")
		};
		
		
		for(Pet pet: pets) {
			int key = StdRandom.uniformInt(10, 31);
			
			while(st.contains(key)) {
				key = StdRandom.uniformInt(10, 31);
			}
			
			st.put(key, pet);
		}
		
		System.out.print("All keys: ");
		for(Integer key: st.keys()) {
			System.out.print(key + " ");
		}
		System.out.println();
		
		System.out.print("Pet names: ");
		for(Integer key: st.keys()) {
			System.out.print(st.get(key).getName() + " ");
		}
		System.out.println();

		Integer[] keys = {10, 17 , 23};
		printValueOfKeys(keys, st);
		
		System.out.println("Smallest Key: " + st.min());
		
		System.out.println("Biggest key closest to 17: " + st.ceiling(18));
		
		System.out.println("Number of pets: " + st.size());
		
		st.put(30, new Pet("Waldi", 3, "dog"));
		
		System.out.println("Keys under 25: " + st.rank(25));
		
		System.out.println("Pet at " + getKey(30, st));
		
		int secondSmallestKey = st.select(1);
		System.out.println("Second smallest pet at " + getKey(secondSmallestKey, st));
		
		st.put(30, new Pet("Strolch", 3, "dog"));
		
		System.out.println("---------------- Pets ---------------");
		System.out.printf("| %-10s | %-20s |%n", "key", "pet");
		System.out.println("-------------------------------------");
		for(Integer key: st.keys()) {
			System.out.printf("| %-10s | %-20s |%n", key, st.get(key));
		}
		System.out.println("-------------------------------------");
	}

}
