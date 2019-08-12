package testjava;

/**
 * 原型设计模式
 * @author wanggang
 *
 */
public class ProtoType implements Cloneable {
	public ProtoType clone() throws CloneNotSupportedException {
		ProtoType object = (ProtoType) super.clone();
		return object;
	}
}
