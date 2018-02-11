package com.leetcode1209.MinStack;

import java.util.Stack;

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

	private Stack<Integer> stack;
	private Stack<Integer> miniStack;

	public MinStack() {
		stack = new Stack<>();
		miniStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (!miniStack.isEmpty()) {
			int min = miniStack.peek();
			if (x <= min) {
				miniStack.push(x);
			}
		} else {
			miniStack.push(x);
		}
	}

	public void pop() {
		int x = stack.pop();
		if (!miniStack.isEmpty()) {
			if (x == miniStack.peek()) {
				miniStack.pop();
			}
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return miniStack.peek();
	}
}
