package Hw3_23001938_NguyenVanThang.exercise_two.array_stack;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop(); // xoa ptu tren cung
    public boolean isEmpty();
    public E top();
}
