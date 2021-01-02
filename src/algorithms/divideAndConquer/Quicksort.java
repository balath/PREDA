package algorithms.divideAndConquer;

public class Quicksort {

    public static void sort(int[] input){
        if (input.length != 0) quicksortHoare(input, 0, input.length - 1);
    }

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

    private static void quicksortUnedStyle(int[] input, int lo, int hi) {
        int p;
        if (lo < hi) {
            p = partitionUnedStyle(input, lo , hi);
            quicksortUnedStyle(input, lo, p - 1);
            quicksortUnedStyle(input, p + 1, hi);
        }
    }

    private static int partitionUnedStyle(int[] T, int i, int j) {
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