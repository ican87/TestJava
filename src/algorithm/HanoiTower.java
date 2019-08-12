package algorithm;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 汉诺塔：
 * 1、将盘子一个一个地从A柱子移动到B柱子，移动过程中，可以使用C柱。
 * 2、每个盘子只能放在比它大的盘子上面
 * 3、递归思想
 * 
 * @author wanggang
 *
 */
public class HanoiTower {
	//从x移动到z，借助于y。使用递归方法。
	public void hanoi(int n, char x, char y, char z) {
		if (n == 1) {
			move(1, x, z);
		} else {
			hanoi(n - 1, x, z, y);
			move(n, x, z);
			hanoi(n - 1, y, x, z);
		}
	}
	
	private void move(int i, char m, char n) {
		//
	}
	
}
