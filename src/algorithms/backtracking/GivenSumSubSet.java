package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GivenSumSubSet{

    static List<Integer> inputList;
    static List<List<Integer>> solutionList;

    public static List<List<Integer>> findSubSets(List<Integer> numberList, int givenSum, int subSetSize) {
        inputList = numberList;
        solutionList = new ArrayList<>();
        recSeek(0,new ArrayList<>(),0,givenSum, subSetSize);
        return solutionList;
    }

    private static void recSeek(int index, List<Integer> takenNumbers, int partialSum, int givenSum, int subSetSize) {
        if (partialSum == givenSum && takenNumbers.size() == subSetSize) {
            addSolution(takenNumbers);
            return;
        }
        if (index < inputList.size()) {
            recSeek(index + 1, new ArrayList<>(takenNumbers), partialSum, givenSum, subSetSize);
            Integer currentNumber = inputList.get(index);
            if (currentNumber + partialSum <= givenSum) {
                partialSum += currentNumber;
                takenNumbers.add(currentNumber);
                recSeek(index + 1, new ArrayList<>(takenNumbers), partialSum, givenSum, subSetSize);
            }
        }
    }

    private static void addSolution(List<Integer> takenNumbers) {
        solutionList.add(takenNumbers);
    }
}
