package searchinsertpos;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
  		int high = nums.length - 1;
  		while (high >= low) {
  			int mid = (high - low) / 2 + low;
  			if (target == nums[mid]) {
  				return mid;
  			} else if (nums[mid] > target) {
  				high = mid - 1;
  			} else {
  				low = mid + 1;
  			}
  		}

  		return low;
      }
}
