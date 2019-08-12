package algorithm;

import java.util.Arrays;

/**
 * 数组和为sum的对
 * 
 * @author wanggang
 *
 */
public class PairSumInArray {

	public static void main(String[] args) {
		int a[] = {1,3,44,2,4,5,54,222,368};
		int sum = 6;
		printPair(a, sum);
	}
	
	private static void printPair(int[] a, int sum) {
		Arrays.sort(a);
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			if (a[left] + a[right] > sum) {
				right--;
			} else if (a[left] + a[right] < sum) {
				left++;
			} else {
				System.out.println(a[left] + "-" + a[right]);
				left++;
				right--;
			}
		}
	}

}
