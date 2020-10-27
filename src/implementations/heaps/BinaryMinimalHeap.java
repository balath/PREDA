package implementations.heaps;

import interfaces.Heap;

/**
 * Implementa la interface Interfaces.Heap para el caso de un montículo binario de mínimos, extendiendo del de máximos.
 */
public class BinaryMinimalHeap extends BinaryMaximalHeap implements Heap {

    public BinaryMinimalHeap(int n) {
        super(n);
    }

    public BinaryMinimalHeap(Integer[] vector) {
        super(vector);
    }

    /**
     * Crea un montículo a partir de un vector con coste O(n log n)
     * @pre El vector de parámetro se usa con índices de 1 a n
     * @param vector Vector [1..n] cuyo elemento 0 es nulo y n == length - 1
     * @return Interfaces.Heap que cumple las propiedades del montículo binario
     */
    public static Heap createHeap(Integer[] vector){
        int n = vector.length - 1;
        Heap heap = new BinaryMinimalHeap(vector);//Este constructor inicializa c, MAX y T (desordenado)
        for(int i = 2; i < n; i++) {
            heap.floatUp(i);
        }
        return heap;
    }

    /**
     * Crea un montículo a partir de un vector con coste O(n)
     * @pre El vector de parámetro se usa con índices de 1 a n
     * @param vector Vector [1..n] cuyo elemento 0 es nulo y n == length - 1
     * @return Interfaces.Heap que cumple las propiedades del montículo binario
     */
    public static Heap createHeapLineal(Integer[] vector){
        int n = vector.length - 1;
        Heap heap = new BinaryMinimalHeap(vector);//Este constructor inicaliza c, MAX y T (desordenado)
        for(int i = n/2; i >= 1; i--) {
            heap.sink(i);
        }
        return heap;
    }

    @Override
    public Heap createEmptyHeap(int n) {
        return new BinaryMinimalHeap(n);
    }

    @Override
    public void floatUp(int i) {
        int intercambio;
        while ((i > 1) && (T[i / 2] > T[i])) {
            intercambio = T[i];
            T[i] = T[i / 2];
            T[i / 2] = intercambio;
            i = i / 2;
        }
    }

    @Override
    public void sink(int i) {
        int hijoIzq, hijoDer, p, intercambio;
        do {
            hijoIzq = 2 * i;
            hijoDer = 2 * i + 1;
            p = i;
            if ((hijoDer <= c) && (T[hijoDer] < T[i])) i = hijoDer;
            if ((hijoIzq <= c) && (T[hijoIzq] < T[i])) i = hijoIzq;
            intercambio = T[i];
            T[i] = T[p];
            T[p] = intercambio;
        } while (p != i);
    }

    public static Integer[] heapSort(Integer[] vector){
        int e;
        Heap heap = createHeapLineal(vector);
        Integer[] sortedVector = new Integer[vector.length];
        sortedVector[0] = 0;
        for (int i = 1; i < vector.length; i++) {
            e = heap.getTop();
            sortedVector[i] = e;
        }
        return sortedVector;
    }

    //TO-DO: Implementar método que comprueba la propiedad del montículo
    @Override
    public boolean isHeap() {
        return true;
    }
}
