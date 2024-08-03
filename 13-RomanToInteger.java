class RomanToInteger {
	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("Ix"));	
	}	
}

class Solution {
	public int romanToInt(String s) {
		s = s.toUpperCase();
		int number = 0;

		for (int i = 0; i+1 < s.length(); i++) {
			if(this.getIntValue(s.charAt(i)) < this.getIntValue(s.charAt(i+1))) {
				number -= this.getIntValue(s.charAt(i));
			} else { // >=
				number += this.getIntValue(s.charAt(i));
			}
		}
		number += this.getIntValue(s.charAt(s.length()-1));

		return number;
	}

	public int getIntValue(char ch) {
		int x = 0;

		switch(ch) {
		case 'I': 
			x = 1;
			break;
		case 'V': 
			x = 5;
			break;
		case 'X':
			x = 10;
			break;
		case 'L':
			x = 50;
			break;
		case 'C':
			x = 100;
			break;
		case 'D':
			x = 500;
			break;
		case 'M':
			x = 1000;
			break;
		}

		return x;
	}

}