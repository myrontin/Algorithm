package palindromenumber;

public class Solution {
	public boolean isPalindrome(int x) {
        if(x<0) return false;
        int original = x;
        int palindrome = 0;
        while(x>0){
            int i = x%10;
            palindrome = palindrome*10+i;
            x /=10;    
        }
        if(original == palindrome ) return true;
        return false;
        
        
    }
}
