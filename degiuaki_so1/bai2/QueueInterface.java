package degiuaki_so1.bai2;

public interface QueueInterface<T> {
    public void enqueue(T element);
    public T dequeue();
    public boolean isEmpty();
}