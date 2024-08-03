//12

// 1 <= num <= 3999

// tc = o(1)
// sc = o(34) + o(1)

import java.util.*;

class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(1994));
	}
}
class Solution {
	public String intToRoman(int num) {
		// 1 <= num <= 3999
		// 1000,100,10,1 places 
		StringBuffer sb = new StringBuffer();

		String[] m = {"","M","MM","MMM"}; // 0000 to 3000
		String[] c = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}; // 000 to 900 
		String[] d = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}; // 00 to 90
		String[] i = {"","I","II","III","IV","V","VI","VII","VIII","IX"}; // 0 to 9

		sb.append(m[(num%10000)/1000]+c[(num%1000)/100]+d[(num%100)/10]+i[(num%10)/1]);
		System.gc();
		return sb.toString();
	}
}