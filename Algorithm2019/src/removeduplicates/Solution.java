package removeduplicates;

public class Solution {
	public static int removeDuplicates(int[] nums) {
		int result = 0;
		int index = 0;
		for (int n : nums) {
			if (index < 2 || n > nums[index - 2]) {
				result++;
				nums[index++] = n;

			}

		}

		return result;
	}

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(removeDuplicates(nums));
	}
}
