package do2019;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程连续输出10次ABC
 * 
 * 本例采用最简单的方式 lock对num加锁
 * @author wanggang
 *
 */
public class PrintABCABC {
	private static int num = 0;
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		Thread threadA = new Thread() {
			@Override
			public void run() {
				while (num < 30) {
					lock.lock();
					try {
						if (num < 30 && num % 3 == 0) {
							System.out.print("A");
							num++;
						}
					} finally {
						lock.unlock();
					}
				}
			}
		};
		Thread threadB = new Thread() {
			@Override
			public void run() {
				while (num < 30) {
					lock.lock();
					try {
						if (num < 30 && num % 3 == 1) {
							System.out.print("B");
							num++;
						}
					} finally {
						lock.unlock();
					}
				}
			}
		};
		Thread threadC = new Thread() {
			@Override
			public void run() {
				while (num < 30) {
					lock.lock();
					try {
						if (num < 30 && num % 3 == 2) {
							System.out.print("C ");
							num++;
						}
					} finally {
						lock.unlock();
					}
				}
			}
		};
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}
