package offer;

public class FindFirstCommonNode {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		int len1 = 0;
		int len2 = 0;
		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}
		while (len1 > len2) {
			len1--;
			pHead1 = pHead1.next;
		}
		while (len2 > len1) {
			len2--;
			pHead2 = pHead2.next;
		}
		while (len1 > 0) {
			if (pHead1 == pHead2) {
				return pHead1;
			} else {
				len1--;
				pHead1 = pHead1.next;
				pHead2 = pHead2.next;
			}
		}
		return null;
	}
}
