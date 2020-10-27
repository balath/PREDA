package Interfaces;

import java.util.List;

/**
 * Define las operaciones básicas de un grafo según el apartado [2.3] del libro base (pg. 16).
 */
public interface Graph {

    public class Vertex{
        String label;
    }

    public class Edge{
        public enum EdgeType{DIRECTED, UNDIRECTED}

        EdgeType type;
        Vertex v1;
        Vertex v2;
        double weight;
        String label;
    }

    /* Crea un grafo vacío */
    Graph createEmptyGraph();

    /* Añade una arista entre los vértices u y v al grafo g */
    Graph addEdge(Vertex u, Vertex v, String label, Graph g);

    /* Añade un vértice v al grafo g */
    Graph addVertex(Vertex v, Graph g);

    /* Elimina la arista entre los vértices v1 y  2 del grafo g */
    Graph deleteEdge(Vertex v1, Vertex v2, Graph g);

    /* Elimina el vértice v del grafo g */
    Graph deleteVertex(Vertex v, Graph g);

    /* Devuelve true si el montículo está vacío */
    boolean isEmpty(Graph g);

    /* Comprueba si los vértices son adyacentes */
    boolean isAdjacent(Vertex v1, Vertex v2, Graph g);

    /* Devuelve una lista con los vértices adyacentes a v */
    List<Vertex> getAdjacents(Vertex v, Graph g);

    /* Devuelve la etiqueta o peso asociado a la arista que une los vértices v1 y v2 */
    String getLabel(Vertex v1, Vertex v2, Graph g);
}
