class MinimumTotal_120 {
    public static void main(String[] args) {

    }

    public int minimumTotal2(List<List<Integer>> triangle){
        int[] tmp = new int[triangle.size()+1];
        for (int i = triangle.size() - 1;i >= 0;i--){
            for (int j = 0; j < triangle.get(i).size();j++){
                tmp[j] = Math.min(tmp[j],tmp[j+1])+triangle.get(i).get(j);
            }
        }
        return tmp[0];
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        //定义两个变量 暂存dp[i - 1][j] 和 dp[i-1][j-1]
        int pre = 0,cur;
        for (int i = 1;i < triangle.size();i++){
            //对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0;j <= i;j++){
                cur = dp[j];
                if(j == 0){
                    dp[j] = cur + rows.get(j);
                }else if(j == i){
                    dp[j] = pre + rows.get(j);
                }else {
                    dp[j] = Math.min(cur,pre)+rows.get(j);
                }
                pre = cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res,dp[i]);
        }
        return res;
    }
}
