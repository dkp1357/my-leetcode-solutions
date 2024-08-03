// 155

import java.util.ArrayList;

class MinStack {

    //ArrayList<Integer> al = new ArrayList<>();
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minimum = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        //al.add(val);
        st.push(val);
        if (minimum.empty() || minimum.peek() >= val) { // add only if val is lesser than or equal to
            minimum.push(val);
        }
    }
    
    public void pop() {
        if (minimum.peek().equals(st.peek())) { // == bhi chalta
            minimum.pop();
        }
        st.pop();
        //al.remove(al.size()-1);
    }
    
    public int top() {
        return st.peek();
        //return al.get(al.size()-1);
    }
    
    public int getMin() {
        // 'minimum' stack peek will be the minimum element of stack st
        return minimum.peek();
    }
}

//stack 0,1,0
// min stack 0 
// stack pop
// stack 0,1
//min stack null
//therefore it was necessary to have if minimum.peek() >= val then minimum.push(val)

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*

class MinStack {

    // this is used to keep track of the minimum
    Stack<Integer> minvals = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minvals.isEmpty() || val <= minvals.peek()) {
            minvals.push(val);
        }

    }

    public void pop() {

        if (minvals.peek().equals(stack.peek())) {
            minvals.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minvals.peek();
    }
}

*/