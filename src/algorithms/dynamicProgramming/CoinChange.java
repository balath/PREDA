package algorithms.dynamicProgramming;

public class CoinChange {

   static public void main(String[] args) {
      int[] coinsType = new int[]{1, 6, 10};
      int amount = 12;
      int[][] partialSolutionsTable = dynamicProgrammingAlgorithm(coinsType, amount);
      printTable(coinsType, amount, partialSolutionsTable);
   }

   /**
    * Algoritmo del problema de la devolución de cambio para cualquier tipo de monedas solucionado
    * con programación dinámica (página 135 - edición 2011)
    * @param coinsType Array con los valores de monedas disponibles ordenadas de menor a mayor
    * @param amount Cantidad a devolver con las monedas
    * @return Tabla de resultados parciales con la solución en la posición [coinsType.length - 1][amount]
    */
   static public int[][] dynamicProgrammingAlgorithm(int[] coinsType, int amount) {
      int[][] table = new int[coinsType.length][amount + 1];

      for (int row = 0; row < coinsType.length; row++) {
         table[row][0] = 0;
      }
      for (int column = 1; column <= amount ; column++) {
         for (int row = 0; row < coinsType.length; row++) {
            int currentCoinType = coinsType[row];
            if (row == 0 && currentCoinType > amount) {
               throw new IllegalArgumentException("Amount is smaller than lower coin value");
            }
            if (row == 0) {
               table[row][column] = table[row][column - currentCoinType] + 1;
               continue;
            }
            if (currentCoinType > column) {
               table[row][column] = table[row - 1][column];
            } else {
               table[row][column] = Math.min(table[row - 1][column], table[row][column - currentCoinType] + 1);
            }
         }
      }
      return table;
   }

   private static void printTable(int[] coinsType, int amount, int[][] table) {
      System.out.format("\nAmount     =     ");
      for (int j = 0; j <= amount; j++) System.out.format("%3d ", j);
      for (int i = 0; i < coinsType.length; i++) {
         System.out.format("\nCoin value = %3d ", coinsType[i]);
         for (int j = 0; j <= amount; j++) {
            System.out.format("%3d ", table[i][j]);
         }
      }
      System.out.format("\n\nSolution = %d coin types.\n\n", table[coinsType.length - 1][amount]);
   }
}

