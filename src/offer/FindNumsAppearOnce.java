package offer;

/**
 * 两个数字只出现一次
 * 
 * @author wanggang
 *
 */
public class FindNumsAppearOnce {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2) {
			num1[0] = num2[0] = 0;
		}
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result ^= array[i];
		}
		int index = 0;
		for (int i = 0; i < 32; i++) {
			if ((result & 1) == 1) {
				break;
			} else {
				index++;
				result >>= 1;
			}
		}
		num1[0] = num2[0] = 0;
		for (int i = 0; i < array.length; i++) {
			int temp = (1 << index);
			if ((temp & array[i]) == 0) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

}
