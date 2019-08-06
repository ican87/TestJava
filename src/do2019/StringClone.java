package do2019;

/**
 * 1、输出结果如下：
 * 111-aaa
 * 222-bbb
 * false
 * 
 * 2、说明：
 * 由于String是不可变类，深拷贝的时候不需要对String进行特殊处理。
 * 
 * @author wanggang
 *
 */
public class StringClone {
	public static void main(String[] args) {
		B x = new StringClone().new B();
		B y = x.clone();
		y.a = 222;
		y.s = new String("bbb");
		System.out.println(x.a + "-" + x.s);
		System.out.println(y.a + "-" + y.s);
		System.out.println(x == y);
	}
	
	class B implements Cloneable {
		int a;
		String s;
		
		public B() {
			a = 111;
			s = new String("aaa");
		}
		
		@Override
		public B clone() {
			try {
				return (B) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
