package Hw3_23001938_NguyenVanThang.exercise_five;

import Hw3_23001938_NguyenVanThang.exercise_four.array_queue.ArrayQueue;
import Hw3_23001938_NguyenVanThang.exercise_two.array_stack.ArrayStack;

public class Palindrome {
    public static boolean isPalindrome(String strings) {

        ArrayQueue arrayQueue = new ArrayQueue(10);
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < strings.length(); i++) {
            arrayQueue.enqueue(strings.charAt(i));
            arrayStack.push(strings.charAt(i));
        }
        while (!arrayStack.isEmpty() && !arrayQueue.isEmpty()) {
            if (arrayStack.pop() != arrayQueue.dequeue()) {
                return false;
            } 
        }
        return true;
    }
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String s = "123454321";
        System.out.println(isPalindrome(s));
    }
}
