package algorithm;

/**
 * 用字符串实现两个大数相乘
 * 
 * @author wanggang
 *
 */
public class BigNumMultiply {
	public static void main(String[] args) {
		System.out.println(multiply("23456", "78"));//1829568
		System.out.println(multiply("9999", "9999"));//99980001
	}
	
	private static String multiply(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return "0";
		}
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		//1.reverse char array
		reverseCharArray(a);
		reverseCharArray(b);
		int len = a.length + b.length;
		int[] c = new int[len];
		//2.initial array
		for (int i = 0; i < len; i++) {
			c[i] = 0;
		}
		//3.multiply
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int x = a[i] - '0';
				int y = b[j] - '0';
				c[i + j] = c[i + j] + x * y;
			}
		}
		//4.进位
		for (int i = 0; i < len; i++) {
			int temp = c[i] / 10;
			c[i] = c[i] % 10;
			if (temp > 0) {
				c[i + 1] = c[i + 1] + temp;
			}
		}
		//5.找到最高位，并组装结果
		StringBuilder builder = new StringBuilder("");
		boolean beginAssemble = false;
		for (int i = len - 1; i >= 0; i--) {
			if (c[i] > 0) {
				beginAssemble = true;
			}
			if (beginAssemble) {
				builder.append(c[i]);
			}
		}
		return builder.toString();
	}
	
	private static void reverseCharArray(char[] a) {
		if (a == null || a.length <= 0) {
			return;
		}
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			a[i] = (char) (a[i] + a[n - i - 1]);
			a[n - i - 1] = (char) (a[i] - a[n - i - 1]);
			a[i] = (char) (a[i] - a[n - i - 1]);
		}
	}
}
