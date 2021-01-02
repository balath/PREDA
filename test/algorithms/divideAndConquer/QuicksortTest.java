package algorithms.divideAndConquer;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

class QuicksortTest {

    @Property
    boolean every_output_must_be_sorted(
            @ForAll  int[] input
    ) {
        Quicksort.sort(input);
        for (int i = 0; i < input.length - 1; i++) if (input[i] > input[i + 1]) return false;
        return true;
    }
}