package graphs;

public interface Graph {
    boolean adjacent(int vertexA, int vertexB);
    int[] neighbors(int vertex);
    void addEdge(Integer vertexA, Integer vertexB, int weight);
    void removeEdge(int vertexA,int vertexB);
    int getEdgeWeight(int vertexA, int vertexB);
    void setEdgeWeight(int vertexA, int vertexB, int weight);
}
