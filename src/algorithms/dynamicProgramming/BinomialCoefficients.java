package algorithms.dynamicProgramming;

import java.util.stream.IntStream;

public class BinomialCoefficients {

   static public void main(String[] args) {
      int n = 7, k = 4;
      long solution = calculate(n , k);
      //long solution = calculateBookVersion(n , k);
      //long solution = calculateStreamsVersion(n , k);
      System.out.format("\n(%3d)\n(%3d) = %d\n", n, k, solution);
   }

   /**
    * Algoritmo del problema de los coeficientes binomiales solucionado con programación dinámica
    * (basado en el vídeo F. Ostenero, no calcula el triángulo de Pascal completo, sólo los términos necesarios).
    * @param n Término superior del coeficiente
    * @param k Término inferior del coeficiente
    * @return Solución del coeficiente
    */
   static public long calculate(int n, int k) {
      if (k > n) throw new IllegalArgumentException("Operand 'k' can't be greater than 'n'");
      if (k == 0 || n == k) return 1; //Trivial cases

      long[][] table = new long[k + 1][n + 1];
      //Fill row 0 -> k = 0
      for (int column = 0; column <= n - k; column++) table[0][column] = 1;
      //Fill main diagonal -> n == k
      for (int diagonal = 1; diagonal <= k; diagonal++) table[diagonal][diagonal] = 1;
      //Fill only necessary cells until [n][k] cell (inclusive)
      for (int column = 2; column <= n; column++) {
         for (int row = 1; (row < column && row <= k); row++) {
            table[row][column] = table[row][column-1] + table[row-1][column-1];
         }
      }
      return table[k][n];
   }

   /**
    * Algoritmo del problema de los coeficientes binomiales solucionado con programación dinámica
    * (página 132 - edición 2011).
    * @pre n >= k
    * @param n Término superior del coeficiente
    * @param k Término inferior del coeficiente
    * @return Solución del coeficiente
    */
   static public long calculateBookVersion(int n, int k) {
      long[][] table = new long[n + 1][k + 1];
      if (k <= 0 || n == k) return 1; //Trivial cases
      for (int row = 0; row <= n; row++) table[row][0] = 1;
      for (int row = 1; row <= k; row++) table[row][1] = row;
      for (int row = 2; row <= k; row++) table[row][row] = 1;
      for (int row = 3; row <= n; row++) {
         for (int column = 2; column <= row - 1; column++) {
            if (column <= k) {
               table[row][column] = table[row - 1][column - 1] + table[row - 1][column];
            }
         }
      }
      return table[n][k];
   }

   /* Filling table with IntStreams.foreach instead of classic for version. */
   static public long calculateStreamsVersion(int n, int k) {
      if (k > n) throw new IllegalArgumentException("Operand 'k' can't be greater than 'n'");
      if (k == 0 || n == k) return 1; //Trivial case

      long[][] table = new long[k + 1][n + 1];
      IntStream.rangeClosed(0, n - k).forEach(index -> table[0][index] = 1);
      IntStream.rangeClosed(0, k).forEach(index -> table[index][index] = 1);
      IntStream.rangeClosed(0, n).forEach(column ->
              IntStream.rangeClosed(1, Math.min(column - 1, k)).forEach(row ->
                      table[row][column] = table[row][column-1] + table[row-1][column-1]
              )
      );
      return table[k][n];
   }

}
