package algorithms.dynamicProgramming;

import com.google.common.math.LongMath;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BinomialCoefficientsTest {

   @Property
   boolean proper_result_to_binomial_coefficient_of_n_and_k(
           @ForAll @IntRange(min = 0, max = 50) int n, @ForAll @IntRange(min = 0, max = 50) int k
   ) {
      if (k > n) {
         return assertThrows(IllegalArgumentException.class,
                 () -> {
                    long result = BinomialCoefficients.calculate(n, k);
                 }) instanceof Exception;
      }
      else {
         long result = BinomialCoefficients.calculate(n, k);
         long expected = LongMath.binomial(n, k);
         return result == expected;
      }
   }
}