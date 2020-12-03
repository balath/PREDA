package algorithms.backtracking;

import implementations.graphs.MatrixAdjacencyGraph;
import interfaces.IntGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithms.backtracking.GraphColoring.Colors.*;

class GraphColoringTest {

    IntGraph sampleIntGraph = new MatrixAdjacencyGraph(new int[][]{
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 1, 1},
            {1, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0}
    });
    GraphColoring.Colors[] solution = new GraphColoring.Colors[]{YELLOW, GREEN, RED, YELLOW, RED, YELLOW};

    GraphColoring.Colors[] wrongSolution = new GraphColoring.Colors[]{YELLOW, YELLOW, RED, YELLOW, RED, YELLOW};


    @Test
    void coloringRightSolution() {
        GraphColoring.coloring(sampleIntGraph, 3, 1, new int[6], false);
        Assertions.assertTrue(GraphColoring.getSolutions().stream().anyMatch(sol -> Arrays.equals(sol, solution)));
    }

    @Test
    void coloringWrongSolution() {
        GraphColoring.coloring(sampleIntGraph, 3, 1, new int[6], false);
        Assertions.assertFalse(GraphColoring.getSolutions().stream().anyMatch(sol -> Arrays.equals(sol, wrongSolution)));
    }
}