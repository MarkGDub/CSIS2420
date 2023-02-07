package ceRecursion;

public class Recursion {

	/*
	 * 
	 */
	public static void hailstone(int seed) {
		if(seed <= 0) {
			throw new IllegalArgumentException("Hailstone seed needs to be a positive number");
		}
		
		System.out.print(seed + " ");

		if(seed == 1) {
			System.out.println();
		} 
		else {
			if(seed % 2 == 0) {
				hailstone(seed / 2);
			} else {
				hailstone(seed * 3  + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		hailstone(3);
		hailstone(16);
		hailstone(17);
		hailstone(24);
		
	}
}
