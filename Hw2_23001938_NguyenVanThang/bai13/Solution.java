package Hw2_23001938_NguyenVanThang.bai13;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int c, int p) {
        this.coeff = c;
        this.pow = p;
        this.next = null;
    }
}

class PolynomialUtils {

    // Method to append a new node to the linked list
    public static void append(Node[] head_ref, Node[] tail_ref, int new_data,
                              int new_data1) {
        Node new_node = new Node(new_data, new_data1);

        if (head_ref[0] == null) {
            head_ref[0] = new_node;
        } else {
            tail_ref[0].next = new_node;
        }
        tail_ref[0] = new_node;
    }

    // Method to print the polynomial
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coeff + "x^" + temp.pow);
            if (temp.next != null) {
                System.out.print(" + ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

class PolynomialAddition {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            Node[] poly1Head = {null};
            Node[] poly1Tail = {null};

            String[] input1 = br.readLine().trim().split(" ");
            for (int i = 0; i < input1.length; i += 2) {
                int coeff = Integer.parseInt(input1[i]);
                int pow = Integer.parseInt(input1[i + 1]);
                PolynomialUtils.append(poly1Head, poly1Tail, coeff, pow);
            }

            Node[] poly2Head = {null};
            Node[] poly2Tail = {null};

            String[] input2 = br.readLine().trim().split(" ");
            for (int i = 0; i < input2.length; i += 2) {
                int coeff = Integer.parseInt(input2[i]);
                int pow = Integer.parseInt(input2[i + 1]);
                PolynomialUtils.append(poly2Head, poly2Tail, coeff, pow);
            }

            Solution obj = new Solution();
            Node sum = obj.addPolynomial(poly1Head[0], poly2Head[0]);

            PolynomialUtils.printList(sum);
        }
    }
}

// } Driver Code Ends


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

// Print the polynomial formed by adding both LL in the function itself.
class Solution {
    public static Node addPolynomial(Node head1, Node head2) {
        // Add your code here.
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.pow > head2.pow) {
            Node nextPointer = addPolynomial(head1.next, head2);
            head1.next = nextPointer;
            return head1;
        } else if (head2.pow > head1.pow) {
            Node nextPointer = addPolynomial(head1, head2.next);
            head2.next = nextPointer;
            return head2;
        }
        Node nextPointer = addPolynomial(head1.next, head2.next);
        head1.coeff += head2.coeff;
        head1.next = nextPointer;
        return head1;
    }
}