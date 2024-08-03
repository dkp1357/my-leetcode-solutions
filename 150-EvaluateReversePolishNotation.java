// 150

import java.util.*;

class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String tokens[] = {"2","1","+","3","*"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
class Solution {
    private int calculate(int b,int a,String operation) {
        int x = 0;
        switch(operation) {
        case "+":
            x = a+b;
            break;
        case "-":
            x = a-b;
            break;
        case "*":
            x = a*b;
            break;
        case "/":
            x = a/b;
            break;
        }
        return x;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>(); 
        stk.push(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int x = this.calculate(stk.pop(),stk.pop(),tokens[i]);
                stk.push(x);
            } else {
                stk.push(Integer.parseInt(tokens[i]));
            }
        }
        return stk.pop();
    }
}