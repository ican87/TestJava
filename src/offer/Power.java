package offer;

/**
 * 数的N次幂
 * 
 * @author wanggang
 *
 */
public class Power {
	public double Power(double base, int exponent) {
		if (isEqual(base, 0) && exponent < 0) {
			return 0;
		}
		if (exponent < 0) {
			return 1 / getValue(base, -exponent);
		} else {
			return getValue(base, exponent);
		}
	}
	
	private double getValue(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent == 1) {
			return base;
		} else {
			double result = getValue(base, exponent >> 1);
			result *= result;
			if ((exponent & 1) != 0) {
				result = result * base;
			}
			return result;
		}
	}
	
	private boolean isEqual(double d1, double d2) {
		if (d1 - d2 > -0.0000001 && d1 - d2 < 0.0000001) {
			return true;
		} else {
			return false;
		}
	}
}
