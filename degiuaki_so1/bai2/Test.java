package degiuaki_so1.bai2;

public class Test {
    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        System.out.println(queue.isEmpty());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());

    }
}
