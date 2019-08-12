package algorithm;

/**
 * 子数组的最大和
 * 
 * @author wanggang
 *
 */
public class MaxSumOfSubArray {

	public static void main(String[] args) {
		int a[] = {-1,7,-2,4,1,-3};
		System.out.println(getMaxSumOfSubArray(a));
	}
	
	private static int getMaxSumOfSubArray(int[] a) {
		int max = 1 << 31;
		int sum = 0;//以a[i]为尾的最大子序列和
		int begin = 0;
		int end = 0;
		for (int i = 0; i < a.length; i++) {
			if (sum <= 0) {
				sum = a[i];
				begin = i;
			} else {
				sum += a[i];
			}
			if (sum > max) {
				max = sum;
				end = i;
			}
		}
		System.out.println("begin=" + begin + ", end=" + end);
		return max;
	}

}
