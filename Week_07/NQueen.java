class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n){
        if (n < 1){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        help(0,n,list);
        return res;
    }

    private void help(int row, int n, List<Integer> list) {
        if (row == n){
            List<String> strList = new ArrayList<String>();
            for (Integer num:list) {
                char[] t = new char[n];
                Arrays.fill(t,'.');
                t[num] = 'Q';
                strList.add(new String(t));
            }
            res.add(strList);
            return;
        }
        //每一列
        for (int col = 0;col < n;col++){
            if (!list.contains(col)){
                if (!isDiagonalAttack(list,col)){
                    list.add(col);
                    help(row+1, n, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
        int currRow = currentQueen.size();
        int currCol = i;
        for (int row = 0;row < currentQueen.size();row++){
            if (Math.abs(currRow-row) == Math.abs(currCol-currentQueen.get(row))){
                return true;
            }
        }
        return false;
    }
}
