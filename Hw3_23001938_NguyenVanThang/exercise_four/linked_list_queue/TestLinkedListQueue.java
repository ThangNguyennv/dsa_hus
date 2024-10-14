package Hw3_23001938_NguyenVanThang.exercise_four.linked_list_queue;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(1121);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(100);
        linkedListQueue.enqueue(4);
        linkedListQueue.enqueue(4);

        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
    }
}
