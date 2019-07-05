package reverseinteger;

public class Solution {
	   public int reverse(int x) {
	        int reverse = 0;
			while(x!=0){
				int tail = x%10;
				int newResult = reverse*10+tail;
				if(newResult/10!=reverse)
					return 0;
				
				reverse = newResult;
				x/=10;

			}

			return reverse;
	        
	        
	    }
}
