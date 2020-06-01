class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (Integer i:nums) {
            if (sum > 0){
                sum += i;
            }else{
                sum = i;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
