package graphs;

public class AdjacencyMatrix implements Graph{
    @Override
    public boolean adjacent(int vertexA, int vertexB) {
        return false;
    }

    @Override
    public int[] neighbors(int vertex) {
        return new int[0];
    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB, int weight) {

    }

    @Override
    public void removeEdge(int vertexA, int vertexB) {

    }

    @Override
    public int getEdgeWeight(int vertexA, int vertexB) {
        return 0;
    }

    @Override
    public void setEdgeWeight(int vertexA, int vertexB, int weight) {

    }
}
