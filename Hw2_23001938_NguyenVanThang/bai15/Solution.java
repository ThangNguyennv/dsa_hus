package Hw2_23001938_NguyenVanThang.bai15;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int data;
    Node next, prev;
    Node(int data){
        this.data = data;
        next = null;
        prev = null;
    }
}

class MaximumFrequency{
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            String [] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);

            Node start = null;
            Node cur = null;
            Node ptr = null;
            str = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                ptr = new Node(a);
                if(start == null) {
                    start = ptr;
                    cur = ptr;
                }
                else {
                    cur.next=ptr;
                    ptr.prev=cur;
                    cur=ptr;
                }
            }
            Solution obj = new Solution();
            Node node = obj.rotateDLL(start, p);
            while(true)
            {
                System.out.print(node.data+" ");
                if(node.next == null)
                    break;
                node = node.next;
            }
            // while(node != null)
            // {
            // 	System.out.print(node.data+" ");
            //     node = node.prev;
            // }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
	int data;
	Node next, prev;
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
}
*/

class Solution{
    public Node rotateDLL(Node head, int N) {
        if (N == 0)
            return head;

        Node current = head;

        int count = 1;
        while (count < N && current != null) { // tìm node thứ N
            current = current.next;
            count++;
        }

        if (current == null)
            return head;

        Node NthNode = current; // lưu lại node thứ N

        while (current.next != null) { // tìm node cuối
            current = current.next;
        }

        // nối node cuối với node đầu
        current.next = head;
        (head).prev = current;

        // cập nhật head mới
        head = NthNode.next;
        (head).prev = null;

        // ngắt kết nối đầu phần cũ
        NthNode.next = null;

        return head;
    }
}