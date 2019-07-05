package searchinrotatedsortedarray;

public class Solution {
    public int search(int[] nums, int target) {
				int minPos = 0;
		int maxPos = nums.length - 1;
		boolean found = false;
		int left = minPos;
		int right = maxPos;
		while (right >= left) {
			int mid = (right - left) / 2 + left;
			if (target == nums[mid])
				return mid;
			if (nums[minPos] > nums[maxPos]) {
				if (nums.length == 2) {
					minPos = nums.length - 1;
					maxPos = 0;
				}

		if (mid != nums.length - 1 && mid!=0&&nums.length > 2 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
					minPos = mid;
					maxPos = mid - 1;
					continue;
				}
                if (right - left <= 1) {
					maxPos = right - 1;
					minPos = right;
					continue;

				} 
				if (nums[mid] > nums[right])
					left = mid + 1;
				if (nums[mid] < nums[right])
					right = mid - 1;

			} else {

				if (found == false) {
					if (target >= nums[0] && target <= nums[maxPos]) {
						found = true;
						minPos = 0;
						left = minPos;
						right = maxPos;
					} else {
						found = true;
						maxPos = nums.length - 1;
						left = minPos;
						right = maxPos;

					}
				}
				mid = (right - left) / 2 + left;
				if (nums[mid] == target)
					return mid;
				if (target < nums[minPos] || target > nums[maxPos])
					return -1;

				if (nums[mid] > target)
					right = mid - 1;
				if (nums[mid] < target)
					left = mid + 1;

			}

		}
		return -1;
    }
}
