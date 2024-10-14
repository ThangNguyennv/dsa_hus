package Hw2_23001938_NguyenVanThang.bai12;

class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == (node.next).val) {
                ListNode nextnext = node.next.next;
                node.next = nextnext;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}