package algorithm;

import java.util.Random;

/**
 * 随机数
 * 
 * @author wanggang
 *
 */
public class RandomNumber {
	public static void main(String[] args) {
		int n = 10;
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}
		Random random = new Random();
		int m = n;
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(m);
			b[i] = a[index];
			a[index] = a[m - 1];
			m--;
		}
		for (int x : b) {
			System.out.print(x);
		}
	}

}
