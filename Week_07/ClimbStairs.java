/*
1 1
2 2
3 3
推理 ： 每一级台阶n都是从其(n-1)或者（n-2） 爬一级/二级上来的
所以f(n) = f(n-1)+f(n-2)  斐波那契
*/
//用两个临时值 
class Solution {
    public int climbStairs(int n) { 
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        int thrid;
        for(int i = 3;i <= n;i++){
            thrid = first + second;
            first = second;
            second = thrid;
        }
        return second;
        
        /*double sqr = Math.sqrt(5);
        double v = Math.pow((1+sqr)/2,n+1) - Math.pow((1-sqr)/2,n+1);
        return (int)(v/sqr);*/
        /*if(n == 1) return 1;
        int first = 1;
        int second = 2;
        int thrid;
        for(int i = 3;i <= n;i++){
            thrid = first + second;
            first = second;
            second = thrid;
        }
        return second;*/
    }
}
