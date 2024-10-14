package Hw3_23001938_NguyenVanThang.exercise_two.linked_list_stack;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
