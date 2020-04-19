public class TwoSum{
	public int[] twoSum(int[] nums,int target){
		int[] res = new int[2];
		int j = nums.length-1;
		for(int i = 0;i < nums.length;i++){
			if(nums[i] + nums[j] == target){
				res[0] = i;
				res[1] = j;
			}
			j--;
		}
		return res;
	}
}
