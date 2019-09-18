package offer;

import java.util.Arrays;

/**
 * 给定一个二叉树的 前序排列 和 中序排列，然后构建二叉树
 * int[] pre = {1,2,4,7,3,5,6,8}
 * int[] in =  {4,7,2,1,5,3,8,6}
 * 
 * @author wanggang
 *
 */
public class ConstructBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		int length = pre.length;
		if (length <= 0) {
			return null;
		}
		TreeNode head = new TreeNode();
		head.val = pre[0];
		int i = 0; 
		while (head.val != in[i]) {
			i++;
		}
		if (i > 0) {
			int leftPre[] = Arrays.copyOfRange(pre, 1, i + 1);
			int leftIn[] = Arrays.copyOfRange(in, 0, i);
			head.left = reConstructBinaryTree(leftPre, leftIn);
		} else {
			head.left = null;
		}
		if (i < length - 1) {
			int[] rightPre = Arrays.copyOfRange(pre, i + 1, length);
			int[] rightIn = Arrays.copyOfRange(in, i + 1, length);
			head.right = reConstructBinaryTree(rightPre, rightIn);
		} else {
			head.right = null;
		}
		return head;
	}

}

