package triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.size()+1];
		
	
	
		    for(int i=triangle.size()-1;i>=0;i--){
		        for(int j=0;j<triangle.get(i).size();j++){
		        	dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
		        }
			
		
		}
		return dp[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		List<Integer> three = new ArrayList<>();
		List<Integer> four = new ArrayList<>();
		one.add(-1);
		two.add(2);
		two.add(3);
		three.add(1);
		three.add(-1);
		three.add(-3);
		four.add(4);
		four.add(1);
		four.add(8);
		four.add(3);

		list.add(one);
		list.add(two);
		list.add(three);
		//list.add(four);

		System.out.println(minimumTotal(list));

	}
}
