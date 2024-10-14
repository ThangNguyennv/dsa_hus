package Hw2_23001938_NguyenVanThang.bai16_2;

//{ Driver Code Starts
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Ignore the newline character after t

        for (int testCase = 0; testCase < t; testCase++) {
            int k = scanner.nextInt();
            scanner.nextLine(); // Ignore the newline character after k

            String inputLine = scanner.nextLine().trim();
            String[] inputArray = inputLine.split(" ");

            Node head = null, tail = null;
            if (inputArray.length > 0 && !inputArray[0].isEmpty()) {
                head = new Node(Integer.parseInt(inputArray[0]));
                tail = head;

                for (int i = 1; i < inputArray.length; i++) {
                    if (!inputArray[i].isEmpty()) {
                        tail.next = new Node(Integer.parseInt(inputArray[i]));
                        tail = tail.next;
                    }
                }

                if (k == 1 && head != null) {
                    tail.next = head;
                }
            }

            Solution solution = new Solution();
            boolean isCircular = solution.isCircular(head);
            System.out.println(isCircular ? "true" : "false");
        }
        scanner.close();
    }
}

// } Driver Code Ends


/* Structure of LinkedList
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    boolean isCircular(Node head) {
        // Your code here
        if (head == null) {
            return true;
        }
        Node node = head;
        while (head != null && head.next != node) {
            head = head.next;
        }
        if (head == null || head.next == null) {
            return false;
        }
        return true;
    }
}