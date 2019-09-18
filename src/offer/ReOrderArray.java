package offer;

/**
 * 将数组中奇数放在偶数前面
 * 
 * @author wanggang
 *
 */
public class ReOrderArray {
	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		reOrderArray2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}
	
	//way1：双指针方案，不维持原有顺序
	public static void reOrderArray1(int [] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int begin = 0;
		int end = array.length - 1;
		while (begin < end) {
			while (begin < end && (array[begin] & 1) == 1) {
				begin++;
			}
			while (begin < end && (array[end] & 1) == 0) {
				end--;
			}
			if (begin < end) {
				array[begin] = array[begin] + array[end];
				array[end] = array[begin] - array[end];
				array[begin] = array[begin] - array[end];
			}
		}
	}
	
	//way2：维持原有顺序
	public static void reOrderArray2(int [] array) {
		if (array == null || array.length <= 0) {
			return;
		}
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			if ((array[i] & 1) == 0 && (array[i + 1] & 1) == 1) {
				for (int j = i; j >= 0; j--) {
					if ((array[j] & 1) == 0) {
						array[j] = array[j] + array[j + 1];
						array[j + 1] = array[j] - array[j + 1];
						array[j] = array[j] - array[j + 1];
					} else {
						break;
					}
				}
			}
		}
	}
}
