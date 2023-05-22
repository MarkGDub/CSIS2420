package graphInternet;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Prints dorms needing routers and dorms needing fiber connections
 * 
 * @author mark gowarty-weinstock
 *
 */
public class InternetCE {
	public static void main(String[] args) {
		String fileName = "src/graphInternet/resources/GraphInternet.txt";
		EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(fileName));
		KruskalMST mst = new KruskalMST(graph);

		int ROUTER_VERTEX = 8;

		StdOut.print("Dorms needing a connection: ");
		for (Edge e : mst.edges()) {
			int v = e.either();
			int w = e.other(v);
			if (v != ROUTER_VERTEX && w != ROUTER_VERTEX) {
				StdOut.print(v + "-" + w + " ");
			}
		}
		StdOut.println();

		StdOut.print("Dorms needing a router: ");
		for (Edge e : mst.edges()) {
			int v = e.either(); // 6
			int w = e.other(v); // 8
			if (w == ROUTER_VERTEX) {
				StdOut.print(v + " ");
			}
		}
		StdOut.println();

		StdOut.printf("Total Cost: $%.2f", mst.weight());
	}
}
