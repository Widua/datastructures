package graphs;

import java.util.*;

public class AdjacencyList implements Graph {

    List<List<AdjacencyListElement>> edges;

    public AdjacencyList() {
        this.edges = new ArrayList<>();
    }

    @Override
    public boolean adjacent(int vertexA, int vertexB) {
        return edges.get(vertexA).stream()
                .anyMatch(e -> e.to == vertexB);
    }

    @Override
    public int[] neighbors(int vertex) {
        return edges.get(vertex)
                .stream()
                .mapToInt(e -> e.to).toArray()
                ;
    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB, int weight) {

        if (edges.size() <= vertexA){
            edges.add(vertexA,new ArrayList<>());
        }

        edges.get(vertexA)
                .add(
                        new AdjacencyListElement(
                                vertexB, weight
                        )
                );
    }

    @Override
    public void removeEdge(int vertexA, int vertexB) {
        List<AdjacencyListElement> updatedEdgelist = edges.get(vertexA)
                .stream()
                .filter(elem -> elem.to != vertexB).toList();
        edges.set(vertexA, updatedEdgelist);
    }

    @Override
    public int getEdgeWeight(int vertexA, int vertexB) {
        return edges.get(vertexA)
                .stream()
                .filter(e -> e.to == vertexB)
                .findFirst()
                .orElse(new AdjacencyListElement(-1,-1))
                .weight;
    }

    @Override
    public void setEdgeWeight(int vertexA, int vertexB, int weight) {
        edges.get(vertexA)
                .stream()
                .filter(e -> e.to == vertexB)
                .findFirst()
                .ifPresent(
                        e -> e.weight = weight
                );
    }
}

class AdjacencyListElement {
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
}
