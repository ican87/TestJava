package offer;

/**
 * 出现次数超过一半的数字
 * 
 * @author wanggang
 *
 */
public class MoreThanHalf {
	public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int data = array[0];
        int num = 1;
        for (int i = 1; i < array.length; i++) {
            if (data == array[i]) {
                num++;
            } else {
                num--;
                if (num == 0) {
                    data = array[i];
                    num = 1;
                }
            }
        }
        return data;
    }
}
