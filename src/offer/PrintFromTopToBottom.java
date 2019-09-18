package offer;

import java.util.ArrayList;

/**
 * 水平打印（层次打印）二叉树
 * 利用队列思想
 * 
 * @author wanggang
 *
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> listInt = new ArrayList<>();
		ArrayList<TreeNode> listNode = new ArrayList<>();
		if (null == root) {
			return listInt;
		}
		listNode.add(root);
		listInt.add(root.val);
		for (int i = 0; i < listNode.size(); i++) {
			TreeNode node = listNode.get(i);
			if (node.left != null) {
				listNode.add(node.left);
				listInt.add(node.left.val);
			}
			if (node.right != null) {
				listNode.add(node.right);
				listInt.add(node.right.val);
			}
		}
		return listInt;
	}
}
