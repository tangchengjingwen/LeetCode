package com.leetcode1209.MinStack;

import java.util.ArrayList;
import java.util.List;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//Example:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> Returns -3.
//minStack.pop();
//minStack.top();      --> Returns 0.
//minStack.getMin();   --> Returns -2.

public class MinStack {
	List<Integer> stack ;
	List<Integer> minStack ;
	
	
	public MinStack() {
		stack = new ArrayList<Integer>();
		minStack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
    	stack.add(x);
    	if(minStack.isEmpty() || x <= minStack.get(minStack.size()-1))
    		minStack.add(x);
    }
    
    public void pop() {
    	if(stack.isEmpty()) return;
    	int ele = stack.remove(stack.size()-1);
    	if(!minStack.isEmpty() && minStack.get(minStack.size()-1)==ele)
    		minStack.remove(minStack.size()-1);
    }
    
    public int top() {
    	if(stack.isEmpty()) return 0;
    	return stack.get(stack.size()-1);
    }
    
    public int getMin() {
    	if(minStack.isEmpty()) return 0;
    	return minStack.get(minStack.size()-1);
    }
}
















