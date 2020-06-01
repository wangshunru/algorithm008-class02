class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int[] memo = new int[amount+1];
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0){
                    memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1);
                }
            }
        }

        return memo[amount] == (amount+1) ? -1 : memo[amount];
    }
}
