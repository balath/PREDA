package implementations.graphs;

import interfaces.IntGraph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixAdjacencyGraph implements IntGraph {

    private int[][] matrix;

    public MatrixAdjacencyGraph(int initialVertices){
        matrix = new int[initialVertices][initialVertices];
    }

    public MatrixAdjacencyGraph(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public IntGraph createEmptyGraph() {
        return null;
    }

    @Override
    public IntGraph addEdge(int vertex1, int vertex2, int weight) {
        matrix[vertex1 - 1][vertex2 - 1] = weight;
        return this;
    }

    @Override
    public IntGraph addVertex(int vertex) {
        int[][] newMatrix = new int[matrix.length + 1][matrix.length + 1];
        int r = 0, c = 0;
        for(int[] row: matrix) {
            for (int cell: row) {
                newMatrix[r][c] = cell;
                c++;
            }
            r++;
        }
        matrix = newMatrix;
        return this;
    }

    @Override
    public IntGraph deleteEdge(int vertex1, int vertex2) {
        matrix[vertex1 - 1][vertex2 - 1] = 0;
        return this;
    }

    @Override
    public IntGraph deleteVertex(int vertex) {
        int[][] newMatrix = new int[matrix.length -1][matrix.length - 1];
        int r = 0, c = 0;
        for(int[] row: matrix) {
            if (r == vertex - 1) continue;
            for (int cell: row) {
                if (c == vertex - 1) continue;
                newMatrix[r][c] = cell;
                c++;
            }
            r++;
        }
        matrix = newMatrix;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return matrix.length == 0;
    }

    @Override
    public int totalVertices() {
        return matrix.length;
    }

    @Override
    public boolean isAdjacent(int vertex1, int vertex2) {
        return matrix[vertex1 - 1][vertex2 - 1] > 0;
    }

    @Override
    public List<Integer> getAdjacents(int vertex) {
        return Arrays.stream(matrix[vertex - 1]).boxed().collect(Collectors.toList());
    }

    @Override
    public int getLabel(int vertex1, int vertex2) {
        return matrix[vertex1 - 1][vertex2 - 1];
    }
}
