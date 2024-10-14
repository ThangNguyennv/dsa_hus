package Hw2_23001938_NguyenVanThang.bai16_3;

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

class GFG {
    static void printList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int x = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make it circular
            Solution ob = new Solution();
            Node ans = ob.sortedInsert(head, x);
            printList(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        Node node = head;
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head;
        Node nextCur = head.next;
        if (data <= head.data) { // thêm vào đầu
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            newNode.next = head;
            lastNode.next = newNode;
            return newNode;
        }

        while (cur.next != head) { // thêm vào giữa
            if (data > cur.data && data <= nextCur.data) {
                newNode.next = cur.next;
                cur.next = newNode;
                return head;
            } else {
                cur = cur.next;
                nextCur = nextCur.next;
            }
        }

        newNode.next = head; // thêm vào cuối
        cur.next = newNode;
        return head;
    }
}