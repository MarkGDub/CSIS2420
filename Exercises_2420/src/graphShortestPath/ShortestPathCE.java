package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;

public class ShortestPathCE {
	public static void main(String[] args) {
		String fileName = "src/graphShortestPath/resources/airports.txt";
		EdgeWeightedSymbolDigraph sg = new EdgeWeightedSymbolDigraph(fileName, " ");
		int source = sg.indexOf("Start");
		DijkstraSP dijkstra = new DijkstraSP(sg.digraph(), source);
		int target = sg.indexOf("End");

		System.out.println("Shortest path from Start to End:");
		System.out.println("--------------------------------");
		if (dijkstra.hasPathTo(target)) {
			for (DirectedEdge e : dijkstra.pathTo(target)) {
				int v = e.from();
				int w = e.to();
				System.out.println(sg.nameOf(v) + " to " + sg.nameOf(w) + " (" + e.weight() + ")");
			}
			System.out.println();
			System.out.format("%s $%.2f %n", "Total price from Start to End:", dijkstra.distTo(target));
		} else {
			System.out.println(source + " does not have a path to " + target);
		}
	}
}
