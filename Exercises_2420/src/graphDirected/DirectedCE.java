package graphDirected;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

public class DirectedCE {

	public static void main(String[] args) {
		String fileName = "src/graphDirected/Resources/TopologicalOrderGraph.txt";

		In in = new In(fileName);

		Digraph graph = new Digraph(in);

		Topological topological = new Topological(graph);

		StdOut.println("Topological Order");
		if (topological.hasOrder()) {
			StdOut.println(topological.order());
			StdOut.println();

			StdOut.printf("%6s | %6s", "vertex", "order");
			StdOut.println();
			StdOut.println("----------------");
			for (int v = 0; v < graph.V(); v++) {
				int order = topological.rank(v);
				StdOut.printf("%6s | %6s", v, order);
				StdOut.println();
			}
		} else {
			StdOut.println("This graph has no topological order");
		}

	}

}
