package algorithms.divideAndConquer;

import java.util.Stack;
import java.util.stream.IntStream;

public class HanoiTowers {

   protected static class Stackie{
      private Stack<Integer> stack;
      private char letter;

      Stackie(Stack<Integer> stack, char letter) {
         this.stack = stack;
         this.letter = letter;
      }
   }

   //Set number of rings here
   private static final int RINGS = 6;

   private static Stackie
           A = new Stackie(new Stack<Integer>(), 'A'),
           B = new Stackie(new Stack<Integer>(), 'B'),
           C = new Stackie(new Stack<Integer>(), 'C');

   public static void main(String[] args) {
      IntStream.range(0, RINGS).map(n -> RINGS - n).forEach(n -> A.stack.push(n));
      printStacks();
      hanoiSolver(0, A, B, C, RINGS);
      printStacks();
   }

   private static void hanoiSolver(int call, Stackie from, Stackie to, Stackie other, int n) {
      if (n==0) return;
      hanoiSolver(1, from, other, to, n-1);
      to.stack.push(from.stack.pop());
      System.out.format("\tMove %c top to %c\n", from.letter, to.letter);
      hanoiSolver(2, other, to, from, n-1);
   }

   private static void printStacks() {
      System.out.println("-----------------------");
      System.out.print("Stack A: ");
      A.stack.forEach(n -> System.out.format("%d ",n));
      System.out.println();
      System.out.print("Stack B: ");
      B.stack.forEach(n -> System.out.format("%d ",n));
      System.out.println();
      System.out.print("Stack C: ");
      C.stack.forEach(n -> System.out.format("%d ",n));
      System.out.println();
      System.out.println("-----------------------");
   }


}
