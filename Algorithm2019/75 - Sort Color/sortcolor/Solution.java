package sortcolor;

public class Solution {
	public static void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int cur = 0;
		while (cur <= right) {
			if (nums[cur] == 0) {
				nums[cur]= nums[left];
				nums[left] = 0;
				left++;
				
			} else if (nums[cur] == 2) {
				nums[cur]= nums[right];
				nums[right] = 2;
				right--;
				cur --;
			}
			cur++;
		}

	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 0, 2, 1, 0, 2, 1, 0 };
		sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}

}
