package esercizio4;

import esercizio3.Heap;

import java.util.*;

public class Prim {

  public static <E> ArrayList<ArrayList<Edge<E>>> msf(Graph<E> g) {
    ArrayList<E> vertices = new ArrayList<>(g.vertices.keySet());
    ArrayList<ArrayList<Edge<E>>> msf = new ArrayList<>();
    while (vertices.size() > 0) {
      ArrayList<Edge<E>> path = mst(g, vertices.get(0));
      msf.add(path);
      for (Edge<E> e : path) {
        vertices.remove(e.start);
        vertices.remove(e.end);
      }
    }
    return msf;
  }

  public static <E> ArrayList<Edge<E>> mst(Graph<E> g, E source) {
    if (g.isOriented()) {
      throw new Error("Graph must be not oriented.");
    }
    int size = g.numVertices();
    HashMap<E, Edge<E>> pi = new HashMap<>(size);
    ArrayList<Edge<E>> mst = new ArrayList<Edge<E>>(size);
    Heap<Double,E> queue = new Heap<Double,E>(false /*min*/, size);
    for (E elem : g.vertices.keySet()) {
      queue.insert(Double.POSITIVE_INFINITY, elem);
    }
    queue.changeKey(source, 0.0);
    while (!queue.isEmpty() && queue.getFirstKey() != Double.POSITIVE_INFINITY) {
      Double key = queue.getFirstKey();
      E vertex = queue.extract();
      Edge<E> from = pi.get(vertex);
      if (from != null)
        mst.add(from);
      for (Edge<E> adj : g.vertices.get(vertex).values()) {
        E to = adj.end;
        if (queue.contains(to) && adj.getWeight() < queue.getKey(to)) {
          queue.changeKey(to, adj.getWeight());
          pi.put(to, adj);
        }
      }
    }
    return mst;
  }
}
