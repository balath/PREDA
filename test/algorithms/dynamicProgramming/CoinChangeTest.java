package algorithms.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

   @Test
   void dynamicProgrammingAlgorithm() {
      int[] coinsType = new int[]{1, 6, 10};
      int amount12 = 12, amount24 = 24;
      int [][] solutionAmount24 = CoinChange.dynamicProgrammingAlgorithm(coinsType, amount24);
      int [][] solutionAmount12 = CoinChange.dynamicProgrammingAlgorithm(coinsType, amount12);
      assertEquals(solutionAmount24[coinsType.length - 1][amount24], 4);
      assertEquals(solutionAmount24[coinsType.length - 1][amount12], 2);
   }
}