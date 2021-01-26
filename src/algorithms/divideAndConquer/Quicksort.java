package algorithms.divideAndConquer;

public class Quicksort {

    public static void sort(int[] input){
        if (input.length != 0) {
            //quicksortHoare(input, 0, input.length - 1);
            quicksortUnedStyle(input, 0, input.length - 1);
        }
    }

    /**
     * Algoritmo Quicksort de Hoare (https://en.wikipedia.org/wiki/Quicksort)
     */
    private static void quicksortHoare(int[] input, int lo, int hi) {
        int p;
        if (lo < hi) {
            p = partitionHoare(input, lo , hi);
            quicksortHoare(input, lo, p);
            quicksortHoare(input, p + 1, hi);
        }
    }
    private static int partitionHoare(int[] input, int lo, int hi) {
        int pivot = input[(hi + lo) / 2];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do i++; while (input[i] < pivot);
            do j--; while (input[j] > pivot);
            if (i >= j) return j;
            swap(input, i, j);
        }
    }


    /**
     * Algoritmo Quicksort del Libro base (ed. 2011)
     */
    private static void quicksortUnedStyle(int[] input, int leftIndex, int rightIndex) {
        int p;
        if (leftIndex < rightIndex) {
            p = partitionUnedStyle(input, leftIndex , rightIndex);
            quicksortUnedStyle(input, leftIndex, p - 1);
            quicksortUnedStyle(input, p + 1, rightIndex);
        }
    }
    private static int partitionUnedStyle(int[] vector, int leftIndex, int rightIndex) {
        int pivot = vector[leftIndex];
        int leftPos = leftIndex, rightPos = rightIndex + 1;
        do leftPos++; while (vector[leftPos] <= pivot && leftPos < rightIndex);
        do rightPos--; while(vector[rightPos] > pivot);
        while (leftPos < rightPos) {
            swap(vector, leftPos, rightPos);
            do leftPos++; while (vector[leftPos] <= pivot);
            do rightPos--; while (vector[rightPos] > pivot);
        }
        swap(vector, leftIndex, rightPos);
        return rightPos;
    }

    /* Método común que intercambia las posiciones i y j de un vector */
    private static void swap(int[] vector, int i, int j) {
        int swap = vector[i];
        vector[i] = vector[j];
        vector[j] = swap;
    }
}