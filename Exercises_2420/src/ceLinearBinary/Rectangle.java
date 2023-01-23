package ceLinearBinary;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a rectangle defined by its height and width
 * 
 * @author Mark Gowarty-Weinstock
 *
 */
public class Rectangle implements Comparable<Rectangle> {
	
	private float height;
	private float width;

	public Rectangle(float height, float width) {
		this.height = height;
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}
	
	/**
	 * Calculates the area of this rectangle
	 * 
	 * @return the area
	 */
	public float area() {
		return height * width;
	}
	
	/**
	 * Calculates the circumference of this rectangle
	 * 
	 * @return the circumference
	 */
	public float circumference() {
		return (height * 2) + (width * 2);
	}
	

	@Override
	public String toString() {
		return "[" + height + " x " + width + "]";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
	}
	
	@Override
	public int compareTo(Rectangle other) {
		return Float.compare(this.area(), other.area());
	}
	
	// = = = = = = = = = = = = = = = = = = = = = = =

	public static void main(String[] args) {
		Rectangle[] rectangles = {new Rectangle(5,3),new Rectangle(2,3), new Rectangle(7,3), new Rectangle(2,6), new Rectangle(1,1), new Rectangle(4,8), new Rectangle(3,9)};
		
		System.out.println();
		System.out.println("Original: " + Arrays.toString(rectangles));
		
		System.out.println();
		Arrays.sort(rectangles);
		System.out.println("Sorted: " + Arrays.toString(rectangles));
	}
}
