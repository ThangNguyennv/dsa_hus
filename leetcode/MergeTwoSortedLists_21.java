package leetcode;

public class MergeTwoSortedLists_21 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        if (list1 == null && list2 == null) {
            return null;
        } else {
            if (list1 == null && list2 != null) {
                return list2;
            } else if (list2 == null && list1 != null) {
                return list1;
            } else {
                while (list1.next != null && list2.next != null) {
                    if (list2.val == list1.val) {
                        list2.next = list1;
                        list1 = list1.next;
                    } else if (list2.val < list1.val) {
                        list2.next = list1;
                        list2 = list2.next;
                    }
                }
                return list1;
            }

        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        System.out.println();
    }
}
