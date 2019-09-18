package offer;

/**
 * 打印从1到最大的N位数
 * 例如，当N=3时，打印1~999。
 * 
 * @author wanggang
 *
 */
public class PrintFromOneToMaxN {
	public static void main(String[] args) {
		print(2);
	}
	
	private static void print(int n) {
		if (n <= 0) {
			return;
		}
		char[] a = new char[n];
		for (int i = 0; i < n; i++) {
			a[i] = '0';
		}
		while (!isIncrease(a)) {
			printNum(a);
		}
	}
	
	private static boolean isIncrease(char[] a) {
		int n = a.length;
		boolean isOverFlow = false;
		int jinwei = 0;
		for (int i = n - 1; i >= 0; i--) {
			int temp = (a[i] - '0') + jinwei;
			if (i == n - 1) {
				temp++;
			}
			if (temp >= 10) {
				if (i == 0) {
					isOverFlow = true;
				} else {
					jinwei = 1;
					temp -= 10;
					a[i] = (char) (temp + '0');
				}
			} else {
				a[i] = (char) (temp + '0');
				break;
			}
		}
		return isOverFlow;
	}
	
	private static void printNum(char[] a) {
		int n = a.length;
		boolean begin = false;
		for (int i = 0; i < n; i++) {
			if (a[i] != '0') {
				begin = true;
			}
			if (begin) {
				System.out.print(a[i]);
			}
		}
		System.out.println();
	}
}
