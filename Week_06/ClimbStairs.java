class ClimbStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(gs(6 ));
    }
    public static int climbStairs(int n){
        if (n == 1) return  1;
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3;i <= n;i++){
            third = first + second;
            first = second;
            second = third;
        }
        return  second;
    }
    //斐波那契公式
    public static int gs(int n){
        double sqrt = Math.sqrt(5);
        double v = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return  (int) (v/sqrt);
    }
}
