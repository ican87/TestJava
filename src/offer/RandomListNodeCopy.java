package offer;

/**
 * 复杂链表复制
 * 
 * @author wanggang
 *
 */
public class RandomListNodeCopy {
	public RandomListNode Clone(RandomListNode pHead) {
		copy(pHead);
		random(pHead);
		return detach(pHead);
	}
	
	private void copy(RandomListNode pHead) {
		RandomListNode p = pHead;
		while (null != p) {
			RandomListNode node = new RandomListNode();
			node.label = p.label;
			node.next = p.next;
			node.random = null;
			p.next = node;
			p = node.next;
		}
	}
	
	private void random(RandomListNode pHead) {
		RandomListNode p = pHead;
		RandomListNode node;
		while (null != p) {
			node = p.next;
			if (p.random != null) {
				node.random = p.random.next;
			}
			p = node.next;
		}
	}
	
	private RandomListNode detach(RandomListNode pHead) {
		if (null != pHead) {
			RandomListNode p = pHead;
			RandomListNode p1;
			RandomListNode p2;
			p1 = p2 = p.next;
			p.next = p2.next;
			p = p2.next;
			while (null != p) {
				p2.next = p.next;
				p2 = p2.next;
				p.next = p2.next;
				p = p.next;
			}
			return p1;
		} else {
			return null;
		}
	}

	class RandomListNode {
		int label;
		RandomListNode next;
		RandomListNode random;
	}
}
