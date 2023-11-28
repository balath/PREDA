package algorithms.backtracking;

import interfaces.IntGraph;

import java.util.Arrays;
import java.util.HashSet;

public class GraphColoring {

    public enum Colors{YELLOW, GREEN, RED, BLUE, VIOLET, BLACK, ORANGE, PINK, PURPLE, BROWN}

    static HashSet<Colors[]> solutions = new HashSet<>();

    public static void coloring(IntGraph intGraph, int colors, int currentVertex, int[] v, boolean success) {
        v[currentVertex - 1] = 0;
        success = false;
        while (v[currentVertex - 1] < colors && !success) {
            if (completenessly(intGraph, v, currentVertex)) {
                if (currentVertex == intGraph.totalVertices()) {
                    process(v);
                    success = true;
                } else {
                    coloring(intGraph, colors, currentVertex + 1, v, success);
                }
            }
            v[currentVertex - 1]++;
        }
        String s = "ese";
        for (char c: s.toCharArray()) {

        }
    }

    private static void process(int[] v) {
        Colors[] colors = Colors.values();
        solutions.add(Arrays.stream(v).mapToObj(color -> colors[color]).toArray(Colors[]::new));
    }

    private static boolean completenessly(IntGraph intGraph, int[] v, int currentVertex) {
        for (int i = 1; i < currentVertex; i++) {
            if (intGraph.isAdjacent(currentVertex, i) && v[currentVertex - 1] == v[i - 1 ]) return false;
        }
        return true;
    }

    public static HashSet<Colors[]> getSolutions() {
        return solutions;
    }
}
