class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(0);
		ListNode mid = new ListNode(2);
		ListNode thr = new ListNode(0);
		ListNode fou = new ListNode(1);
		
		one.next = two;
		two.next = mid;
		mid.next = thr;
		thr.next = fou;
		
		System.out.println(isPalindrome(one));
		printList(one);

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		// reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		// compare two sublists now
		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;

			p = p.next;
			q = q.next;

		}

		return true;
	}
	
	public static void printList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		
	}

}
