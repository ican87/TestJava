package testjava;

/**
 * 子类与父类，加载顺序及初始化顺序
 * 
 * @author wanggang
 *
 */

/**输出结果如下：
A-静态成员
B-静态成员
-------------------
A-非静态成员
A-构造函数
B-非静态成员
B-构造函数
-------------------
A-非静态成员
A-构造函数
B-非静态成员
B-构造函数-带参数
a=1.0,b=2.0
a=3.0,b=4.0
 */
class A {
	{System.out.println("A-非静态成员");}
	static {System.out.println("A-静态成员");}
	public A() {
		System.out.println("A-构造函数");
	}
}
public class B extends A {
	private double a = 1.0;
	private double b = 2.0;
//	private double a;
//	private double b;
	{System.out.println("B-非静态成员");}
	static {System.out.println("B-静态成员");}
	public B() {
		System.out.println("B-构造函数");
	}	
	public B(double x, double y) {
		System.out.println("B-构造函数-带参数");
		System.out.println("a="+a+",b="+b);
		a = x;
		b = y;
		System.out.println("a="+a+",b="+b);
	}
	public static void main(String[] args) {
		System.out.println("-------------------");
		A a = new B();
		System.out.println("-------------------");
		A x = new B(3.0, 4.0);
	}
}

