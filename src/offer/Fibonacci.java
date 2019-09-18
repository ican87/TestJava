package offer;

/**
 * 斐波拉契数列，规则：
 * f(0) = 0;
 * f(1) = 1;
 * f(n) = f(n - 1) + f(n - 2);
 * 方法一：递归
 * 方法二：循环（高效）
 * 
 * @author wanggang
 *
 */
public class Fibonacci {
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			int left = 1;
			int right = 0;
			int temp = 0;
			for (int i = 2; i <= n; i++) {
				temp = left;
				left = left + right;
				right = temp;
			}
			return left;
		} else {
			return -1;
		}
	}
}
