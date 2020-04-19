//26   删除排序数组中的重复项
public class RemoveDuplicates{
	public int removeDuplicates(int[] nums){
		int slow = 0;
		int fast = 0;
		while(fast < slow){
			if(nums[fast] == nums[slow]){
				fast++;
				continue;
			}
			slow ++;
			nums[slow] = nums[fast];
			fast++;
		}
		return slow+1;
	}
}
