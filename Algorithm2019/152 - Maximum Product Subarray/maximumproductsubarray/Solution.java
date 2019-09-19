package maximumproductsubarray;

public class Solution {
	public static int maxProduct(int[] nums) {

		int cur_max = nums[0];
		int neg_pos = -1;
		if (nums[0] < 0)
			neg_pos = 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		for (int i = 1; i < dp.length; i++) {
			int n = dp[i - 1] * nums[i];
			if (dp[i - 1] == 0) {
				dp[i] = nums[i];
				cur_max = Math.max(nums[i], cur_max);
				if (nums[i] < 0)
					neg_pos = i;
				continue;
			}

			if (nums[i] >= 0) {

				dp[i] = Math.max(nums[i], n);
				cur_max = Math.max(n, cur_max);

			} else if (nums[i] < 0) {

				dp[i] = n;
				if (neg_pos != -1) {
					if (i - 1 == neg_pos) {
						dp[i] = dp[neg_pos] * nums[i];
					} else {
						dp[i] = dp[neg_pos] * dp[i - 1] * nums[i];
					}

					cur_max = Math.max(dp[i], cur_max);
				} else {
					
				}
				
				
				neg_pos= i;
				
				

			}

		}

		return cur_max;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {3,-1,-3,-2,4};
		System.out.println(maxProduct(nums));		
		
		
		
		
	}
}
