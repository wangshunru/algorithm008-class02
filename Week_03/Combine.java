//组合77
class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k){
            return res;
        }
        findCombines(n,k,1,new Stack<Integer>());
        return res;
    }
    private void findCombines(int n, int k, int begin, Stack<Integer> s){
        if (s.size() == k){
            res.add(new ArrayList<Integer>(s));
            return;
        }
        /*for (int i = begin;i <= n;i++){
            s.add(i);
            findCombines(n,k,i+1,s);
            s.pop();
        }*/
        //优化
        for (int i = begin;i <= n-(k-s.size())+1;i++){
            s.push(i);
            findCombines(n,k,i+1,s);
            s.pop();
        }
    }
}
