// 344. Reverse String
class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (end > start) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            end--;
            start++;
        }
    }
}