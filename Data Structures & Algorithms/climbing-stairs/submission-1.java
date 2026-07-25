class Solution {
    public int climbStairs(int n) {
       int a = 1;
       int b = 1;

       for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
       }

       return b;

    }
}
