package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencyList implements Graph{

    List<List<AdjacencyListElement>> edges;
    Set<Integer> vertex;

    public AdjacencyList(){
        this.edges = new ArrayList<>();
        this.vertex = new HashSet<>();
    }


    @Override
    public boolean adjacent(int vertexA, int vertexB) {
        return false;
    }

    @Override
    public int[] neighbors(int vertex) {
        return new int[0];
    }

    @Override
    public void addVertex(Integer vertex) {

    }

    @Override
    public void removeVertex(Integer vertex) {

    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB, int weight) {

    }

    @Override
    public void removeEdge(int vertexA, int vertexB) {

    }

    @Override
    public Integer getVertexValue(int vertex) {
        return 0;
    }

    @Override
    public void setVertexValue(int vertex, int newValue) {

    }

    @Override
    public int getEdgeWeight(int vertexA, int vertexB) {
        return 0;
    }

    @Override
    public int setEdgeWeight(int vertexA, int vertexB, int weight) {
        return 0;
    }
}

class AdjacencyListElement{
    int to;
    int weight;

    public AdjacencyListElement(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public AdjacencyListElement(int to) {
        this.to = to;
        this.weight = 1;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
