//分发饼干
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        int s1 = 0;
        int g1 = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (g1 < g.length && s1 < s.length){
            if(g[g1] <= s[s1]){
                g1++;
            }
            s1++;
        }
        return g1;
    }
}
