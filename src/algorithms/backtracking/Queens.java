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

    //Solves the n-queens problem with backtracking algorithm
    public static void queens(Integer[] solution, int n, int level ){
        solution[level] = 0;
        while (solution[level] < n) {
            solution[level]++;
            //Method accept(Integer[] solution, int level) checks queens are not kill themselves
            if (accept(solution, level)) {
                if (level == n) {
                    totalSolutions++;
                    //Method printChess(Integer[] solution) show the solution in chess table format
                    printChess(solution);
                } else {
                    queens(solution, n, level + 1);
                }
            }
        }
    }

    private static void printChess(Integer[] solution) {
        System.out.println("Solution " + totalSolutions + ":");
        for (int i = 1; i < solution.length; i++) {
            for (int j = 1; j < solution.length; j++) {
                if (solution[j] == i) System.out.print(" Q");
                else System.out.print(" X");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean accept(Integer[] solution, int level) {
        for (int i = 1; i < level; i++) {
            if (
                    solution[i].equals(solution[level]) ||
                    Math.abs(solution[i] - solution[level]) == Math.abs(i - level)
            ) return false;
        }
        return true;
    }
}
