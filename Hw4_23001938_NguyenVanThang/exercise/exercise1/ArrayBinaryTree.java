package Hw4_23001938_NguyenVanThang.exercise.exercise1;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<Integer> {
    private E[] array;
    private int n = 0;
    private int default_size = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[default_size];
    }

    // update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree (at index 1)
        if (array[1] == null) {
            array[1] = element;
            n++;
        } else {
            System.out.println("Root đã tồn tại!");
            return;
        }
    }

    public void setLeft(int p, E element) {
        // Set left child of p (at index 2p)
        if (array[2 * p] == null) {
            array[2 * p] = element;
            n++;
        } else {
            System.out.println("Đã tồn tại node con trái!");
            return;
        }
    }

    public void setRight(int p, E element) {
        // Set right child of p (at index 2p+1)
        if (array[2 * p + 1] == null) {
            array[2 * p + 1] = element;
            n++;
        } else {
            System.out.println("Đã tồn tại node con phải!");
            return;
        }
    }

    @Override
    public Integer root() {
        return 1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Integer p) {
        if (array[2 * p] != null && array[2 * p + 1] != null)  {
            return 2;
        } else if (array[2 * p] != null || array[2 * p + 1] != null)  {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer parent(Integer p) {
        return p/2;
    }

    @Override
    public Integer left(Integer p) {
        return 2 * p;
    }

    @Override
    public Integer right(Integer p) {
        return 2 * p + 1;
    }

    @Override
    public Integer sibling(Integer p) {
        if (p % 2 == 0) {
            return p + 1;
        } else {
            return p - 1;
        }
    }
}
