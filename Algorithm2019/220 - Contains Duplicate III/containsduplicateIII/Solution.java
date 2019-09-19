package containsduplicateIII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length && j <= i + k; j++) {
				if (compare(nums[i], nums[j], t)) {
					return true;
				}

			}
			// map.put(nums[i], i);
		}
		return false;

	}

	public static boolean compare(int x, int y, int t) {
		if (y > x) {
			return compare(y, x, t);
		}
		if (x == Integer.MAX_VALUE) {
			if (y < 0)
				return false;
	
		}

		if (y == Integer.MIN_VALUE) {
			if (x > 0)
				return false;
			

		}

		return (Math.abs(x - y) <= t);

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int[] nums1 = { 1, 0, 1, 1 };
		int[] nums2 = { 1, 5, 9, 1, 5, 9 };
		int[] nums3 = {};
		int[] nums4 = { -1, -1 };
		int[] nums5 = { -1, 2147483647 };
		int[] nums6 = { 1, -2147483648 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(nums1, 1, 2));
		System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 3));
		System.out.println(containsNearbyAlmostDuplicate(nums3, 0, 0));
		System.out.println(containsNearbyAlmostDuplicate(nums4, 1, -1));
		System.out.println(containsNearbyAlmostDuplicate(nums5, 1, 2147483647));

		System.out.println(containsNearbyAlmostDuplicate(nums6, 1, 2147483647));
	}
}
