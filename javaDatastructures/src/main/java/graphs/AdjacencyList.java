package graphs;

import java.util.*;

public class AdjacencyList implements Graph {

    List<List<AdjacencyListElement>> edges;
    Map<Integer, Integer> vertexes;

    public AdjacencyList() {
        this.edges = new ArrayList<>();
        this.vertexes = new HashMap<>();
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
    public void addVertex(Integer vertex, Integer value) {
        vertexes.put(vertex, value);
        edges.add(vertex, new ArrayList<>());
    }

    @Override
    public void removeVertex(Integer vertex) {
        vertexes.remove(vertex);
    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB, int weight) {
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
    public Integer getVertexValue(int vertex) {
        return vertexes.get(vertex);
    }

    @Override
    public void setVertexValue(int vertex, int newValue) {
        vertexes.put(vertex, newValue);
    }

    @Override
    public int getEdgeWeight(int vertexA, int vertexB) {
        return edges.get(vertexA)
                .stream()
                .filter(e -> e.to == vertexB)
                .findFirst()
                .get().weight;
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
