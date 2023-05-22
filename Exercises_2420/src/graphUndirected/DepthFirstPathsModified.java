package graphUndirected;

import java.util.Iterator;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * The {@code DepthFirstPaths} class represents a data type for finding paths
 * from a source vertex <em>s</em> to every other vertex in an undirected graph.
 * <p>
 * This implementation uses depth-first search. The constructor takes
 * &Theta;(<em>V</em> + <em>E</em>) time in the worst case, where <em>V</em> is
 * the number of vertices and <em>E</em> is the number of edges. Each instance
 * method takes &Theta;(1) time. It uses &Theta;(<em>V</em>) extra space (not
 * including the graph).
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class DepthFirstPathsModified {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s; // source vertex

	/**
	 * Computes a path between {@code s} and every other vertex in graph {@code G}.
	 * 
	 * @param G the graph
	 * @param s the source vertex
	 * @throws IllegalArgumentException unless {@code 0 <= s < V}
	 */
	public DepthFirstPathsModified(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		validateVertex(s);
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	/**
	 * Is there a path between the source vertex {@code s} and vertex {@code v}?
	 * 
	 * @param v the vertex
	 * @return {@code true} if there is a path, {@code false} otherwise
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}

	/**
	 * Returns a path between the source vertex {@code s} and vertex {@code v}, or
	 * {@code null} if no such path.
	 * 
	 * @param v the vertex
	 * @return the sequence of vertices on a path between the source vertex
	 *         {@code s} and vertex {@code v}, as an Iterable
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	/**
	 * Unit tests the {@code DepthFirstPaths} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		String fileName = "src/graphUndirected/resources/TinyUndirectedGraph.txt";
		In in = new In(fileName); // (args[0])
		Graph G = new Graph(in);
		int s = Integer.parseInt("2"); // "args[1]" - source vertex
		DepthFirstPathsModified dfs = new DepthFirstPathsModified(G, s);

		StdOut.println("Adjacency List");
		StdOut.println("----------------");
		for (int v = 0; v < G.V(); v++) {
			StdOut.print(v + ": ");
			Iterable<Integer> iterable = G.adj(v);
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

		System.out.format("%-6s | %-6s | %-6s", "", "marked", "edgeTo");
		StdOut.println();
		System.out.format("%-6s | %-6s | %-6s", "", "------", "------");
		StdOut.println();
		for (int v = 0; v < G.V(); v++) {
			System.out.format("%-6s | %-6b | %-6s", v, dfs.marked[v], dfs.edgeTo[v]);
			StdOut.println();
		}
		StdOut.println();

		StdOut.println("Original Output:");
		StdOut.println("----------------");
		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for (int x : dfs.pathTo(v)) {
					if (x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
				}
				StdOut.println();
			}

			else {
				StdOut.printf("%d to %d:  not connected\n", s, v);
			}

		}
	}

}
