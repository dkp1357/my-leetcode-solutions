// 69-Sqrt(x)
//46340 square = 2147395600
//46341 square = 2147488281
// 2147483647 sqrt = 46340

// kaamchalau solution

class Solution {
	public int mySqrt(int x) {
		// x is non negative integer
		// sqrt(x) should be rounded Down to nearest integer
		if (x >= 2147395600) {
			return 46340;
		}
		if (x <= 1) {
			return x;
		}
		int sqrt = 0;
		for (int i = 1; i <= x/2; i++) {
			if (i*i == x) {
				sqrt = i; // sqrt found
				break;  // break out
			} else if (i*i > x) {
				sqrt = i-1; // sqrt found
				break; // break out
			}
		}
		return sqrt;
	}
}