package offer;

import java.util.Arrays;

/**
 * 判断一个序列是否为二叉搜索树的后序遍历序列
 * 
 * @author wanggang
 *
 */
public class IsLastOrder {
	public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || 0 == sequence.length) {
            return false;
        }
        if (1 == sequence.length) {
            return true;
        }
        int len = sequence.length;
        int root = sequence[len - 1];
        boolean isFirstBig = false;
        int j = -1;
        for (int i = 0; i < len; i++) {
            if (sequence[i] > root && !isFirstBig) {
                isFirstBig = true;
                j = i;
            }
            if (isFirstBig && sequence[i] < root) {
                return false;
            }
        }

        boolean left = true;
        boolean right = true;
        if (j == -1) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, len - 1));
        } else if (j == 0) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, len - 1));
        } else {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, j));
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, j, len - 1));
        }
        return left && right;
    }
}
