package algorithms.dynamicProgramming;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

class FibonacciTest {

   @Property(tries= 50)
   boolean Fibonacci_algorithms_work_correctly(@ForAll @IntRange(min = 0, max = 100) int n) {
      int recursiveSolution = Fibonacci.recursiveAlgorithm(n);
      int dynamicSolution = Fibonacci.dynamicProgrammingAlgorithm(n);
      return recursiveSolution == dynamicSolution;
   }
}