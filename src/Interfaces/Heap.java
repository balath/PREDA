package Interfaces;

/**
 * Define las operaciones básicas de un montículo de máximos(mínimos) según el
 * apartado [2.2.1] del libro base (pg. 33).
 */
public interface Heap {

    /* Crea un montículo vacío */
    Heap createEmptyHeap(int n);

    /* Devuelve true si el montículo está vacío */
    boolean isEmpty();

    /* Reubica el elemento i-ésimo en caso de que sea mayor(menor) que el padre */
    void floatUp(int i);

    /* Reubica el elemento i-ésimo en caso de que sea menor(mayor) que el padre */
    void sink(int i);

    /* Inserta un elemento en el montículo y lo flota hasta restaurar la propiedad del montículo */
    void insert(int element);

    /* Devuelve la cima del montículo sin modificarlo */
    int first();

    /* Devuelve la cima del montículo, la elimina y recompone la propiedad del montículo */
    int getTop();

    default void print() {
        System.out.println(this.toString());
    }

    /* Comprueba que se cumple la propiedad del montículo en cuestión */
    boolean isHeap();
}
