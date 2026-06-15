class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], maxProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            if (n < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);
            maxProd = Math.max(currMax, maxProd);
        }

        return maxProd;
    }
}
