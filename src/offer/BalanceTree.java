package offer;

/**
 * 判断是否为平衡二叉树
 * 
 * @author wanggang
 *
 */
public class BalanceTree {
	
	class Holder {
		int depth;
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
		return f(root, new Holder());
	}
	
	private boolean f(TreeNode root, Holder holder) {
		if (root == null) {
			holder.depth = 0;
			return true;
		}
		Holder left = new Holder();
		Holder right = new Holder();
		if (f(root.left, left) && f(root.right, right)) {
			if (left.depth - right.depth >= -1 && left.depth - right.depth <= 1) {
				holder.depth = left.depth > right.depth ? left.depth + 1 : right.depth + 1;
				return true;
			}
		}
		return false;
	} 

}
