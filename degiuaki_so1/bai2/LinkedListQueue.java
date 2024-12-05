package degiuaki_so1.bai2;

public class LinkedListQueue<T> implements QueueInterface<T>{

    class Node {
        T element;
        Node next;

        public Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }
    }

    private Node top;
    private Node bot;
    private int n;

    public LinkedListQueue() {
        n = 0;
        top = null;
        bot = null;
    }

    @Override
    public void enqueue(T element) { // them vao cuoi
        // TODO Auto-generated method stub
        Node newNode = new Node(element);
        if (isEmpty()) {
            top = bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    @Override
    public T dequeue() { // xoa o dau
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }
        Node node = top;
        T temp = node.element;
        top = top.next;
        n--;
        if (top == null) {
            bot = null;
        }
        return temp;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public void printList() {
        Node node = top;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
    }
}