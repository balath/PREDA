package algorithms.divideAndConquer;

public class Quicksort {

    public static void sort(int[] input){
        if (input.length != 0) quicksort(input, 0, input.length - 1);
    }

    private static void quicksort(int[] input, int lo, int hi) {
        int p;
        if (lo < hi) {
            p = partition(input, lo , hi);
            quicksort(input, lo, p - 1);
            quicksort(input, p + 1, hi);
        }
    }

    private static int partition(int[] T, int i, int j) {
        int p = T[i];
        int k = i, l = j + 1;
        do k++; while (T[k] <= p && k < j);
        do l--; while(T[l] > p);
        while (k < l) {
            swap(T, k, l);
            do k++; while (T[k] <= p);
            do l--; while (T[l] > p);
        }
        swap(T, i, l);
        return l;
    }

    private static void swap(int[] input, int k, int l) {
        int swap = input[k];
        input[k] = input[l];
        input[l] = swap;
    }
}