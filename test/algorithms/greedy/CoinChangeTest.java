package algorithms.greedy;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;

import java.util.Arrays;
import java.util.Random;



class CoinChangeTest {

   @Property
   boolean coinChange_solution_equals_required_amount(
           @ForAll("Generate coins type") int[] coinsType,
           @ForAll @Positive int amount
   ) {
      int[] solution = CoinChange.coinChange(coinsType,amount);
      for (int i = 0; i < coinsType.length; i++) solution[i]*=coinsType[i];
      return amount == Arrays.stream(solution).sum();
   }

   /* In this coin change problem version, the set of coin values must satisfy that    *
    * all values are consecutive powers of same base starting to the power of zero     */
   @Provide("Generate coins type")
   Arbitrary<int[]> coinsGenerated() {
      return Arbitraries.randomValue(random -> generatePowers(random));
   }

   private int[] generatePowers(Random random) {
      int[] candidate = new int[random.nextInt(10) + 1]; //At least one coin type.
      int base = random.nextInt(10) + 2; //At least base two
      for (int i = 0; i < candidate.length; i++) candidate[i] = (int) Math.pow(base, i);
      return candidate;
   }
}