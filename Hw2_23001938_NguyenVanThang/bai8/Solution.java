package Hw2_23001938_NguyenVanThang.bai8;

//{ Driver Code Starts
// Initial Template for Java

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;



// } Driver Code Ends
/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
    }
}
class Solution {
    // Function to find the data of kth node from
    // the end of a linked list.
    public int getKthFromLast(Node head, int k) {
        // Your code here
       int len = 0;
       Node node = head;
       while (node != null) {
           node = node.next;
           len++;
       }
       if (len < k) {
           return -1;
       }
       node = head;
       for (int i = 1; i < len - k + 1; i++) {
           node = node.next;
       }
       return node.data;
    }
}


//{ Driver Code Starts.

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            int x = Integer.parseInt(br.readLine().trim());

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }

            Solution g = new Solution();
            // System.out.println(k);
            System.out.println(g.getKthFromLast(head, x));
        }
    }
}

// } Driver Code Ends