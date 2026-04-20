class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int minPrice = prices[i], maxPrice = prices[i];
            for (int j = i - 1; j >= 0 ; j--) {
                minPrice = Math.min(minPrice, prices[j]);
            }

            for (int j = i + 1; j < prices.length; j++) {
                maxPrice = Math.max(maxPrice, prices[j]);
            }

            int profit = maxPrice - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
