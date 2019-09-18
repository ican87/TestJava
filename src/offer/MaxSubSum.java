package offer;

/**
 * 最大子数组和
 * 
 * @author wanggang
 *
 */
public class MaxSubSum {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		int begin = 0;
		int end = 0;
		int maxSum = 1 << 31;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum <= 0) {
				sum = array[i];
				begin = i;
			} else {
				sum += array[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
				end = i;
			}
		}
		return maxSum;
	}

}
