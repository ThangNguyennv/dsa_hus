package Hw3_23001938_NguyenVanThang.practice_one;

import Hw3_23001938_NguyenVanThang.exercise_four.array_queue.ArrayQueue;

import java.util.*;

public class MoveKTimes {
    public static String move(int[] a, int k) {
       String result = "";

        ArrayQueue queue1 = new ArrayQueue();
        for (int i = 0; i < a.length; i++) {
            queue1.enqueue(a[i]);
        }
        for (int i = 0; i < k; i++) {
            int x = (int) queue1.dequeue();
            queue1.enqueue(x);
        }
        while (!queue1.isEmpty()) {
            result = result + queue1.dequeue() + " ";
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(move(a, k));
    }
}
