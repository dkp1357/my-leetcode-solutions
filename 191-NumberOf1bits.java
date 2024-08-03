// 191

import java.util.*;

class NumberOf1bits {
	public static void main(String[] args) {
		System.out.println(new Solution().hammingWeight(11));
	}
}

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
        	if(n % 2 == 1) {
        		count++;
        	}
        	n /= 2;
        }
        return count;
    }
}