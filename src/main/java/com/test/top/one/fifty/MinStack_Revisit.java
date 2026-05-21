package com.test.top.one.fifty;

import java.util.Stack;

public class MinStack_Revisit {

    static void main() {
        MinStack_Revisit minStack = new MinStack_Revisit();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public void push(int x) {
        st.push(x);

        // If the minSt is empty or the new element is smaller than
        // the top of minSt, push it onto minSt
        if (minSt.isEmpty() || x <= minSt.peek()) {
            minSt.push(x);
        } else {

            // Otherwise, push the top element of minSt
            // again to keep the minimum unchanged
            minSt.push(minSt.peek());
        }
    }

    public int top(){
        return st.peek();
    }

    // Pop the top element from the stack
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        // Pop from both stacks
        st.pop();
        minSt.pop();
    }

    // Return the top element of the stack without removing it
    public int peek() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    // Get the minimum element in the stack
    public int getMin() {
        if (minSt.isEmpty()) {
            return -1;
        }
        return minSt.peek();
    }
}
