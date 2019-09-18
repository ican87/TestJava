package offer;

/**
 * 1~n中，十进制表示的数字，1出现的次数。
 * 
 * @author wanggang
 *
 */
public class OneSum {
	public static void main(String[] args) {
		System.out.println(sum1(12));//5
		System.out.println(sum2(12));//5
		System.out.println(sum3(12));//5
	}
	
	public static int sum1(int n) {
		int count = 0;
		while (n > 0) {
			int m = n;
			while (m > 0) {
				if (m % 10 == 1) {
					count++;
				}
				m = m / 10;
			}
			n--;
		}
		return count;
	}
	
	public static int sum2(int n) {
		int count = 0;
		while (n > 0) {
			String str = String.valueOf(n);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					count++;
				}
			}
			n--;
		}
		return count;
	}
	
	public static int sum3(int n) {
		if (n == 0) {
			return 0;
		} else if (n < 10) {
			return 1;
		} else {
			String str = String.valueOf(n);
			int len = str.length();
			int first = n / get10N(len - 1);
			int a = 0;
			int b = 0;
			
			if (first > 1) {
				a = get10N(len - 1);
			} else {
				a = n % get10N(len - 1) + 1;
			}
			b = first * (len - 1) * get10N(len - 2);
			return a + b + sum3(n % get10N(len - 1));
		}
	}
	
	private static int get10N(int n) {
		int count = 1;
		while (n > 0) {
			count *= 10;
			n--;
		}
		return count;
	}
}
