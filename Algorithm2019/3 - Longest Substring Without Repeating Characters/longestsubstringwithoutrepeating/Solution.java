package longestsubstringwithoutrepeating;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public int lengthOfLongestSubstring(String s) {
	        Map<Character,Integer> map = new HashMap<>();
	        int max =0;
	        int next = 0;
	        for(int i =0;i<s.length();i++){
	            char ch = s.charAt(i);
	            if(map.containsKey(ch)){
	                next = Math.max(next,map.get(ch)+1);
	            }
	            map.put(ch,i);
	            max = Math.max(max,i-next+1);
	        }
	        return max;
	    }
}
