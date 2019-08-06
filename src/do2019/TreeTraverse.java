package do2019;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的遍历
 * 
 * @author wanggang
 *
 */
public class TreeTraverse {
	/**
	 * 先根遍历，深度优先，递归
	 * @param root
	 */
	public void rootFirstTraverse1(Node root) {
		if (root != null) {
			System.out.println(root.data);
			for (Node node : root.children) {
				rootFirstTraverse1(node);
			}
		}
	}
	
	/**
	 * 先根遍历，深度优先，非递归（借用stack）
	 * @param root
	 */
	public void rootFirstTraverse2(Node root) {
		Node p = root;
		Stack<Node> stack = new Stack<>();
		while (p != null || !stack.empty()) {
			while (p != null) {
				System.out.println(p.data);
				p.isVisited = true;
				stack.push(p);
				p = p.getUnVisitChild();
			}
			stack.pop();
			if (!stack.empty()) {
				p = stack.peek();
				p = p.getUnVisitChild();
			}
		}
	}
	
	/**
	 * 广度优先（借用queue）
	 * @param root
	 */
	public void breadthTraverse(Node root) {
		Node p = root;
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(p);//入队
		while (!queue.isEmpty()) {
			Node node = queue.poll();//出队
			System.out.println(node.data);
			for (Node node2 : node.children) {
				queue.add(node2);
			}
		}
	}
}

/**
 * 树的结点
 * @author wanggang
 *
 */
class Node {
	int data;
	boolean isVisited;
	List<Node> children;
	
	Node getUnVisitChild() {
		for (Node node : children) {
			if (!node.isVisited) {
				return node;
			}
		}
		return null;
	}
}
