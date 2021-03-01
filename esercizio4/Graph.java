package esercizio4;

import java.util.*;

public class Graph<E> {

	// maps vertex to a map of <adjacent vertex, edge>
	protected HashMap<E, HashMap<E, Edge<E>>> vertices;
	private boolean oriented;
	private int _numEdges;

	public Graph(boolean oriented) {
		this.oriented = oriented;
		_numEdges = 0;
		vertices = new HashMap<>();
	}

	public boolean isOriented() { //
		return oriented;
	}

	public int numEdges() { //
		return _numEdges;
	}

	public int numVertices() { //
		return vertices.size();
	}

  public Edge<E> getEdge(E start, E end) { //
		HashMap<E, Edge<E>> adjacents = vertices.get(start);
		if (adjacents != null)
			return adjacents.get(end);
		else
			return null;
  }

	public boolean hasEdge(E start, E end) {
		return getEdge(start, end) != null;
	}

	public boolean hasVertex(E elem) {
		return vertices.containsKey(elem);
	}

	public void addVertex(E elem) {
		if (!vertices.containsKey(elem)) {
			vertices.put(elem, new HashMap<E, Edge<E>>());
		}
  }

  public void setEdge(E start, E end, double weight) {
		addVertex(start);
		addVertex(end);
		boolean added = setSingleEdge(start, end, weight);
		if (!oriented)
			setSingleEdge(end, start, weight);
		if (added) _numEdges++;
  }

	// return true if a new edge was added, false if the edge existed and changed weight
	private boolean setSingleEdge(E start, E end, double weight) {
		HashMap<E, Edge<E>> adjacents = vertices.get(start);
		Edge<E> edge = adjacents.get(end);
		// edge exists
		if (edge != null) {
			edge.setWeight(weight);
			return false;
		}
		// not exists
		else {
			edge = new Edge<E>(start, end, weight);
			adjacents.put(end, edge);
			return true;
		}
	}
	

	public String toString() {
		String s = "";
		Collection<HashMap<E, Edge<E>>> vertices = this.vertices.values();
		Iterator<HashMap<E, Edge<E>>> i = vertices.iterator();
		while (i.hasNext()) {
			Iterator<Edge<E>> edges = i.next().values().iterator();
			while (edges.hasNext()) {
				s += edges.next().toString() + "\n";
			}
		}
		return s;
	}
}
