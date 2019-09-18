package offer;

/**
 * 旋转数组中最小值
 * 例如：{3,4,5,1,2}是{1,2,3,4,5}的一个旋转数组
 * 思想: 采用二分查找
 * 
 * @author wanggang
 *
 */
public class MinInRotateArray {
	public int minNumberInRotateArray(int [] array) {
		if (array == null || array.length <= 0) {
			return 0;
		}
		int begin = 0;
		int end = array.length - 1;
		while (array[begin] >= array[end]) {
			if (begin + 1 == end) {
				return array[end];
			}
			int mid = ((begin + end) >> 1);
			if (array[begin] == array[mid] && array[end] == array[mid]) {
				return minNum(array, begin, end);
			}
			//注意下面判断不能是>=
			if (array[begin] > array[mid]) {
				end = mid;
			} else {
				begin = mid;
			}
		}
		return array[begin];
	}
	
	private int minNum(int[] array, int begin, int end) {
		int min = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (min > array[i]) {
				min = array[i];
				break;
			}
		}
		return min;
	}
}
