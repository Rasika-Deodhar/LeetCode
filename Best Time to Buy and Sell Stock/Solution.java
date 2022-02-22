class Solution {
    public int maxProfit(int[] prices) {

        int buy_value = 0;
        int max_profit = 0;
        int min_val = Integer.MAX_VALUE;

        // Un-optimized solution
        // for (int i = 0; i < prices.length; i++) {
        // buy_value = prices[i];
        // for (int j = i + 1; j < prices.length; j++) {
        // if (prices[j] - prices[i] > max_profit) {
        // max_profit = prices[j] - prices[i];
        // }
        // }
        // }

        // Optimized (https://www.youtube.com/watch?v=eMSfBgbiEjk -> reference for idea)
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                min_val = prices[i];
            } else if (min_val > prices[i]) {
                min_val = prices[i];
            }
            if (max_profit < (prices[i] - min_val)) {
                max_profit = prices[i] - min_val;
            }
        }

        return max_profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(s.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }
}