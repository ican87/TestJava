package offer;

/**
 * 一个整数的二进制表示含有几个1
 * 
 * @author wanggang
 *
 */
public class NumHasOneCount {
	public int NumberOf1(int n) {
		int count = 0;
		int move = 1;
		while (move != 0) {
			if ((move & n) != 0) {
				count++;
			}
			move = (move << 1);
		}
		return count;
	}
	
	//下面更高效
	public int NumOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
