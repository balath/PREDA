package algorithms.backtracking;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.Unique;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GivenSumSubSetTest {

    @Property(tries = 100)
    boolean every_solution_subset_has_required_size_and_given_sum(
            @ForAll @Size(value = 50) List<@IntRange(min = 1, max = 100) @Unique Integer> inputList,
            @ForAll @IntRange(min = 3, max = 150) int givenSum,
            @ForAll @IntRange(min = 2, max = 5) int subSetSize
            ) {
        List<List<Integer>> solutions = GivenSumSubSet.findSubSets(inputList,givenSum,subSetSize);
        return solutions
                .parallelStream()
                .allMatch(solution ->
                        solution.size() == subSetSize &&
                        solution.stream().reduce(0, Integer::sum) == givenSum
                );
    }

    @Test
    void findSubSets() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 23, 34, 45, 56, 67, 65, 64, 63, 60);
        List<Integer> sol1 = Arrays.asList(1, 3, 63);
        List<Integer> sol2 = Arrays.asList(1, 2, 7, 60);
        Assertions.assertTrue(GivenSumSubSet.findSubSets(inputList, 67, 3).contains(sol1));
        Assertions.assertTrue(GivenSumSubSet.findSubSets(inputList, 70, 4).contains(sol2));
    }


}