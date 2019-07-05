package removeduplicates;

public class Solution {
    public static int removeDuplicates(int[] nums) {
    	int count = 0;
    	for(int i =1;i<nums.length;i++){
    	if(nums[i]==nums[i-1])
    		count++;
    	nums[i-count]=nums[i];
    	}
    	return nums.length-count;
     }

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(removeDuplicates(nums));
	}
}
