package Hw2_23001938_NguyenVanThang.bai17;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}

class GFG {
    public static void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    public static Node newNode(int key) { return new Node(key); }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String input = br.readLine();
            String[] tokens = input.split(" ");
            int[] arr = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

            Node temp = null, head = null;
            if (arr.length > 0) {
                head = new Node(arr[0]);
                temp = head;
                for (int i = 1; i < arr.length; i++) {
                    temp.next = new Node(arr[i]);
                    temp = temp.next;
                }
                temp.next = head;
            }

            Solution ob = new Solution();
            Pair<Node, Node> result = ob.splitList(head);
            Node head1 = result.first;
            Node head2 = result.second;
            printList(head1);
            printList(head2);
        }
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node slow = head;
        Node fast = head;
        if (head == null) {
            return new Pair<>(null, null);
        }

        // số node chẵn => fast.next = head
        // số node lẻ => fast.next.next = head
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next.next == head) {
            fast = fast.next;
        }
        Node head1 = head; // con trỏ đầu nửa đầu
        Node head2 = slow.next; // còn trỏ đầu nửa sau

        fast.next = slow.next; // tạo liên kết vòng nửa thứ 2
        slow.next = head; // tạo liên kết vòng nửa đầu tiên

        return new Pair<>(head1, head2);
    }
}