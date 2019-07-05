package dividetwointegers;

public class Solution {
	   public int divide(int dividend, int divisor) {
			if (dividend == Integer.MIN_VALUE && divisor == -1)
				return Integer.MAX_VALUE;

			int negative = 0;
			if ((divisor < 0 && dividend < 0) || (divisor > 0 && dividend > 0))
				negative = 0;
			else
				negative = 1;
			if (divisor > 0)
				divisor = -divisor;
			if (dividend > 0)
				dividend = -dividend;
			// divisor = Math.abs(divisor);
			// dividend = Math.abs(dividend);

			if (divisor < dividend)
				return 0;
			int sum = divisor;
			int result = 1;
			while ((sum+sum)<0&&(sum + sum) >= dividend) {
				
				
				
				sum += sum;
				result += result;
			}
			if (negative == 0)
				return result + divide(dividend - sum, divisor);
			else
				return -result - divide(dividend - sum, divisor);
	    }
}
