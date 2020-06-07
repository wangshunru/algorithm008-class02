class Solution {
    public void solve(char[][] board) {
    int rows = board.length;
    if (rows == 0) {
        return;
    }
    HashSet<String> memoization = new HashSet<>();
    int cols = board[0].length;
    for (int i = 0; i < cols; i++) {
        //最上边一行的所有 O 做 DFS
        if (board[0][i] == 'O') {
            dfs(0, i, board);
        }
        //最下边一行的所有 O 做 DFS
        if (board[board.length - 1][i] == 'O') {
            dfs(board.length - 1, i, board);
        }

    }
    for (int i = 1; i < rows - 1; i++) {
        //最左边一列的所有 O 做 DFS
        if (board[i][0] == 'O') {
            dfs(i, 0, board);
        }
        //最右边一列的所有 O 做 DFS
        if (board[i][board[0].length - 1] == 'O') {
            dfs(i, board[0].length - 1, board);
        }
    }
    //把所有没有标记过的 O 改为 X，标记过的还原
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (board[i][j] == '*') {
                board[i][j] = 'O';
            }else if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }
        }
    }
}

private void dfs(int i, int j, char[][] board) {
    if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
        return;
    }
    if (board[i][j] == '*') {
        return;
    }
    if (board[i][j] == 'O') {
        board[i][j] = '*';
        dfs(i + 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
        dfs(i - 1, j, board);
    }

}
}
