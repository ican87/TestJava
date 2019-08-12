package algorithm;

/**
 * 七大排序算法：冒择入希快归堆
 * 
 * @author wanggang
 *
 */
public class SevenSorts {
	public static void main(String[] args) {
		int[] a = { 4, 2, 5, 8, 6, 9, 0, 3, 1, 7 };
		//maopao(a);
		//select(a);
		//insert(a);
		//shell(a);
		//fast(a, 0, a.length - 1);
		twoSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		
//		//下面验证堆排序，注意是从b[1]至b[10]，b[0]不参与
//		int[] b = {-1111, 4, 2, 5, 8, 6, 9, 0, 3, 1, 7 };
//		heap(b, 10);
//		System.out.println("堆排序-----");
//		for (int i = 1; i <= 10; i++) {
//			System.out.print(b[i]);
//		}
		
	}
	
	//1.冒泡排序
	private static void maopao(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					a[j] = a[j] + a[j + 1];
					a[j + 1] = a[j] - a[j + 1];
					a[j] = a[j] - a[j + 1];
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}
	
	//2.选择排序
	private static void select(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int k = i;
			for (int j = i + 1; j < n; j++) {
				if (a[k] > a[j]) {
					k = j;
				}
			}
			if (k != i) {
				a[k] = a[k] + a[i];
				a[i] = a[k] - a[i];
				a[k] = a[k] - a[i];
			}
		}
	}
	
	//3.插入排序
	private static void insert(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}
	
	//4.希尔排序
	private static void shell(int[] a) {
		int n = a.length;
		for (int step = n / 2; step > 0; step /= 2) {
			for (int i = step; i < n; i++) {
				int temp = a[i];
				int j = i - step;
				while (j >= 0 && temp < a[j]) {
					a[j + step] = a[j];
					j -= step;
				}
				a[j + step] = temp;
			}
		}
	}
	
	//5.快速排序
	private static void fast(int[] a, int low, int high) {
		if (low < high) {
			int position = onceFast(a, low, high);
			fast(a, low, position - 1);
			fast(a, position + 1, high);
		}
	}
	
	//一次快速排序
	private static int onceFast(int[] a, int low, int high) {
		int temp = a[low];
		while (low < high) {
			while (low < high && temp <= a[high]) {
				high--;
			}
			if (low < high) {
				a[low] = a[high];
				low++;
			}
			while (low < high && temp >= a[low]) {
				low++;
			}
			if (low < high) {
				a[high] = a[low];
				high--;
			}
		}
		a[low] = temp;
		return low;
	}
	
	//6.二路归并排序
	private static void twoSort(int[] a, int low, int high) {
		if (low < high) {
			int mid = ((low + high) >> 1);
			twoSort(a, low, mid);
			twoSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}
	
	private static void merge(int[]a, int low, int mid, int high) {
		int[] b = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
			}
		}
		while (i <= mid) {
			b[k++] = a[i++];
		}
		while (j <= high) {
			b[k++] = a[j++];
		}
		for (int x = 0; x < k; x++) {
			a[low++] = b[x];
		}
	}
	
	//7.堆排序
	//注意：这里使用的是 a[1] ~ a[n]
	private static void heap(int[] a, int n) {
		for (int i = n / 2; i > 0; i--) {
			adjust(a, i, n);
		}
		for (int i = n; i > 1; i--) {
			a[1] = a[1] + a[i];
			a[i] = a[1] -a[i];
			a[1] = a[1] - a[i];
			adjust(a, 1, i - 1);
		}
	}
	
	//调整堆
	private static void adjust(int[] a, int x, int y) {
		int temp = a[x];
		for (int i = 2 * x; i <= y; i *= 2) {
			if (i < y && a[i] < a[i + 1]) {
				i++;
			}
			if (temp >= a[i]) {
				break;
			}
			a[x] = a[i];
			x = i;
		}
		a[x] = temp;
	}

}
