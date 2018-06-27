package com.fpc.Test;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    Stack s = new Stack<Integer>();
    Stack mins = new Stack<Integer>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        s.push(x);
        if ( mins.isEmpty() || (Integer)mins.peek() <= x ) {
            mins.push(x);
        }
    }
    
    public void pop() {
        int toop = (int) s.pop();
        if ( toop == (Integer)mins.peek() ) {
            mins.pop();
        }
    }
    
    public int top() {
        return (int) s.peek();
    }
    
    public int getMin() {
        return (int) mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */