package mergeSort;

public class MergeSort {

	public static void mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
	}

	public static void mergeSort(int[] nums, int l, int h, int[] tmp) {
		int mid = (l + h) / 2;
		if (mid > l) {
			mergeSort(nums, l, mid, tmp);
			mergeSort(nums, mid + 1, h, tmp);
		}

		merge(nums, l, h, tmp);
	}

	public static void merge(int[] nums, int l, int h, int[] tmp) {
		if (l == h)
			return;
		int mid = (l + h) / 2;
		int m = l;
		int n = mid + 1;
		for (int k = l; k < h + 1; k++) {
			tmp[k] = nums[k];
		}
		for (int i = l; i < h + 1; i++) {
			if (m > mid) {
				nums[i] = tmp[n++];
				continue;
			}
			if (n > h) {
				nums[i] = tmp[m++];
				continue;
			}

			if (tmp[m] >= tmp[n]) {
				nums[i] = tmp[n++];
				continue;
			}
			if (tmp[n] > tmp[m]) {
				nums[i] = tmp[m++];
				continue;
			}

		}

//		while (i < h + 1) {
//			if (m < mid + 1) {
//				if (m < mid + 1) {
//					tmp[m + 1] = nums[i + 1];
//				}
//				nums[i++] = tmp[m++];
//			}
//			if (n < h + 1) {
//				if (n < h) {
//					tmp[n + 1] = nums[i + 1];
//				}
//				nums[i++] = tmp[n++];
//			}
//		}

	}

	public static void main(String[] args) {

		int[] nums = { -4, 0, 7, 4, 9, -5, -1, 0, -7, -1 };
		int[] nums1 = { 5, 1, 1, 2, 0, 0 };
		mergeSort(nums, 0, 9, new int[10]);

		for (int n : nums) {
			System.out.println(n);
		}
	}

}
