class Solution {
    private List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        _generate(0,0,n,"");
        return res;
    }

    private void _generate(int left,int right,int n,String s){
        //结束条件
        if (left == n && right == n){
            res.add(s);
            return;
        }
        if (left < n){
            _generate(left+1, right, n, s+"(");
        }
        //右括号一定在左括号之后生成  并且数量小于等于左括号
        if (right < left){
            _generate(left, right+1, n, s+")");
        }
    }
}
//左括号数量一定 <= n
//右括号一定在左括号之后出现
