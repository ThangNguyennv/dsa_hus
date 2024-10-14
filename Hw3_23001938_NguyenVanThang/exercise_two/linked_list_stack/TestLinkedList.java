package Hw3_23001938_NguyenVanThang.exercise_two.linked_list_stack;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedList = new LinkedListStack<>();
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(5);
        Integer x = 0;
        x += linkedList.pop();
        System.out.println(x); // 5
        System.out.println(linkedList.pop()); // 5 hay la 3 ?

    }
}
