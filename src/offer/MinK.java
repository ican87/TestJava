package offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 最小的K个数
 * 
 * @author wanggang
 *
 */
public class MinK {
	public ArrayList<Integer> GetLeastNumbers (int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		if (input != null && input.length > 0) {
			for (int i = 0; i < input.length; i++) {
				if (set.size() < k) {
					set.add(input[i]);
				} else {
					if (set.size() > 0 && set.last() > input[i]) {
						set.pollLast();
						set.add(input[i]);
					}
				}
			}
			if (set.size() == k && k != 0) {
				list.addAll(set);
			}
		}
		return list;
	}
}
