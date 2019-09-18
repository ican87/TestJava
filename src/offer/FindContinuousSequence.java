package offer;

import java.util.ArrayList;

public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (sum < 3) {
			return list;
		}
		int mid = (sum + 1) >> 1;
		int begin = 1;
		int end = 2;
		int curSum = begin + end;
		while (begin < mid) {
			if (sum == curSum) {
				list.add(add(begin, end));
			}
			while (begin < mid && curSum > sum) {
				curSum -= begin;
				begin++;
				if (curSum == sum) {
					list.add(add(begin, end));
				}
			}
			end++;
			curSum += end;
		}
		return list;
	}
	
	private ArrayList<Integer> add(int begin, int end) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = begin; i <= end; i++) {
			list.add(i);
		}
		return list;
	}

}
