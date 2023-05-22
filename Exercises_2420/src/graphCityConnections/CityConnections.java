package graphCityConnections;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.PrimMST;

public class CityConnections {
	public static void main(String[] args) {
		String fileName = "src/graphCityConnections/resources/CityConnections.csv";
		EdgeWeightedSymbolGraph symbolGraph = new EdgeWeightedSymbolGraph(fileName, ",");
		EdgeWeightedGraph weightedGraph = symbolGraph.graph();

		PrimMST mst = new PrimMST(weightedGraph);

		for (Edge e : mst.edges()) {
			int v = e.either();
			String city1 = symbolGraph.nameOf(v);
			String city2 = symbolGraph.nameOf(e.other(v));
			System.out.format("%5s to %5s (%s) %n", city1, city2, e.weight());
		}

		System.out.print("Total length of the bike trail: " + mst.weight());
	}
}
