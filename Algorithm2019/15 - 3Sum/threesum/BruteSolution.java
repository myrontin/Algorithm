package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteSolution {
	public  List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i =0;i<nums.length;i++){
			int target = -nums[i];
			int left = i+1;
			int right = nums.length-1;
 			if(i>0&&nums[i]==nums[i-1]) continue;
			while(left <right){
				
				if(nums[left]+nums[right]==target){
					List<Integer> sum = new ArrayList<>();
					sum.add(nums[i]);
					sum.add(nums[right]);
					sum.add(nums[left]);
					result.add(sum);
				}
				while(target>=nums[left]+nums[right]&&nums[left+1]==nums[left]&&left+1<right)
					left++;
				while(target<nums[left]+nums[right]&&nums[right-1]==nums[right]&&right-1>left)
					right--;
				
				if(target<nums[left]+nums[right]){
					right--;
				}else{
					left++;
				}
	
			}
			
			
			
		}
		
		
		 return result;
	}
}
