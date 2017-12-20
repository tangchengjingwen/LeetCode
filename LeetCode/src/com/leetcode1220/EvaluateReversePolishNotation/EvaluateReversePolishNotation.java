package com.leetcode1220.EvaluateReversePolishNotation;

import java.util.Stack;

//		Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//		
//		Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//		
//		Some examples:
//		  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//		  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

//time:O(n) space:O(n)
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (s.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (s.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (s.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
}
