package combinationsumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		boolean[] isUsed = new boolean[candidates.length];
		combinationSum2(result, new ArrayList<>(), candidates, isUsed, target, 0);
		return result;
	}

	public static void combinationSum2(List<List<Integer>> result, List<Integer> temp, int[] candidates,
			boolean[] isUsed, int target, int start) {

		for (int i = start; i < candidates.length; i++) {
			int subTarget = target - candidates[i];
			if (isUsed[i] == true || subTarget < 0 || (start < i && candidates[i - 1] == candidates[i]))
				continue;
			if (subTarget == 0) {
				temp.add(candidates[i]);
				result.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				break;
			}
			temp.add(candidates[i]);
			isUsed[i] = true;
			combinationSum2(result, temp, candidates, isUsed, subTarget, i + 1);
			temp.remove(temp.size() - 1);
			isUsed[i] = false;
		}

	}
}
