package graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph{

    int[][] matrix;

    public AdjacencyMatrix(){
        this.matrix = new int[2][2];
    }

    @Override
    public boolean adjacent(int vertexA, int vertexB) {
        return matrix[vertexA][vertexB] != 0;
    }

    @Override
    public int[] neighbors(int vertex) {
        List<Integer> neighbours = new ArrayList<>();
        for (int i = 0; i < matrix[vertex].length; i++) {
            if (matrix[vertex][i] != 0){
               neighbours.add(i);
            }
        }

        return neighbours.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public void addEdge(Integer vertexA, Integer vertexB, int weight) {
        if (vertexA >= matrix.length || vertexB >= matrix.length){
            int size = matrix.length;
            int[][] newMatrix = new int[size*size][size*size];
            for (int i = 0; i < matrix.length; i++) {
                System.arraycopy(matrix[i],0,newMatrix[i],0,matrix[i].length);
            }
            matrix = newMatrix;
        }
        matrix[vertexA][vertexB] = weight;
    }

    @Override
    public void removeEdge(int vertexA, int vertexB) {
        matrix[vertexA][vertexB] = 0;
    }

    @Override
    public int getEdgeWeight(int vertexA, int vertexB) {
        return matrix[vertexA][vertexB];
    }

    @Override
    public void setEdgeWeight(int vertexA, int vertexB, int weight) {
        matrix[vertexA][vertexB] = weight;
    }
}
