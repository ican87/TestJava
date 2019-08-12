package algorithm;

/**
 * 比较两个二叉树是否相等
 * 
 * @author wanggang
 *
 */
public class TreeCompare {
	public boolean isSameTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}
