package graphGeneration;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DigraphGenerator;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author mark gowarty-weinstock
 *
 */
public class DemoGraphGeneration {

	public static void main(String[] args) {
		Digraph graph = DigraphGenerator.simple(7, 11);

		StdOut.println(graph);

	}

}
