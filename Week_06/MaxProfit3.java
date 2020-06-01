class Solution {
  
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            dp[0] = 0;
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[2], dp[4]));
    }
}
