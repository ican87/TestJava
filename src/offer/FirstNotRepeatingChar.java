package offer;

import java.util.HashMap;

public class FirstNotRepeatingChar {
	
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() <= 0) {
			return -1;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			if (map.get(key) == null) {
				map.put(key, 1);
			} else {
				map.put(key, 1 + map.get(key));
			}
		}
		
		for (int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			if (1 == map.get(key)) {
				return i;
			}
		}
		return -1;
	}

}
