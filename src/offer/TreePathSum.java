package offer;

import java.util.ArrayList;

/**
 * 输出二叉树中所有和为target的路径
 * 
 * @author wanggang
 *
 */
public class TreePathSum {
	ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		if (null == root) {
			return listAll;
		}
		list.add(root.val);
		target -= root.val;
		if (0 == target && root.left == null && root.right == null) {
			listAll.add(new ArrayList<>(list));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);
		return listAll;
	}
}
