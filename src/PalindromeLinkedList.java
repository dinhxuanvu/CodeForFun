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
		ListNode two = new ListNode(2);
		ListNode mid = new ListNode(3);
		ListNode thr = new ListNode(2);
		ListNode fou = new ListNode(1);
		
		one.next = two;
		two.next = mid;
		mid.next = thr;
		thr.next = fou;
		
		System.out.println(isPalindrome(one));
		//System.out.println(isPalindrome2(one));
		printList(one);

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode second = slow.next;
		slow.next = null;
		
		ListNode node1 = second;
		ListNode node2 = node1.next;
		
		while (node1 != null && node2 != null) {
			ListNode temp = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = temp;
		}
		
		second.next = null;
		
		ListNode x = (node2 == null ? node1 : node2);
		ListNode y = head;
		
		while (x != null && y != null) {
			if (x.val != y.val) {
				return false;
			}
			x = x.next;
			y = y.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome2(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode node = head;
		ListNode previous = new ListNode(head.val);
		
		while (node.next != null) {
			ListNode newNode = new ListNode(node.next.val);
			newNode.next = previous;
			previous = newNode;
			node = node.next;
		}
		
		ListNode x = head;
		ListNode y = previous;
		
		while (x != null && y != null) {
			if (x.val != y.val) {
				return false;
			}
			x = x.next;
			y = y.next;
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
