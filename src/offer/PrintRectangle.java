package offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩形
 * 
 * @author wanggang
 *
 */
public class PrintRectangle {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		if (null == matrix) {
			return list;
		}
		int n = matrix.length;//行数
		int m = matrix[0].length;//列数
		if (n <= 0 || m <= 0) {
			return list;
		}
		int c = (Math.min(n, m) + 1) >> 1;//循环次数
		for (int i = 0; i < c; i++) {
			for (int j = i; j < m - i; j++) {
				list.add(matrix[i][j]);
			}
			for (int j = i + 1; j < n - i; j++) {
				list.add(matrix[j][m - i - 1]);
			}
			for (int j = m - i - 2; j >= i && i != n - i - 1; j--) {
				list.add(matrix[n - i - 1][j]);
			}
			for (int j = n - i - 2; j > i && i != m - i - 1; j--) {
				list.add(matrix[j][i]);
			}
		}
		return list;
	}
}
