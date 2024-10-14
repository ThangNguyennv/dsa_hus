package Hw2_23001938_NguyenVanThang.bai14_1;

//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class DLinkedList {

    Node newNode(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return head;
        }
        head.next = n;
        n.prev = head;
        head = n;
        return head;
    }

    void printList(Node node) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp.prev != null) {
            temp = temp.prev;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        DLinkedList DLL = new DLinkedList();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            Node temp;
            Node head = null;
            Node root = null;
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(str[i]);
                head = DLL.newNode(head, x);
                if (root == null) root = head;
            }
            head = root;

            String str2[] = read.readLine().trim().split(" ");
            int pos = Integer.parseInt(str2[0]);
            int data = Integer.parseInt(str2[1]);

            Solution g = new Solution();
            head = g.addNode(head, pos, data);

            DLL.printList(head);
            while (head.next != null) {
                temp = head;
                head = head.next;
            }
            t--;
        }
    }
}
// } Driver Code Ends


/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node newNode = new Node(x);
        if (p == 1) { // pos = 1
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return head;
        }
        Node cur = head;
        int count = 1;
        while (cur != null && count < p - 1) { // chạy đến trước vị trí thêm vào
            cur = cur.next;
            count++;
        }
        if (cur == null) {
            System.out.println("Position is out of bound!!!");
            return head;
        }
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next = newNode;
        if (newNode.next != null) {
            cur.next.prev = newNode;
        }
        return head;
    }
}