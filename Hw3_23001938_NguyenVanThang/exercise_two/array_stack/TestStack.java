package Hw3_23001938_NguyenVanThang.exercise_two.array_stack;

public class TestStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
