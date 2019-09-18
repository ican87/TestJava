package offer;

import java.util.zip.Inflater;

public class GetUglyNumber {
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution1(4));
	}
	
	public static int GetUglyNumber_Solution1(int index) {
		if (index <= 0) {
			return 0;
		}
		int m = 0;
		int n = 0;
		while (m < index) {
			n++;
			if (isChouNum(n)) {
				m++;
			}
		}
		return n;
	}
	
	private static boolean isChouNum(int n) {
		while (n % 2 == 0) {
			n /= 2;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		return n == 1;
	}
	
	//wqy2
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] chou = new int[index];
		int flag2 = 0;
		int flag3 = 0; 
		int flag5 = 0;
		chou[0] = 1;
		int chouIndex = 1;
		while (chouIndex < index) {
			chou[chouIndex] = min(2 *chou[flag2], 3 *chou[flag3], 5 *chou[flag5]);
			while (2 * chou[flag2] <= chou[chouIndex]) {
				flag2++;
			}
			while (3 * chou[flag3] <= chou[chouIndex]) {
				flag3++;
			}
			while (5 * chou[flag5] <= chou[chouIndex]) {
				flag5++;
			}
			chouIndex++;
		}
		return chou[chouIndex - 1];
	}
	
	private int min(int a, int b, int c) {
		int min = a < b ? a : b;
		min = min < c ? min : c;
		return min;
	}
}
