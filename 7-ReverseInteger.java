//7

//Integer.MAX_VALUE = 2147483647
//Integer.MIN_VALUE = -2147483648

class Solution {
	public int reverse(int x) {
		final int SIGN = (x > 0) ? 1 : -1;
		x = SIGN*x; // Math.abs(x)
		
		int temp = x;
		int reverse = 0;
		int result = 0;
		
		while(temp != 0) {
			if (reverse > ( Integer.MAX_VALUE - (temp%10) ) / 10) {
				return 0;
			}
			reverse = reverse*10 + (temp % 10);
			temp = temp/10;
		}

		result = reverse*SIGN;
		
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}

		return result;
	}
}

/*
reverse*10 + (temp % 10) calculate karte samay hi overflow ho sakta hai
jo kaise bhi number dega isliye 
if() {
	
} 
ke condition me
  reverse > ( Integer.MAX_VALUE - (temp%10) ) / 10
aisa likhna hoga
*/