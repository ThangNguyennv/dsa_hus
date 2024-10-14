package Hw2_23001938_NguyenVanThang.bai14_3;

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
            head = obj.sortedInsert(head, valueToInsert);
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
    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node newNode = new Node(x);
        if (head == null) { // trường hợp danh sách rỗng
            head = newNode;
        }
        Node cur = head;
        if (x <= head.data) { // thêm ở đầu
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            // them ở vị trí bất kì
            while (cur.next != null && cur.next.data < x) { // cho cur chạy
                cur = cur.next;
            }
            newNode.next = cur.next; // trỏ newNode tới node tiep theo
            if (cur.next != null) {
                cur.next.prev = newNode; // trỏ node tiếp ấy về lại newNode
            }
            cur.next = newNode; // trỏ cur sang newNode
            newNode.prev = cur; // trỏ newNode về lại cur
        }
        return head;
    }
}