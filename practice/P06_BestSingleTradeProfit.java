import java.util.Arrays;

/**
 * Week 11 Practice 6 - Best Single Trade Profit
 *
 * Single pass (track the lowest price so far): O(n) time, O(1) space.
 * Every pair of days: O(n^2) time. For years of daily prices (or tick data) n^2 explodes,
 * while one pass stays linear - so the single scan is the one to use at scale.
 */
public class P06_BestSingleTradeProfit {

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > best) best = price - minPrice;
        }
        return best;
    }

    public static void main(String[] args) {
        int[][] inputs = {{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}};
        for (int[] prices : inputs) {
            System.out.println("prices = " + Arrays.toString(prices) + " -> " + maxProfit(prices));
        }
    }
}
