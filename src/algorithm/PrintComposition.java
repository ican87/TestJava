package algorithm;

/**
 * 组合输出
 * // 递归：c(m,k) = c(m-1,k-1) + c(m-2,k-1) + ...+ c(k-1,k-1)
 * 
 * @author wanggang
 *
 */
public class PrintComposition {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		printComposition(array, 5, 3);
	}
	
	/**
	 * m 里选 n 个
	 * @param a
	 * @param m
	 * @param n
	 */
	private static void printComposition(int[] a, int m, int n) {
		int[] b = new int[n];
		printCombine(a, m, b, n, b.length);
	}
	
	private static void printCombine(int[] a, int m, int[] b, int n, int len) {
		if (n == 0) {
			for (int i = 0; i < len; i++) {
				System.out.print(b[i]);
			}
			System.out.println();
			return;
		}
		for (int i = m; i >= n; i--) {
			b[n - 1] = a[i - 1];
			printCombine(a, i - 1, b, n - 1, len);
		}
	}
}
