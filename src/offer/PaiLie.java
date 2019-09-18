package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PaiLie {
	//way1：递归
	public ArrayList<String> fun(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str != null && str.length() > 0) {
			//step1
			pailie1(str.toCharArray(), 0, list);
			//step2
			HashSet<String> set = new HashSet<>(list);
			list = new ArrayList<>(set);
			//step3
			Collections.sort(list);
		}
		return list;
	}
	
	private void pailie1(char[] a, int i, ArrayList<String> list) {
		if (i == a.length - 1) {
			list.add(String.valueOf(a));
		} else {
			for (int j = i; j < a.length; j++) {
				if (j == i || a[j] != a[i]) {
					swap(a, i, j);
					pailie1(a, i + 1, list);
					swap(a, i, j);
				}
			}
		}
	}
	
	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//way2：字典序
	public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            list.add(String.valueOf(a));
            int n = a.length;
            int from, to ,change;
            while (true) {
                from = to = n - 1;
                while (from > 0 && a[from - 1] >= a[from]) {
                    from--;
                }
                if (from == 0) {
                    break;
                }
                change = from;
                while (change + 1 < n && a[change + 1] > a[from - 1]) {
                    change++;
                }
                swap(a, from - 1, change);
                reverse(a, from, to);
                list.add(String.valueOf(a));
            }
        }
        return list;
    }

    private void reverse(char[] a, int from, int to) {
        for (int i = 0; i < (to - from + 1) / 2; i++) {
            swap(a, from + i, to - i);
        }
    }

}
