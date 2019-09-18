package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNum {
	
	public String PrintMinNumber1(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return "";
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			builder.append(list.get(i));
		}
		return builder.toString();
	}
	
	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return "";
		}
		String[] strings = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strings[i] = numbers[i] + "";
		}
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			builder.append(strings[i]);
		}
		return builder.toString();
	}
	
}
