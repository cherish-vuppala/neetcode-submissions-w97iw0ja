class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int[] minPrices = new int[prices.length];
        int[] maxPrices = new int[prices.length];

        minPrices[0] = prices[0];
        maxPrices[prices.length-1] = prices[prices.length-1];

        for (int i = 1, j = prices.length-2; i < prices.length; i++,j--) {
            minPrices[i] = Math.min(minPrices[i-1], prices[i]);
            maxPrices[j] = Math.max(maxPrices[j+1], prices[j]);
        }

        for (int i = 0; i < prices.length; i++) {
            int minPrice = minPrices[i], maxPrice = maxPrices[i];
            int profit = maxPrice - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
