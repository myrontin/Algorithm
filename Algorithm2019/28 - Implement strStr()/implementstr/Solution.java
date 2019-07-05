package implementstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;	
        
        int m = haystack.length();
		int n = needle.length();
		
		int result = -1;
		for (int i = 0; i <m-n+1; i++) {
		
				if(haystack.substring(i,i+needle.length()).equals(needle)){
					return i;
				
				
			}
		}

		return result;
    }
}
