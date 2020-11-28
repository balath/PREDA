package algorithms.backtracking;

public class Queens {

    private static int totalSolutions;

    public static void main(String[] args){
        totalSolutions = 0;
        queens(8);
    }

    public static void queens(int n) {
        queens(new Integer[n+1], n, 1);
    }

    public static void queens(Integer[] sequence, int n, int level ){
        sequence[level] = 0;
        while (sequence[level] < n) {
            sequence[level]++;
            if (accept(sequence, level)) {
                if (level == n) {
                    totalSolutions++;
                    printChess(sequence);
                } else {
                    queens(sequence, n, level + 1);
                }
            }
        }
    }

    private static void printChess(Integer[] sequence) {
        System.out.println("Solution " + totalSolutions + ":");
        for (int i = 1; i < sequence.length; i++) {
            for (int j = 1; j < sequence.length; j++) {
                if (sequence[j] == i) System.out.print(" Q");
                else System.out.print(" X");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean accept(Integer[] sequence, int level) {
        for (int i = 1; i < level; i++) {
            if (
                    (sequence[i] == sequence[level]) ||
                    (Math.abs(sequence[i] - sequence[level]) == Math.abs(i - level))
            ) return false;
        }
        return true;
    }




}
