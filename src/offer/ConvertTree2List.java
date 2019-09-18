package offer;

/**
 * 二叉排序树 转为 双向链表
 * 
 * @author wanggang
 *
 */
public class ConvertTree2List {
	TreeNode head;
	TreeNode p;
	public TreeNode Convert(TreeNode pRootOfTree) {
		convert(pRootOfTree);
		return head;
	}
	
	private void convert(TreeNode node) {
		if (null == node) {
			return;
		}
		convert(node.left);
		if (null == p) {
			p = node;
			head = node;
		} else {
			p.right = node;
			node.left = p;
			p = node;
		}
		convert(node.right);
	}
}
