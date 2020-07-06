股票买卖系列问题：
  状态转移⽅程
    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                  max( 选择 rest , 选择 sell )
       解释：今天我没有持有股票，有两种可能： 要么是我昨天就没有持有，
            然后今天选择 rest，所以我今天还是没有持有； 
            要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) 
                  max( 选择 rest , 选择 buy )
       解释：今天我持有着股票，有两种可能： 要么我昨天就持有着股票，
            然后今天选择 rest，所以我今天还持有着股票； 
            要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
   dp[-1][k][0] = 0 
       解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润是 0 。
   dp[-1][k][1] = -infinity 
       解释：还没开始的时候，是不可能持有股票的，⽤负⽆穷表⽰这种不可能。 
   dp[i][0][0] = 0 
       解释：因为 k 是从 1 开始的，所以 k = 0 意味着不允许交易，这时候利润是 0 。
   dp[i][0][1] = -infinity 
       解释：不允许交易的情况下，是不可能持有股票的，⽤负⽆穷表⽰这种不可能。
   总结：
       base case： dp[-1][k][0] = dp[i][0][0] = 0
                   dp[-1][k][1] = dp[i][0][1] = -infinity
       方程：dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) 
            dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    
   第一题 k=1 时
       int n = prices.length; 
       int[][] dp = new int[n][2]; 
       for (int i = 0; i < n; i++) { 
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); 
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]); 
       }
       return dp[n - 1][0];
      //优化
       for (int i = 0; i < n; i++) { 
            if (i - 1 == -1) { 
                dp[i][0] = 0; 
                dp[-1][0] - prices[i];
             }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); 
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]); 
        }
        return dp[n - 1][0];
        
       第二题 ：k = +infinity
       int maxProfit_k_inf(int[] prices) { 
           int n = prices.length; 
           int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE; 
           for (int i = 0; i < n; i++) { 
                int temp = dp_i_0; 
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]); 
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]); 
            }
            return dp_i_0; 
        }
        
        第三题 ：k = +infinity with cooldown
        int maxProfit_with_cool(int[] prices) { 
            int n = prices.length; 
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE; 
            int dp_pre_0 = 0;
            for (int i = 0; i < n; i++) { 
                int temp = dp_i_0; 
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]); 
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]); 
                dp_pre_0 = temp;
             }
             return dp_i_0;
         }
         
         第四题: k = +infinity with fee
         int maxProfit_with_fee(int[] prices, int fee) { 
               int n = prices.length; 
               int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE; 
               for (int i = 0; i < n; i++) { 
                    int temp = dp_i_0; dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]); 
                    dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee); 
                }
                return dp_i_0; 
          }
          
          
          第五题 ： k = 2
          dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]) 
          dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]) 
          dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]) 
          dp[i][1][1] = max(dp[i-1][1][1], -prices[i]) 
          int maxProfit_k_2(int[] prices) { 
              int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE; 
              int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE; 
              for (int price : prices) { 
                  dp_i20 = Math.max(dp_i20, dp_i21 + price); 
                  dp_i21 = Math.max(dp_i21, dp_i10 - price); 
                  dp_i10 = Math.max(dp_i10, dp_i11 + price); 
                  dp_i11 = Math.max(dp_i11, -price); 
               }return dp_i20; 
           }
           
           第六题 ： k = any integer
           int maxProfit_k_any(int max_k, int[] prices) { 
               int n = prices.length; 
               if (max_k > n / 2) return maxProfit_k_inf(prices); 
               int[][][] dp = new int[n][max_k + 1][2]; 
               for (int i = 0; i < n; i++) {
                   for (int k = max_k; k >= 1; k--) {
                       if (i - 1 == -1) { 
                           /* 处理 base case */ 
                        } 
                        dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i ]); 
                        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices [i]); 
                    } 
                   return dp[n - 1][max_k][0]; 
             }
             
  总结：关键在于列举出所有可能的「状态」，然后想想怎么穷举更新这些「状 态」。
       ⼀般⽤⼀个多维 dp 数组储存这些状态，从 base case 开始向后推进， 推进到最后的状态。
           
         
打家劫舍系列问题
