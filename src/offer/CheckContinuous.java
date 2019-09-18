package offer;

import java.util.Arrays;

public class CheckContinuous {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		Arrays.sort(numbers);
		int gap = 0;
		int zero = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				zero++;
			}
		}
		int samll = zero;
		int big = samll + 1;
		while (big < numbers.length) {
			if (numbers[samll] == numbers[big]) {
				return false;
			}
			gap += (numbers[big] - numbers[samll] - 1);
			big++;
			samll++;
		}
		return zero >= gap;
	}

}
