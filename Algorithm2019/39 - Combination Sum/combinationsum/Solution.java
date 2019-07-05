package combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(result, new ArrayList<>(), candidates, target, 0);
		return result;
	}

	public void combinationSum(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target,
			int start) {

		for (int i = start; i < candidates.length; i++) {
			int subTarget = target - candidates[i];
			if (subTarget == 0) {
				temp.add(candidates[i]);
				result.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				break;
			}

			if (subTarget < candidates[i])
				continue;
			temp.add(candidates[i]);
			combinationSum(result, temp, candidates, subTarget, i);
			temp.remove(temp.size() - 1);
		}

	}
}
