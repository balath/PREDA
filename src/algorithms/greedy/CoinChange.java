package algorithms.greedy;

public class CoinChange {

    public static void main(String[] args) {
        coinChange(new int[]{1, 7, 49, 343, 2401, 16807}, 1);
    }

    /** Given a finite set of coin values that holds that all values are consecutive powers of the same base    *
     * (starting to the power of zero), and an amount, returns the minimal coins combination for this amount.   */
    public static int[] coinChange(int[] coinsType, int amount) {
        int amountLeft = amount;
        int currentCoinType = coinsType.length - 1;
        int[] solution = new int[coinsType.length];
        for (int i = 0; i < coinsType.length; i++) {
            solution[i] = 0;
        }
        while (amountLeft != 0 && currentCoinType >= 0) {
            solution[currentCoinType] = amountLeft / coinsType[currentCoinType];
            amountLeft = amountLeft % coinsType[currentCoinType];
            currentCoinType--;
        }
        return solution;
    }
}
