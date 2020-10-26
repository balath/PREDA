import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BinaryMaximalHeapTest {

    private static Heap emptyHeap = new BinaryMaximalHeap(8);

    @Test
    void createEmptyHeap() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> emptyHeap.first());
    }

    @Test
    void isEmpty() {
        assert(emptyHeap.isEmpty());
    }

    @Test
    void floatUp() {
        Heap heap = new BinaryMaximalHeap(new int[]{0, 6, 5, 4, 4, 1, 3, 2, 7});
        heap.floatUp(8);
        assert(heap.first() == 7);
    }

    @Test
    void sink() {
        Heap heap = new BinaryMaximalHeap(new int[]{0, 4, 6, 4, 5, 1, 3, 2});
        heap.print();
        heap.sink(1);
        assert(heap.first() == 6);
    }

    @Test
    void insert() {
        Heap heap = new BinaryMaximalHeap(8);
        List<Integer> vector = Arrays.asList(new Integer[]{5, 4, 8, 10, 3, 2});
        vector.forEach(n -> heap.insert(n));
        assert(heap.first() == vector.stream().reduce(Math::max).get());
    }

    @Test
    void getTop() {
        Heap heap = new BinaryMaximalHeap(8);
        List<Integer> vector = Arrays.asList(new Integer[]{5, 4, 8, 10, 3, 2});
        vector.forEach(n -> heap.insert(n));
        heap.getTop();
        assert(heap.first() == 8);
    }

    @Test
    void heapSort() {
        boolean ordered = true;
        int[] array = new int[]{0, 5, 87, 32, 34, 23, 1, 1, 2, 66, 33, 45, 21, 33};
        int[] sortedArray = BinaryMaximalHeap.heapSort(array);
        for (int i = 1; i < array.length - 2; i++) {
            if (sortedArray[i] < sortedArray[i+1]) ordered = false;
        }
        assert(ordered);
    }
}