class Solution {
    public int findCircleNum(int[][] M){
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0;i < M.length;i++){
            if (!visited[i]){
                count++;
                visited[i] = true;
                dfs(M,i,visited);
            }
        }
        return count;
    }
    private void dfs(int[][] M,int v,boolean[] visited){
        for (int j = 0;j < M.length;j++){
            if (!visited[j] && M[v][j] == 1){
                visited[j] = true;
                dfs(M,j,visited);
            }
        }
    }
}
