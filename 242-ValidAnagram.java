class Solution {
	public boolean isAnagram(String s,String t) {
		int hashS[] = new int[26];
		int hashT[] = new int[26];
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < 26; i++) {
			hashT[i] = 0;
			hashS[i] = 0;
		}
		// s.length() == t.length()
		for (int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			hashS[ch1 - 'a']++; // a pe hashS[0]++
			hashT[ch2 - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (hashS[i] != hashT[i]) {
				return false;
			}
		}
		return true;
	}
}

/*

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
			return false;
		}

        int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}

*/