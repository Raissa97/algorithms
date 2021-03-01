package esercizio4;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Reading csv file...");
    Graph<String> g = readCsv("C:/Users/UTENTEHP/Desktop/datasets/italian_dist_graph.csv");
    System.out.println(
      "\nGraph stats\n" +
      "\n number of Vertices: " + g.numVertices() +
      "\n number of Edges: " + g.numEdges() +
      "\n\nMinimum spanning forest\n"
    );
    ArrayList<ArrayList<Edge<String>>> msf = Prim.msf(g);
    int edges = 0; double weight = 0; int vert=0;
    for (int i = 0; i < msf.size(); i++) {
      ArrayList<Edge<String>> mst = msf.get(i);
      edges += mst.size();
      weight += mstWeight(mst);
      printMstStats(msf.get(i));
    }vert=edges*2;
    System.out.println("\nForest:\nEdges: " + edges + "\nWeight: " + weight);
  }
  //per la precisione stampa--> Edges: 18.637 e Weight: 89.939.912,585572

  public static Graph<String> readCsv(String path) {
    try {
      Graph<String> graph = new Graph<String>(false);
      Scanner input = new Scanner(new File(path));
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] record = line.split(",");
        graph.setEdge(record[0],record[1], Double.parseDouble(record[2]));
      }
      return graph;
    }
    catch(IOException e) {
      throw new Error("File not found!\nPath: " + path);
    }
  }

  public static <E> double mstWeight(ArrayList<Edge<E>> mst) {
    double w = 0.0;
    Iterator<Edge<E>> i = mst.iterator();
    while (i.hasNext()) {
      w += i.next().getWeight();
    }
    return w;
  }

  public static <E> void printMstStats(ArrayList<Edge<E>> mst) {
    System.out.println(
      "\nMinimum spanning tree" +
      "\nEdges: " + mst.size() +
      "\nWeight: " + mstWeight(mst) 
    );
  }
}
