package offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 
 * @author wanggang
 *
 */
public class StackQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void push(int node) {
		stack1.push(node);
	}
	
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			return -1;
		} else {
			return stack2.pop();
		}
	}
}
