package algorithms.dynamicProgramming;

public class Fibonacci {

   static public int recursiveAlgorithm(int n) {
      if (n <= 1) return 1;
      else return recursiveAlgorithm(n - 1) + recursiveAlgorithm(n - 2);
   }

   static public int dynamicProgrammingAlgorithm(int n) {
      if (n <= 1) return 1;

      int[] table = new int[n + 1];
      table[0] = 1;
      table[1] = 1;
      for (int i = 2; i <= n; i++) {
         table[i] = table[i - 1] + table[i - 2];
      }
      return table[n];
   }

}
