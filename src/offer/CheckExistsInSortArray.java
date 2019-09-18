package offer;

/**
 * 题目：给定一个这样的二维数组，从左到右是升序，从上到下也是升序，求二维数组中是否存在数字data。
 * 
 * @author wanggang
 *
 */
public class CheckExistsInSortArray {

	public static void main(String[] args) {
		int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(isExists(a, 7));
		System.out.println(isExists(a, 0));
	}
	
	public static boolean isExists(int a[][], int data) {
        boolean isExists = false;
        int row = a.length;
        int column = a[0].length;
        int r = 0;
        int c = column - 1;
        while (r < row && c >= 0) {
            if (a[r][c] == data) {
                isExists = true;
                break;
            } else if (a[r][c] < data) {
                r++;
            } else {
                c--;
            }
        }
        return isExists;
    }

}
