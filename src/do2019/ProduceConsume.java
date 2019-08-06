package do2019;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者
 * 
 * 采用 ReentrantLock + Condition 实现
 * 
 * @author wanggang
 *
 */
public class ProduceConsume {
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	
	private Object[] buffer = new Object[100];
	private int count, in, out;
	
	/**
	 * 生产者
	 * @param x
	 * @throws InterruptedException
	 */
	public void produce(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == buffer.length) {
				notFull.await();
			}
			buffer[in] = x;
			if (++in == buffer.length) {
				in = 0;
			}
			count++;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * 消费者
	 * @return
	 * @throws InterruptedException
	 */
	public Object consume() throws InterruptedException {
		Object x = null;
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.await();
			}
			x = buffer[out];
			if (++out == buffer.length) {
				out = 0;
			}
			count--;
			notFull.signal();
		} finally {
			lock.unlock();
		}
		return x;
	}

}
