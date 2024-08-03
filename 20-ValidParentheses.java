// 20

// stack me opening brackets hi ayenge

import java.util.Stack;
import java.util.Vector;

class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(new Solution().isValid(s));
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.empty() == true) { // stack is empty
                st.push(s.charAt(i));
            }
            else { // stack is not empty
                if (this.matchingBracket(st.peek(),s.charAt(i))) // pop when brackets match
                st.pop();
                else // not matching brackets
                st.push(s.charAt(i));
            }
        }

        return st.empty();
    }

    public boolean matchingBracket(char ch1,char ch2) {
        if (ch1 == '(' && ch2 == ')')
            return true;
        else if (ch1 == '{' && ch2 == '}')
            return true;
        else if (ch1 == '[' && ch2 == ']')
            return true;

        return false;
    }
}