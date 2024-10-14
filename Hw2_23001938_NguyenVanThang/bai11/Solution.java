package Hw2_23001938_NguyenVanThang.bai11;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public Solution() {

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public boolean isIdentical(ListNode node1, ListNode node2) {
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) { // Danh sách rỗng hoặc có 1 phần tử
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = reverseList(slow.next); // Head của danh sách sau được cắt từ vị trí giữa
        slow.next = null; // Cho vị trí cuối cùng của danh sách đầu trỏ tới null
        boolean check = isIdentical(head, head2);
        head2 = reverseList(head2); // Đảo ngược lại danh sách phía sau về ban đầu
        slow.next = head2; // nối lại 2 danh sách từ vị trí giữa
        return check;
    }
}