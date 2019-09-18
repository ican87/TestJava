package offer;

public class StrToInt {
	public int StrToInt(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char[] a = str.toCharArray();
		int flag = 1;
		int index = 0;
		if (a[0] == '+') {
			flag = 1;
			index = 1;
		}
		if (a[0] == '-') {
			flag = -1;
			index = 1;
		}
		int sum = 0;
		for (int i = index; i < a.length; i++) {
			if (a[i] < '0' || a[i] > '9') {
				return 0;
			}
			sum = sum * 10 + (a[i] - '0');
		}
		return flag * sum;
	}
}
