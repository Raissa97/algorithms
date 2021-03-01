package esercizio4;

public class ProvaGrafo {
	public static void main(String[] args) {
		Graph<String> g = new Graph<>(false);
		g.setEdge("a", "b", 1);
		g.setEdge("b", "c", 2);
		g.setEdge("c", "d", 4);
		g.setEdge("f", "a", 3);
		g.setEdge("a", "a", 1.5);
		System.out.println(g);
		System.out.println(g.numEdges() == 5);
		System.out.println(g.numVertices() == 5);
	}
}
