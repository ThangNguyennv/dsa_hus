package Hw3_23001938_NguyenVanThang.exercise_four.linked_list_queue;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
