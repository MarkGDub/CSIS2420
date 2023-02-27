package ceStable;

import java.util.Comparator;

/*
 * Represents a friend defined by the name and age
 * @author Mark GW
 */
public class Friend implements Comparable<Friend>{
	private String name;
	private int age;
	
	static public final Comparator<Friend> BY_AGE = new AgeComparator();
	
	public Friend(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name+"("+age+")";
	}

	/**
	 * Compares by name the natural order.<p>
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Friend other) {
		
		return this.name.compareTo(other.name);
	}
	
	/*
	 * Provides an additional way to compare friends
	 */
	private static class AgeComparator implements Comparator<Friend>{

		@Override
		public int compare(Friend friend1, Friend friend2) {
			
			return Integer.compare(friend1.age, friend2.age);
		}
		
	}
	
	
}
