package jumpgame;

public class Solution {
	public boolean canJump(int[] nums) {
		int cur = 0;

		for (int i = 0; i < nums.length; i++) {
			if (cur < i)
				return false;
			cur = Math.max(i + nums[i], cur);
		}

		return true;
	}
}
