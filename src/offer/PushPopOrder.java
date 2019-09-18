package offer;

import java.util.Stack;

/**
 * 已知一个栈的push序列，判断另一个序列是否为栈的pop序列？
 * 
 * @author wanggang
 *
 */
public class PushPopOrder {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if (null == pushA || null == popA) {
			return false;
		}
		if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
			return false;
		}
		int j = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (stack.peek() == popA[j] && j < popA.length) {
				stack.pop();
				j++;
			}
		}
		return stack.empty();
	}
}
