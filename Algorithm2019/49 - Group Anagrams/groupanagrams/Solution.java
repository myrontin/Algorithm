package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String s:strs){
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String str=String.valueOf(temp);
			if(!map.containsKey(str)){
				map.put(str, new ArrayList<>());
				result.add(map.get(str));
			}
			map.get(str).add(s);
			
		}
		
		
		
		return result;
    }
}
