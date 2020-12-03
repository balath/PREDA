package interfaces;

import java.util.List;

/**
 * Define las operaciones básicas de un grafo según el apartado [2.3] del libro base (pg. 16).
 */
public interface IntGraph {

    /* Crea un grafo vacío. */
    IntGraph createEmptyGraph();

    /* Añade una arista entre los vértices u y v al grafo. */
    IntGraph addEdge(int vertex1, int vertex2, int weight);

    /* Añade un vértice v al grafo. */
    IntGraph addVertex(int vertex);

    /* Elimina la arista entre los vértices v1 y  2 del grafo */
    IntGraph deleteEdge(int vertex1, int vertex2);

    /* Elimina el vértice v del grafo */
    IntGraph deleteVertex(int vertex);

    /* Devuelve true si el grafo está vacío */
    boolean isEmpty();

    /* Devuelve el número total de vertices en el grafo */
    int totalVertices();

    /* Comprueba si los vértices son adyacentes */
    boolean isAdjacent(int vertex1, int vertex2);

    /* Devuelve una lista con los vértices adyacentes a v */
    List<Integer> getAdjacents(int vertex);

    /* Devuelve la etiqueta o peso asociado a la arista que une los vértices v1 y v2 */
    int getLabel(int vertex1, int vertex2);
}
