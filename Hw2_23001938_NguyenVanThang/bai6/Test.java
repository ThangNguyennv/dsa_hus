package Hw2_23001938_NguyenVanThang.bai6;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.printList();
        System.out.println();

        myLinkedList.addAtTail(0);
        myLinkedList.printList();
        System.out.println();

        myLinkedList.deleteAtIndex(1);
        myLinkedList.printList();
        System.out.println();

        myLinkedList.addAtTail(5);
        myLinkedList.printList();
        System.out.println();
    }
}
