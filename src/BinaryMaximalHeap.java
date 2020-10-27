/**
 * Implementa la interface Heap para el caso de un montículo binario de máximos.
 */
public class BinaryMaximalHeap implements Heap {

    protected Integer[] T;  //Vector de elementos
    protected int c;          //Contador de número de elementos
    protected int MAX;        //Tamaño máximo del montículo

    public BinaryMaximalHeap(int n) {
        T = new Integer[n + 1];
        c = 0;
        MAX = n;
    }

    BinaryMaximalHeap(Integer[] vector) {
        T = vector.clone();
        c = vector.length - 1;
        MAX = Integer.MAX_VALUE;
    }

    /**
     * Crea un montículo a partir de un vector con coste O(n log n)
     * @pre El vector de parámetro se usa con índices de 1 a n
     * @param vector Vector [1..n] cuyo elemento 0 es nulo y n == length - 1
     * @return Heap que cumple las propiedades del montículo binario
     */
    public static Heap createHeap(Integer[] vector){
        int n = vector.length - 1;
        Heap heap = new BinaryMaximalHeap(vector);//Este constructor inicializa c, MAX y T (desordenado)
        for(int i = 2; i < n; i++) {
            heap.floatUp(i);
        }
        return heap;
    }

    /**
     * Crea un montículo a partir de un vector con coste O(n)
     * @pre El vector de parámetro se usa con índices de 1 a n
     * @param vector Vector [1..n] cuyo elemento 0 es nulo y n == length - 1
     * @return Heap que cumple las propiedades del montículo binario
     */
    public static Heap createHeapLineal(Integer[] vector){
        int n = vector.length - 1;
        Heap heap = new BinaryMaximalHeap(vector);//Este constructor inicaliza c, MAX y T (desordenado)
        for(int i = n/2; i >= 1; i--) {
            heap.sink(i);
        }
        return heap;
    }

    @Override
    public Heap createEmptyHeap(int n) {
        return new BinaryMaximalHeap(n);
    }

    @Override
    public boolean isEmpty() {
        return c == 0;
    }

    @Override
    public void floatUp(int i) {
        int intercambio;
        while ((i > 1) && (T[i / 2] < T[i])) {
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
            if ((hijoDer <= c) && (T[hijoDer] > T[i])) i = hijoDer;
            if ((hijoIzq <= c) && (T[hijoIzq] > T[i])) i = hijoIzq;
            intercambio = T[i];
            T[i] = T[p];
            T[p] = intercambio;
        } while (p != i);
    }

    @Override
    public void insert(int element) {
        if (c == MAX)
            throw new ArrayIndexOutOfBoundsException("Filled Heap");
        else {
            c ++;
            T[c] = element;
            floatUp(c);            
        }
    }

    @Override
    public int first() {
        if (c == 0) throw new ArrayIndexOutOfBoundsException("Empty Heap");
        return T[1];
    }

    @Override
    public int getTop() {
        if (c == 0) throw new ArrayIndexOutOfBoundsException("Empty Heap");
        int cima = T[1];
        T[1] = T[c];
        c --;
        sink(1);
        return cima;
    }

    /**
     * Este algoritmo de ordenación HeapSort ordena de mayor a menor sobre arrays de enteros
     * con un coste global de O(n log n)
     * @param vector desordenado con índices [1..n] (La primera posición del array se ignorará)
     * @return vector ordenado
     */
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

    //TO-DO: Imprimir por pantalla el mónticulo centrado
    @Override
    public void print() {
        if (isEmpty()) return;
//        StringBuilder heap = new StringBuilder();
//        char[] spacesArray = new char[60];
//        Arrays.fill(spacesArray, ' ');
//        String spaces = spacesArray.toString();
        for (int i = 1; i <= c; i++) {
            double deep = (Math.log(i) / Math.log(2));
            if ((int)deep - deep == 0) System.out.println();
            System.out.print(T[i]+"  ");
        }
    }

    //TO-DO: Implementar método que comprueba la propiedad del montículo
    @Override
    public boolean isHeap() {
        return true;
    }
}
