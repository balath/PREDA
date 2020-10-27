import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapsTest {

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
    void floatUpMaximal() {
        Heap heap = new BinaryMaximalHeap(new Integer[]{0, 6, 5, 4, 4, 1, 3, 2, 7});
        heap.floatUp(8);
        assert(heap.first() == 7);
    }

    @Test
    void floatUpMinimal() {
        Heap heap = new BinaryMinimalHeap(new Integer[]{0, 6, 5, 4, 4, 1, 3, 2, 7});
        heap.floatUp(7);
        assert(heap.first() == 2);
    }

    @Test
    void sinkMaximal() {
        Heap heap = new BinaryMaximalHeap(new Integer[]{0, 4, 6, 4, 5, 1, 3, 2});
        heap.sink(1);
        assert(heap.first() == 6);
    }

    @Test
    void sinkMinimal() {
        Heap heap = new BinaryMinimalHeap(new Integer[]{0, 6, 5, 4, 5, 1, 3, 2});
        heap.sink(1);
        assert(heap.first() == 4);
    }

    @Test
    void insertMaximal() {
        Heap heap = new BinaryMaximalHeap(8);
        List<Integer> vector = Arrays.asList(5, 4, 8, 10, 3, 2);
        vector.forEach(n -> heap.insert(n));
        assert(heap.first() == vector.stream().reduce(Math::max).get());
    }

    @Test
    void insertMinimal() {
        Heap heap = new BinaryMinimalHeap(8);
        List<Integer> vector = Arrays.asList(5, 4, 8, 2, 10, 3);
        vector.forEach(n -> heap.insert(n));
        assert(heap.first() == vector.stream().reduce(Math::min).get());
    }

    @Test
    void getTopMaximal() {
        Heap heap = new BinaryMaximalHeap(8);
        List<Integer> vector = Arrays.asList(5, 4, 8, 10, 3, 2);
        vector.forEach(n -> heap.insert(n));
        heap.getTop();
        assert(heap.first() == 8);
    }

    @Test
    void getTopMinimal() {
        Heap heap = new BinaryMinimalHeap(8);
        List<Integer> vector = Arrays.asList(5, 4, 8, 10, 3, 2);
        vector.forEach(n -> heap.insert(n));
        heap.getTop();
        assert(heap.first() == 3);
    }

    @Test
    void heapSortReverseOrder() {
        boolean ordered = true;
        Integer[] array = new Integer[]{0, 5, 87, 32, 34, 23, 1, 1, 2, 66, 33, 45, 21, 33};
        Integer[] sortedArray = BinaryMaximalHeap.heapSort(array);
        Arrays.sort(array, 1, array.length, Comparator.reverseOrder());
        assertArrayEquals(array, sortedArray);
    }

    @Test
    void heapSort() {
        boolean ordered = true;
        Integer[] array = new Integer[]{0, 5, 87, 32, 34, 23, 1, 1, 2, 66, 33, 45, 21, 33};
        Integer[] sortedArray = BinaryMinimalHeap.heapSort(array);
        Arrays.sort(array, 1, array.length);
        assertArrayEquals(array, sortedArray);
    }
}