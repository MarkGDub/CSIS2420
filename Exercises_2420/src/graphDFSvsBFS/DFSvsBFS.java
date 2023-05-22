package graphDFSvsBFS;

import java.util.Iterator;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DFSvsBFS {

	public static void main(String[] args) {
		String fileName = "src/graphDFSvsBFS/resources/tinyG.txt";

		In in = new In(fileName);

		Graph graph = new Graph(in);

		StdOut.println("Adj List");
		StdOut.println("--------");
		for (int v = 0; v < graph.V(); v++) {
			StdOut.print(v + ": ");
			Iterable<Integer> iterable = graph.adj(v);
			Iterator<Integer> iterator = iterable.iterator();
			while (iterator.hasNext()) {
				StdOut.print(iterator.next());

				if (iterator.hasNext()) {
					StdOut.print(" -> ");
				}
			}
			StdOut.println();

		}
		StdOut.println();

		int source = 1;

		StdOut.println("DFS");
		StdOut.println("--------");
		DepthFirstPaths dfp = new DepthFirstPaths(graph, source);
		StdOut.println("");
		for (int v = 0; v < graph.V(); v++) {
			StdOut.print(v + ": ");
			if (dfp.hasPathTo(v)) {
				Iterable<Integer> iterable = dfp.pathTo(v);
				Iterator<Integer> iterator = iterable.iterator();
				while (iterator.hasNext()) {
					StdOut.print(iterator.next());

					if (iterator.hasNext()) {
						StdOut.print("..");
					}
				}
				StdOut.println();
			}
		}
		StdOut.println();

		StdOut.println("BFS");
		StdOut.println("--------");
		BreadthFirstPaths bfp = new BreadthFirstPaths(graph, source);
		for (int v = 0; v < graph.V(); v++) {
			StdOut.print(v + ": ");
			if (bfp.hasPathTo(v)) {
				Iterable<Integer> iterable = bfp.pathTo(v);
				Iterator<Integer> iterator = iterable.iterator();
				while (iterator.hasNext()) {
					StdOut.print(iterator.next());

					if (iterator.hasNext()) {
						StdOut.print("..");
					}
				}
				StdOut.println();
			}
		}
		StdOut.println();
	}

}
