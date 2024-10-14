package Hw2_23001938_NguyenVanThang.bai3;

import Hw2_23001938_NguyenVanThang.bai6.MyLinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList myLinkedList = new SimpleLinkedList();
        myLinkedList.add(7);
        myLinkedList.printList();
        System.out.println();

        myLinkedList.addBot(0);
        myLinkedList.addBot(1);
        myLinkedList.addBot(2);
        myLinkedList.printList();
        System.out.println();

        myLinkedList.removeOfIndex(2);
        myLinkedList.addAtIndex(1, 129);
        myLinkedList.printList();
        System.out.println();
        myLinkedList.removeTop();
        myLinkedList.printList();
        System.out.println();



    }
}
