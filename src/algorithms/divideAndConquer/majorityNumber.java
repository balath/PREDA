package algorithms.divideAndConquer;

import java.util.Arrays;
import java.util.Optional;

public class majorityNumber {

    public static void main(String[] args){
        //System.out.print(getMajority(new int[]{-2 , -2}));
    }

    public static Optional<Integer> getMajority(int[] input) {
        if (input.length < 1) return Optional.empty();
        Optional<Integer> solution = divide(input, 0, input.length);
        //if (solution.isPresent()) System.out.format("\nMajority number is: %d\n", solution.get());
        //else System.out.println("Majority number does not exist");
        return solution;
    }

    private static Optional<Integer> divide(int[] input, int from, int to) {
        if (to - from == 1) return Optional.of(input[from]);
        int middle = (from + to) / 2;
        Optional<Integer> num1, num2;
        num1 = divide(input, from, middle);
        num2 = divide(input, middle, to);
        return combine(num1, num2, input);
    }

    private static Optional<Integer> combine(Optional<Integer> num1, Optional<Integer> num2, int[] input) {
        boolean bothPresent = num1.isPresent() && num2.isPresent();
        boolean onlyOnePresent = num1.isPresent() ^ num2.isPresent();
        if (onlyOnePresent) {
            if (num1.isPresent() && checkMajority(num1, input)) return num1;
            if (num2.isPresent() && checkMajority(num2, input)) return num2;
        }
        if (bothPresent) {
            if (checkMajority(num1, input)) return num1;
            if (checkMajority(num2, input)) return num2;
        }
        return Optional.empty();
    }

    private static boolean checkMajority(Optional<Integer> numToCheck, int[] input) {
        return Arrays.stream(input).filter(num -> num == numToCheck.get()).count() > (input.length / 2);
    }
}
