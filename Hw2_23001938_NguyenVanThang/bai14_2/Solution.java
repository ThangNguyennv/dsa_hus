package Hw2_23001938_NguyenVanThang.bai14_2;

//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.deleteNode(head, valueToInsert);
            printList(head);
        }

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // add your code here
        if (head == null) { // nếu danh sách rỗng
            return null;
        }
        Node cur = head;
        int count = 1;
        while (cur != null && count < x) { // Di chuyển node đến vị trí đã chọn(thằng cần xóa)
            cur = cur.next;
            count++;
        }
        if (cur == null) { // Nếu vị trí đã chọn nằm ngoài mảng
            return head;
        }
        if (head == cur) { // Nếu node xóa nằm ở đầu tiên
            head = cur.next;
        }
        // Thao tác xóa thằng ở giữa(2), cầu nối thằng 1 với 3
        if (cur.prev != null) {
            cur.prev.next = cur.next;
        }
        if (cur.next != null) {
            cur.next.prev = cur.prev;
        }
        return head;
    }
}