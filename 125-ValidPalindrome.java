// 125

// all uppercase letters should be lower case
// only alphanumeric characters are to be considered

class ValidPalindrome {
	public static void main(String[] args) {
		String s = "  ";
		System.out.println(new Solution().isPalindrome(s));
	}
}

class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();

		if (s.equals(" ") || s == null)
			return true;

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				sb.append(s.charAt(i));
			else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				sb.append(s.charAt(i));
		}

		s = sb.toString();

		/*
		int start = 0;
		int end = s.lenght()-1;

		while(end > start) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			end--;
			start++;
		}

		return true;
		*/
		
		return s.equals(sb.reverse().toString()); 
	}
}