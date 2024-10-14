package Hw3_23001938_NguyenVanThang.exercise_four.array_queue;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        for (Integer x : arrayQueue) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }
}
