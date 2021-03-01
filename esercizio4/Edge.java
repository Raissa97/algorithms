package esercizio4;
/**
* @author Paganone
*/
import java.util.*;

class Edge<E> {
  E start;
  E end;
  double weight;

  public Edge(E start, E end, double weight) {
    this.start = start;
    this.end = end;
	  this.weight = weight;
  }

  public void setWeight(double w) {
    weight = w;
  }

  public double getWeight() {
    return weight;
  }

  public E getStart() {
    return start;
  }

  public E getEnd() {
    return end;
  }

  public String toString() {
    return "(" + start.toString() + ", " + end.toString() + ", " + weight + ")";
  }

}
