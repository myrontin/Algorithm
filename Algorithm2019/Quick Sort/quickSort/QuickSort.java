package quickSort;

public class QuickSort {

	public static void quick_sort(int[] nums) {
		quick_sort(nums, 0, nums.length - 1);
	}

	public static void quick_sort(int[] nums, int l, int h) {
		if (h <= l)
			return;
		int pivot = nums[h];
		int i = l, j = h - 1;
		
		while(i<j) {
			 while(nums[i]<pivot) {
				 
			 }
			 while(nums[j]>pivot) {
				 
			 }
		}

	}

	
	
	
	public static void swap(int[] nums, int a, int b) {
		if (a == b)
			return;
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;

	}

	public int findKthLargest(int[] nums, int k) {
		quick_sort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 4, 8, 2, 4, 9, 1, 0, 0 };
		int[] nums1 = { 2, 7, 9, 0, 6, 1 };
		quick_sort(nums);
		for (int n : nums) {
			System.out.println(n);
		}
	}

}
