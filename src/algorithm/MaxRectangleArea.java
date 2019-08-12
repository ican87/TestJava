package algorithm;

/**
 * 最大矩形面积
 * 
 * @author wanggang
 *
 */
public class MaxRectangleArea {
	public static void main(String[] args) {
		int height[] = {2,3,5,6,4,3};
		System.out.println(getMaxRectangleArea(height));//15
	}
	
	private static int getMaxRectangleArea(int[] a) {
		int max = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int width = 1;
			//left
			for (int x = i - 1; x >= 0; x--) {
				if (a[i] > a[x]) {
					break;
				} else {
					width++;
				}
			}
			//right
			for (int y = i + 1; y < n; y++) {
				if (a[i] > a[y]) {
					break;
				} else {
					width++;
				}
			}
			int now = width * a[i];
			if (now > max) {
				max = now;
			}
		}
		return max;
	}
}
