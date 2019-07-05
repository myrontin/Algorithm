package permutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
		permuteUnique(result, new ArrayList<>(), nums, isUsed);
		return result;

	}

	public static void permuteUnique(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] isUsed) {
		if (temp.size() == nums.length)
			result.add(new ArrayList<>(temp));
		for (int i = 0; i < nums.length; i++) {

			if (isUsed[i] == true||(i!=0&&nums[i]==nums[i-1]&&isUsed[i]==isUsed[i-1]))
				continue;
			temp.add(nums[i]);
			isUsed[i] = true;
			permuteUnique(result, temp, nums, isUsed);
			temp.remove(temp.size() - 1);
			isUsed[i] = false;

		}

	}
}
