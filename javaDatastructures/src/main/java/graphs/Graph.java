package graphs;

public interface Graph {
    boolean adjacent(int vertexA, int vertexB);
    int[] neighbors(int vertex);
    void addVertex(Integer vertex);
    void removeVertex(Integer vertex);
    void addEdge(Integer vertexA, Integer vertexB, int weight);
    void removeEdge(int vertexA,int vertexB);
    Integer getVertexValue(int vertex);
    void setVertexValue(int vertex, int newValue);
    int getEdgeWeight(int vertexA, int vertexB);
    int setEdgeWeight(int vertexA, int vertexB, int weight);
}
