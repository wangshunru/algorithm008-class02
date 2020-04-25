public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,3,8,4,5,6};
        int[] ints = twoSum2(nums, 13);
        for (int i:ints) {
            System.out.print(i+"\n");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }
    //
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("not two sum solution");
    }
}
