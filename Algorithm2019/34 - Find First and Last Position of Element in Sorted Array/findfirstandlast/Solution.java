package findfirstandlast;

public class Solution {
	  public int[] searchRange(int[] nums, int target) {
  		int[] result = { -1, -1 };
	int left = 0;
	int right = nums.length - 1;
	int low = 0;
	int high = 0;

	while (left <= right) {
		int mid = left + (right - left) / 2;

		if (target == nums[mid]) {
			low = mid;
			high = mid;
			result[0] = low;
			result[1] = high;
			while (low>0&&nums[low - 1] == nums[low]) {
				low -= 1;
				result[0] = low;

			}
			while (high<nums.length-1&&nums[high + 1] == nums[high]) {
				high += 1;
				result[1] = high;

			}
			return result;
		}

		if (target > nums[mid]) {
			left = mid + 1;

		}

		if (target < nums[mid]) {

			right = mid - 1;
		}
	}

	return result;
}
}
