package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：反向打印单链表
 * 
 * @author wanggang
 *
 */
public class PrintLinkedListReverse {
	
	//way1  使用stack
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.data);
			listNode = listNode.next;
		}
		while (!stack.empty()) {
			list.add(stack.pop());
		}
		return list;
	}
	
	//way2 使用递归
	ArrayList<Integer> nodeList = new ArrayList<>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			return nodeList;
		}
		printListFromTailToHead(listNode.next);
		nodeList.add(listNode.data);
		return nodeList;
	}
}

class ListNode {
	int data;
	ListNode next;
}
