package Hw5_23001938_NguyenVanThang.exercise.exercise2;

public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, Integer> minHeap = new MinHeapPriorityQueue<>();
        minHeap.insert(3111, 2);
        minHeap.insert(10, 3);
        minHeap.insert(1114, 5);
        minHeap.insert(12, 42);
        minHeap.print();
        System.out.println();
        System.out.println(minHeap.removeMin());
        System.out.println();
        minHeap.print();
    }
}
