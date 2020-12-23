package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GivenSumSubSet{

    static List<Integer> inputList;
    static List<List<Integer>> solutionList;
    static int givenSum;
    static int subsetSize;

    public static List<List<Integer>> findSubSets(List<Integer> inputList, int givenSum, int subsetSize) {
        GivenSumSubSet.inputList = inputList;
        GivenSumSubSet.givenSum = givenSum;
        GivenSumSubSet.subsetSize = subsetSize;
        solutionList = new ArrayList<>();
        recSeek(0,new ArrayList<>(),0);
        return solutionList;
    }

    private static void recSeek(int index, List<Integer> takenNumbers, int partialSum) {
        if (partialSum == givenSum && takenNumbers.size() == subsetSize) {
            solutionList.add(takenNumbers);
            return;
        }
        if (index < inputList.size()) {
            recSeek(index + 1, new ArrayList<>(takenNumbers), partialSum);
            Integer currentNumber = inputList.get(index);
            if (currentNumber + partialSum <= givenSum) {
                partialSum += currentNumber;
                takenNumbers.add(currentNumber);
                recSeek(index + 1, new ArrayList<>(takenNumbers), partialSum);
            }
        }
    }
}
