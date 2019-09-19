
public class Solution {
	public static int minSubArrayLen(int s, int[] nums) {

		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int count = 0;
		while (end < nums.length) {
			count += nums[end];
			if (count >= s) {

				while (count >= s) {
					
					min = Math.min(min, end - start + 1);
					count -= nums[start];
					start++;

				}
			}
			end++;
		}

		return (min == Integer.MAX_VALUE) ? 0 : min;

	}

	public static int equalToSum(int[] nums, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += nums[i];
		}
		return sum;

	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int[] nums1 = { 2, 3, 1, 2, 8, 6 };
		int[] nums2 = { 1, 2, 3, 4, 5 };
		int[] nums3 = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };
		int[] nums4 = { 1, 4, 4 };
		int[] nums5 = { 10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8 };
		System.out.println(minSubArrayLen(80, nums5));
	}

}
