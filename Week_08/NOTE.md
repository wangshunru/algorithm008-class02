不同路径II
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1)
            return 0;
        if (obstacleGrid[0].length < 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        //边界处理，注意如果遇到了障碍，后面的点的路径数就都为0，要break
        for (int i=0; i<m; i++){
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        //边界处理，注意如果遇到了障碍，后面的点的路径数就都为0，要break
        for (int i=0; i<n; i++){
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 1)  continue; //如果这个点是障碍，则跳过，dp[i][j] = 0
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
}
