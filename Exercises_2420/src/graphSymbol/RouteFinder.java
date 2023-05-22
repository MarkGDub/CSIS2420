package graphSymbol;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RouteFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "src/graphSymbol/resources/routes.txt"; // args[0];
		String delimiter = " "; // args[1];
		SymbolGraph sg = new SymbolGraph(filename, delimiter);
		Graph graph = sg.graph();

		StdOut.print("Please enter an airport: ");
		while (StdIn.hasNextLine()) {

			String source = StdIn.readLine();
			if (sg.contains(source)) {
				int index = sg.indexOf(source);
				BreadthFirstPaths bfp = new BreadthFirstPaths(graph, index);
				for (int v = 0; v < graph.V(); v++) {
					if (bfp.hasPathTo(v)) {
						StdOut.print(sg.nameOf(v) + ": ");
						for (Integer airport : bfp.pathTo(v)) {
							StdOut.print(sg.nameOf(airport) + " ");
						}
					} else {
						StdOut.print("No path");
					}
					StdOut.println();
				}
			} else {
				StdOut.println("input not contain '" + source + "'");
			}
		}
	}

}
