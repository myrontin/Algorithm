package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		return backTracking(result, new ArrayList<>(), nums);
	}

	public static List<List<Integer>> backTracking(List<List<Integer>> result, List<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			result.add(new ArrayList<>(tmp));
		}
		for (int i = 0; i < nums.length; i++) {
			if (tmp.contains(nums[i]))
				continue;
			else {
				tmp.add(nums[i]);
				backTracking(result, tmp, nums);
				tmp.remove(tmp.size() - 1);
			}
		}

		return result;
	}

	public static List<List<Integer>> permuteWithDuplicated(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		return backTrackingDuplicated(result, new ArrayList<>(), nums, new boolean[nums.length]);
	}

	public static List<List<Integer>> backTrackingDuplicated(List<List<Integer>> result, List<Integer> tmp, int[] nums,
			boolean[] isUsed) {
		if (tmp.size() == nums.length) {
			result.add(new ArrayList<>(tmp));
		}

		for (int i = 0; i < nums.length; i++) {
			if (isUsed[i] || (i > 0 && nums[i] == nums[i - 1]&& !isUsed[i-1]))
				continue;
			isUsed[i] = true;
			tmp.add(nums[i]);
			backTrackingDuplicated(result, tmp, nums, isUsed);
			isUsed[i] = false;
			tmp.remove(tmp.size() - 1);

		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		
		List<List<Integer>> result = permuteWithDuplicated(nums);
	
		System.out.println(result);
	}

}
