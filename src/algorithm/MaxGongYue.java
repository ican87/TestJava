package algorithm;

/**
 * 最大公约数
 * 
 * @author wanggang
 *
 */
public class MaxGongYue {
	public static void main(String[] args) {
		System.out.println(getMaxGongYue(24, 18));
	}
	
	private static int getMaxGongYue(int a, int b) {
		if (b > a) {
			return getMaxGongYue(b, a);
		} else if (b == 0) {
			return a;
		} else {
			return getMaxGongYue(b, a % b);
		}
	}
}
