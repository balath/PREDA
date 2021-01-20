package algorithms.dynamicProgramming;

public class BinomialCoefficients {

   static public long calculate(int n, int k) {
      if (k > n) throw new IllegalArgumentException("Operand 'k' can't be greater than 'n'");
      if (k == 0 || n == k) return 1; //Trivial case

      long[][] array = new long[k + 1][n + 1];
      //Fill row 0 -> k = 0
      for (int column = 0; column <= n - k; column++) array[0][column] = 1;
      //Fill main diagonal -> n == k
      for (int diagonal = 1; diagonal <= k; diagonal++) array[diagonal][diagonal] = 1;
      //Fill only necessary cells until [n][k] cell (inclusive)
      for (int column = 2; column <= n; column++) {
         for (int row = 1; (row < column && row <= k); row++) {
            array[row][column] = array[row][column-1] + array[row-1][column-1];
         }
      }
      return array[k][n];
   }

}
