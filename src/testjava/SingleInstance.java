package testjava;

/**
 * 采用静态内部类构造单例
 * @author wanggang
 *
 */
public class SingleInstance {
	private SingleInstance() {
		//
	}
	private static class Factory {
		public static SingleInstance instance = new SingleInstance();
	}
	public static SingleInstance getInstance() {
		return Factory.instance;
	}
}

/**
 * 饿汉式
 * @author wanggang
 *
 */
class SingleInstance1 {
	private SingleInstance1() {
		//
	}
	private static final SingleInstance1 instance = new SingleInstance1();
	public static SingleInstance1 getInstance() {
		return instance;
	}
}

/**
 * 懒汉式
 * @author wanggang
 *
 */
class SingleInstance2 {
	private SingleInstance2() {
		//
	}
	private static volatile SingleInstance2 instance = null;
	public static SingleInstance2 getInstance() {
		if (instance == null) {
			synchronized (SingleInstance2.class) {
				if (instance == null) {
					instance = new SingleInstance2();
				}
			}
		}
		return instance;
	}
}
